package br.com.calculos.calculos.service;


import br.com.calculos.calculos.entity.Entrada;
import br.com.calculos.calculos.entity.Resultado;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CalculoService {

    public Resultado somar(@RequestBody Entrada entrada){
        Resultado resultado=new Resultado();
        Integer soma=0;
    if(entrada.getLista()!=null){
        for(int i=0; i<entrada.getLista().size(); i++){
            soma+=entrada.getLista().get(i);
        }
    }
    resultado.setSoma(soma);

        return resultado;
    }

    public Resultado calcular(@RequestBody Entrada entrada){
        Resultado resultado=new Resultado();
        Integer soma=0;
      Integer maior=entrada.getLista().get(0);
      Integer menor=entrada.getLista().get(0);
        if(entrada.getLista()!=null){
            for(int i=0; i<entrada.getLista().size(); i++){
                soma+=entrada.getLista().get(i);
                if (maior<entrada.getLista().get(i)){
                    maior=entrada.getLista().get(i);
                }
                if (menor>entrada.getLista().get(i)){
                    menor=entrada.getLista().get(i);
                }

            }
        }
        resultado.setSoma(soma);
        resultado.setMedia((double) (soma/entrada.getLista().size()));
        resultado.setTamanho(entrada.getLista().size());
        resultado.setMaior(maior);
        resultado.setMenor(menor);
        return resultado;
    }

}
