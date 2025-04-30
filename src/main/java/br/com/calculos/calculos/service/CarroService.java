package br.com.calculos.calculos.service;

import br.com.calculos.calculos.entity.Carro;
import br.com.calculos.calculos.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public String save(Carro carro){
        this.carroRepository.save(carro);
        return "Carro Salvo com sucesso";
    }
    public Carro findById(Long id){
       Optional<Carro> carro=this.carroRepository.findById(id);
       return carro.get();
    }


    public  String delete(Long id) {
       this.carroRepository.delete(this.findById(id));

        return "Apagado com sucesso";

    }
//    public  Carro update(Long id, Carro carro2) {
//        if(id==1){
//            Carro carro=this.findById(id);
//            carro.setNome(carro2.getNome());
//            return  carro;
//        }else{
//            return null;
//        }
//    }
    public Optional<Carro> update(Long id, Carro carro)
    {
        Optional<Carro> carro1= Optional.ofNullable(findById(id));
        if (carro.getNome()!=null) {
            carro1.get().setNome(carro.getNome());
        }
        if (carro.getModelo()!=null) {
            carro1.get().setModelo(carro.getModelo());
        }
        if (carro.getMarca()!=null) {
            carro1.get().setMarca(carro.getMarca());
        }
        if (carro1.get().getAnoFabricacao()!=carro.getAnoFabricacao() || carro.getAnoFabricacao()==carro1.get().getAnoFabricacao()) {
            carro1.get().setAnoFabricacao(carro.getAnoFabricacao());
        }

Optional<Carro> carro2= Optional.of(carroRepository.save(carro1.get()));
        return carro2;
    }


    public List<Carro>  getAll(){
       List<Carro> carro=this.carroRepository.findAll();
        return carro;

    }

}
