package com.Integrador.ambientese.model;

import com.Integrador.ambientese.model.enums.Ramo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Perguntas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPergunta;
    @Column(name = "desc_pergunta", nullable = false)
    private String descricaoPergunta;
    @Column(name = "ramo_pergunta", nullable = false)
    private Ramo ramo;

    public long getIdPergunta() {
        return idPergunta;
    }
    public void setIdPergunta(long idPergunta) {
        this.idPergunta = idPergunta;
    }
    public String getDescricaoPergunta() {
        return descricaoPergunta;
    }
    public void setDescricaoPergunta(String descricaoPergunta) {
        this.descricaoPergunta = descricaoPergunta;
    }
    public Ramo getRamo() {
        return ramo;
    }
    public void setRamo(Ramo ramo) {
        this.ramo = ramo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idPergunta ^ (idPergunta >>> 32));
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Perguntas other = (Perguntas) obj;
        if (idPergunta != other.idPergunta)
            return false;
        return true;
    }
}
