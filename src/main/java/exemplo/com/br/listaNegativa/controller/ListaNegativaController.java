package exemplo.com.br.listaNegativa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import exemplo.com.br.listaNegativa.repository.ListaNegativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
public class ListaNegativaController {

    private final ListaNegativaRepository listaNegativaRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public ListaNegativaController(ListaNegativaRepository listaNegativaService, ObjectMapper objectMapper){
        this.listaNegativaRepository = listaNegativaService;
        this.objectMapper = objectMapper;
    }

    @GetMapping()
    public ResponseEntity<JsonNode> consultarListaNegativa(@RequestBody JsonNode inputPayload) throws JsonProcessingException {
        var consulta = listaNegativaRepository
                .chamarProcedure(inputPayload.toString());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(objectMapper.readTree(consulta));
    }
}

