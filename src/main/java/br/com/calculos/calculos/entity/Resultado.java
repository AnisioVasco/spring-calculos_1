package br.com.calculos.calculos.entity;

public class Resultado {
    private Integer soma;
    private Double media;
    private  Integer maior;
    private Integer menor;
    private Integer tamanho;

    public Integer getMaior() {
        return maior;
    }

    public void setMaior(Integer maior) {
        this.maior = maior;
    }

    public Integer getMenor() {
        return menor;
    }

    public void setMenor(Integer menor) {
        this.menor = menor;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public Integer getSoma() {
        return soma;
    }

    public void setSoma(Integer soma) {
        this.soma = soma;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }
}
