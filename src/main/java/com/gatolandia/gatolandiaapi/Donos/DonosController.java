package com.gatolandia.gatolandiaapi.Donos;

import com.gatolandia.gatolandiaapi.common.ApiMessageResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Endpoints responsáveis pelo gerenciamento dos donos de gatos.
 */
@RestController
@RequestMapping
@Tag(name = "Donos", description = "Operações de CRUD para os donos cadastrados")
@SecurityRequirement(name = "bearerAuth")
public class DonosController {

    private final DonosService donosService;

    public DonosController(DonosService donosService) {
        this.donosService = donosService;
    }

    @GetMapping("donos/exibir")
    @Operation(summary = "Lista todos os donos",
            description = "Retorna todos os donos cadastrados na aplicação.")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = DonosDTO.class))))
    public ResponseEntity<List<DonosDTO>> exibirDonos() {
        List<DonosDTO> donos = donosService.listarDonos();
        return ResponseEntity.status(HttpStatus.OK).body(donos);
    }

    @GetMapping("donos/exibir/{id}")
    @Operation(summary = "Busca dono por identificador",
            description = "Retorna um dono específico caso seja encontrado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Dono encontrado",
                    content = @Content(schema = @Schema(implementation = DonosDTO.class))),
            @ApiResponse(responseCode = "404", description = "Dono não encontrado")
    })
    public ResponseEntity<?> exibirDonosPorId(@PathVariable long id) {
        DonosDTO dono = donosService.exibirPorId(id);
        if (dono != null) {
            return ResponseEntity.ok().body(dono);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiMessageResponse.of("DONO_NAO_ENCONTRADO", "Nenhum dono encontrado."));
        }
    }

    @PostMapping("donos/adicionar")
    @Operation(summary = "Cadastra um novo dono",
            description = "Adiciona um novo responsável pelos gatos.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Dono cadastrado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<ApiMessageResponse> adicionarDonos(@RequestBody DonosDTO donosDTO) {
        donosService.adicionarDonos(donosDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiMessageResponse.of("DONO_CADASTRADO", "Dono adicionado com sucesso."));
    }

    @PutMapping("donos/editar/{id}")
    @Operation(summary = "Atualiza um dono",
            description = "Edita os dados de um dono previamente cadastrado.")
    @ApiResponses({
            @ApiResponse(responseCode = "202", description = "Dono atualizado"),
            @ApiResponse(responseCode = "404", description = "Dono não encontrado")
    })
    public ResponseEntity<ApiMessageResponse> editarDonos(@RequestBody DonosDTO donoAtualizado, @PathVariable long id) {
        DonosDTO donoAtualizadoResponse = donosService.editarDonos(donoAtualizado, id);
        if (donoAtualizadoResponse != null) {
            return  ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(ApiMessageResponse.of("DONO_ATUALIZADO", "Dono atualizado com sucesso."));
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiMessageResponse.of("DONO_NAO_ENCONTRADO", "Dono não encontrado."));
        }
    }

    @DeleteMapping("donos/excluir/{id}")
    @Operation(summary = "Remove um dono",
            description = "Exclui o registro do dono informado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Dono excluído"),
            @ApiResponse(responseCode = "404", description = "Dono não encontrado")
    })
    public ResponseEntity<ApiMessageResponse> excluirDonosPorId(@PathVariable long id) {
        if (donosService.excluirDonosPorId(id)) {
            return ResponseEntity.ok(ApiMessageResponse.of("DONO_EXCLUIDO", "Dono de ID " + id + " excluído com sucesso."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiMessageResponse.of("DONO_NAO_ENCONTRADO", "Dono não encontrado."));
        }
    }
}
