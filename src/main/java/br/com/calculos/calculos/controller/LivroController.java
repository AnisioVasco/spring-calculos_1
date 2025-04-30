package br.com.calculos.calculos.controller;


import br.com.calculos.calculos.entity.Livros;
import br.com.calculos.calculos.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroService livroService;

    @GetMapping
//    public Object Read()
//    {
//        try {
//            return ResponseEntity.ok( this.livroService.getAll());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
        public ResponseEntity<ArrayList<Livros>> Read()
    {
        try{
            ArrayList<Livros> livros=this.livroService.getAll();

            return ResponseEntity.ok(livros);
        } catch (Exception e) {
           // return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return (ResponseEntity<ArrayList<Livros>>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Livros> findById(@PathVariable int id){
        try {
            Livros livros=this.livroService.findById(id);
            return ResponseEntity.ok(livros);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Livros livros)
    {
        try {
            String mensagem=this.livroService.save(livros);
            return ResponseEntity.ok(mensagem);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Livros>  update(@PathVariable int id,@RequestBody Livros livros)
    {
        try {
            Livros livros1=new Livros();
            livros1=this.livroService.update(livros,id);
            return ResponseEntity.ok(livros1);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id)
    {
        try {
            String mensagem=this.livroService.delete(id);
            return ResponseEntity.ok(mensagem);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
