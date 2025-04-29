package br.com.calculos.calculos.controller;


import br.com.calculos.calculos.entity.Carro;
import br.com.calculos.calculos.service.CarroService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<String> save (@RequestBody Carro carro){
        try{
            String mensagem=this.carroService.save(carro);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<String>("Deu algo errado", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>delete(@PathVariable int id){
        try{
            String mensagem=this.carroService.delete(id);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);

        }catch (Exception e){
            return  new ResponseEntity<String>("Deu algo errado", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Carro>findById(@PathVariable int id){
        try{
            Carro carro=this.carroService.findById(id);
            return new ResponseEntity<>(carro, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<Carro>( HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> update(@PathVariable int id, @RequestBody Carro carro2){
        try {
            Carro carro= this.carroService.update(id,carro2);
            return ResponseEntity.ok(carro);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping
    public ResponseEntity<List<Carro>> getAll(){
        try{
            List<Carro> carro=this.carroService.getAll();

            return ResponseEntity.ok(carro);
        }catch (Exception e){
            return (ResponseEntity<List<Carro>>) ResponseEntity.badRequest();
        }
    }

}

