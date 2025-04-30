package br.com.calculos.calculos.service;

import br.com.calculos.calculos.entity.Livros;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;

@Service
public class LivroService {


    private ArrayList<Livros> array_livros = new ArrayList<Livros>();

    public LivroService() {
        Livros livros1= new Livros(1,"Anisio", "Plural", 2020);
        Livros livros2= new Livros(2,"Vasco", "Editores", 2021);
        Livros livros3= new Livros(3,"Mucanar", "Texto Editores", 2022);
        array_livros.add(livros1);
        array_livros.add(livros2);
        array_livros.add(livros3);

    }

    public ArrayList<Livros> getAll() {

        return array_livros;
    }

    public Livros findById(int id){
        Livros livros=new Livros();
        for(int i=0; i<array_livros.size();i++){
            if(id==array_livros.get(i).getId()){
                livros=array_livros.get(i);
                break;
            }
        }
        return livros;
    }


    public String save(Livros livros)
    {

        array_livros.add(livros);

        return "Dados gravados com sucesso";
    }

    public Livros update(Livros livros, int id){
        int index;
        for (int i=0; i<array_livros.size();i++){

            if(array_livros.get(i).getId()==id)
            {
                if(livros.getAutor() != null){
                    array_livros.get(i).setAutor(livros.getAutor());
                }

                if(livros.getAno() != null) {
                    array_livros.get(i).setAno(livros.getAno());
                }
                if(livros.getEditora() != null) {
                    array_livros.get(i).setEditora(livros.getEditora());
                }
                break;
            }

        }

        Livros livros1=new Livros();
        livros1=findById(id);
        return livros1;
    }
    public String delete(int id){
        for(int i=0; i<array_livros.size();i++){
            if(array_livros.get(i).getId()==id)
            {
                array_livros.remove(i);
                break;
            }
        }

        return "Eliminado com sucesso";
    }
}
