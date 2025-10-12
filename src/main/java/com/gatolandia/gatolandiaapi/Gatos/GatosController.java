package com.gatolandia.gatolandiaapi.Gatos;

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
 * Endpoints responsáveis pelo gerenciamento de gatos.
 */
@RestController
@RequestMapping
@Tag(name = "Gatos", description = "Operações de CRUD para gatos cadastrados")
@SecurityRequirement(name = "bearerAuth")
public class GatosController {

    private final GatosService gatosService;

    public GatosController(GatosService gatosService) {
        this.gatosService = gatosService;
    }

    @GetMapping("gatos/exibir")
    @Operation(summary = "Lista todos os gatos",
            description = "Retorna a lista completa de gatos registrados na base.")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = GatosDTO.class))))
    public ResponseEntity<List<GatosDTO>> exibirGatos() {
        List<GatosDTO> gatos = gatosService.listarGatos();
        return ResponseEntity.status(HttpStatus.OK).body(gatos);
    }

    @GetMapping("gatos/exibir/{id}")
    @Operation(summary = "Busca gato por identificador",
            description = "Retorna um gato específico caso o identificador exista.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Gato encontrado",
                    content = @Content(schema = @Schema(implementation = GatosDTO.class))),
            @ApiResponse(responseCode = "404", description = "Gato não encontrado")
    })
    public ResponseEntity<?> exibirGatosPorId(@PathVariable long id) {
        GatosDTO gatos = gatosService.exibirPorId(id);
        if (gatos != null) {
            return ResponseEntity.status(HttpStatus.OK).body(gatos);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiMessageResponse.of("GATO_NAO_ENCONTRADO", "Nenhum gato encontrado."));
        }
    }

    @PostMapping("gatos/adicionar")
    @Operation(summary = "Cadastra um novo gato",
            description = "Adiciona um gato à base de dados.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Gato cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<ApiMessageResponse> adicionarGatos(@RequestBody GatosDTO gatos) {
        gatosService.adicionarGatos(gatos);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiMessageResponse.of("GATO_CADASTRADO", "Gato adicionado com sucesso."));
    }

    @PutMapping("gatos/editar/{id}")
    @Operation(summary = "Atualiza os dados de um gato",
            description = "Edita as informações de um gato já existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Gato atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Gato não encontrado")
    })
    public ResponseEntity<ApiMessageResponse> editarGatos(@RequestBody GatosDTO gatoAtualizado, @PathVariable long id) {
        GatosDTO gatoAtualizadoResponse = gatosService.editarGatos(gatoAtualizado, id);
        if (gatoAtualizadoResponse != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ApiMessageResponse.of("GATO_ATUALIZADO", "Gato atualizado com sucesso."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiMessageResponse.of("GATO_NAO_ENCONTRADO", "Gato não encontrado."));
        }
    }

    @DeleteMapping("gatos/excluir/{id}")
    @Operation(summary = "Remove um gato",
            description = "Exclui o registro de um gato conforme o identificador informado.")
    @ApiResponses({
            @ApiResponse(responseCode = "202", description = "Gato excluído"),
            @ApiResponse(responseCode = "404", description = "Gato não encontrado")
    })
    public ResponseEntity<ApiMessageResponse> excluirGatosPorId(@PathVariable long id) {
        if (gatosService.excluirGatosPorId(id)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(ApiMessageResponse.of("GATO_EXCLUIDO", "Gato excluído com sucesso."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiMessageResponse.of("GATO_NAO_ENCONTRADO", "Gato não encontrado."));
        }
    }

}
