package exemplo.com.br.listaNegativa.controller;

import com.fasterxml.jackson.databind.JsonNode;
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

    @Autowired
    public ListaNegativaController(ListaNegativaRepository listaNegativaService){
        this.listaNegativaRepository = listaNegativaService;
    }

    @GetMapping()
    public ResponseEntity<String> consultarListaNegativa(@RequestBody JsonNode inputPayload){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listaNegativaRepository.chamarProcedure(inputPayload.toString()));
    }
}

