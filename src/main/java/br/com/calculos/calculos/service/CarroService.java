package br.com.calculos.calculos.service;

import br.com.calculos.calculos.entity.Carro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CarroService {

    public String save(Carro carro){
        //
        return "Carro Salvo com sucesso";
    }
    public Carro findById(int id){
        if(id==1){
            Carro carro =new Carro();
            carro.setNome("teste");
            carro.setMarca("Suv");
            carro.setModelo("toyota");
            carro.setAnoFabricacao(2025);
            return  carro;
        }else{
            return null;
        }
    }


    public  String delete(int id) {
        if(id==1){
            Carro carro =new Carro();
            carro.setNome("teste");
            carro.setMarca("Suv");
            carro.setModelo("toyota");
            carro.setAnoFabricacao(2025);
            return  "Apagado com sucesso";
        }else{
            return "Erro ao Apagar";
        }
    }
    public  Carro update(int id, Carro carro2) {
        if(id==1){
            Carro carro=this.findById(id);
            carro.setNome(carro2.getNome());
            return  carro;
        }else{
            return null;
        }
    }


    public List<Carro>  getAll(){
        List<Carro> carros = new ArrayList<>();

        // Carro 1 - Mantendo exatamente seu padrão
        Carro carro1 = new Carro();
        carro1.setNome("teste 1");
        carro1.setMarca("SUV");
        carro1.setModelo("Toyota");
        carro1.setAnoFabricacao(2025);

        // Carro 2
        Carro carro2 = new Carro();
        carro2.setNome("teste 2");
        carro2.setMarca("Sedan");
        carro2.setModelo("Honda");
        carro2.setAnoFabricacao(2024);

        // Carro 3
        Carro carro3 = new Carro();
        carro3.setNome("teste 3");
        carro3.setMarca("Hatch");
        carro3.setModelo("Volkswagen");
        carro3.setAnoFabricacao(2023);

        carros.add(carro1);
        carros.add(carro2);
        carros.add(carro3);

        return carros;

    }

}
