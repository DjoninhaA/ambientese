package com.Integrador.ambientese.model;

import jakarta.persistence.*;

@Entity
public class Endereco {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEndereco;
    @Column(name = "CEP", nullable = false)
    private String CEP;
    @Column(name = "numero", nullable = false)
    private int numero;
    @Column(name = "logradouro", nullable = false)
    private String logradouro;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "cidade", nullable = false)
    private String cidade;
    @Column(name = "bairro", nullable = false)
    private String bairro;
    @Column(name = "UF", nullable = false)
    private String UF;
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idEndereco ^ (idEndereco >>> 32));
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
        Endereco other = (Endereco) obj;
        if (idEndereco != other.idEndereco)
            return false;
        return true;
    }

    public long getIdEndereco() {
        return idEndereco;
    }
    public void setIdEndereco(long idEndereco) {
        this.idEndereco = idEndereco;
    }
    public String getCEP() {
        return CEP;
    }
    public void setCEP(String cEP) {
        CEP = cEP;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    public String getUF() {
        return UF;
    }
    public void setUF(String uF) {
        UF = uF;
    }
}
