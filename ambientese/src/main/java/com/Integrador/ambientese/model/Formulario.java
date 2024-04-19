package com.Integrador.ambientese.model;

import jakarta.persistence.*;

@Entity
public class Formulario {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFormulario;
    @Column(name = "DataResposta")
    private String dataResposta;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idFormulario ^ (idFormulario >>> 32));
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
        Formulario other = (Formulario) obj;
        if (idFormulario != other.idFormulario)
            return false;
        return true;
    }

    public long getIdFormulario() {
        return idFormulario;
    }
    public void setIdFormulario(long idFormulario) {
        this.idFormulario = idFormulario;
    }
    public String getDataResposta() {
        return dataResposta;
    }
    public void setDataResposta(String dataResposta) {
        this.dataResposta = dataResposta;
    }

}
