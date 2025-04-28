package br.com.calculos.calculos.controller;


import br.com.calculos.calculos.entity.Entrada;
import br.com.calculos.calculos.entity.Resultado;
import br.com.calculos.calculos.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculos")
public class CalculoController {

    @Autowired
    private CalculoService calculoService;

    @GetMapping("/somar")
    public ResponseEntity<Resultado> somar(@RequestBody Entrada entrada){

        try {
            Resultado resultado = this.calculoService.somar(entrada);
            return new ResponseEntity<Resultado>(resultado,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/calcular")
    public ResponseEntity<Resultado> calcular(@RequestBody Entrada entrada){

        try {
            Resultado resultado = this.calculoService.calcular(entrada);
            return new ResponseEntity<Resultado>(resultado,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

}
