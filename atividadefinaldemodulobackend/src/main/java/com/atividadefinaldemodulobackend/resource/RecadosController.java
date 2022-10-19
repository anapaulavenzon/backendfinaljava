package com.atividadefinaldemodulobackend.resource;

import com.atividadefinaldemodulobackend.entities.Recados;
import com.atividadefinaldemodulobackend.service.RecadosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recados")
@Api(value = "API REST")
@CrossOrigin("*")
public class RecadosController {

    @Autowired
    private RecadosService service;

    @GetMapping("/all")
    @ApiOperation("retorna todos os papeis")
    public ResponseEntity<List<Recados>> read(){
        List<Recados> listaRecados = service.listarRecados();
        return ResponseEntity.ok(listaRecados);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Recados>> filter(@RequestParam(value = "busca")  String busca,@RequestParam(value = "operacao") String operacao ){
        List<Recados> listaRecadosBusca = service.BuscarRecado(busca, operacao);
        return ResponseEntity.ok(listaRecadosBusca);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Recados> findId(@PathVariable("id") Integer id){
        Recados recado = service.buscarRecadosId(id);
        return ResponseEntity.ok(recado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
        service.removerRecados(id);
        return ResponseEntity.ok().body("Apagado com sucesso");
    }

    @PostMapping
    public ResponseEntity<Recados> insert(@RequestBody Recados recado){
        service.salvarRecados(recado);
        return ResponseEntity.ok(recado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recados> update(@PathVariable("id") Integer id, @RequestBody Recados recado){
        service.atualizarRecados(id,recado);
        return ResponseEntity.ok(recado);
    }

}
