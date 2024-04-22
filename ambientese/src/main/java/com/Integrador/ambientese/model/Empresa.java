package com.Integrador.ambientese.model;

import java.io.File;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Empresa {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmpresa;
	@Column(name = "razao_social", nullable = false)
    private String razaoSocial;
    @Column(name = "nome_fantasia", nullable = true)
    private String nomeFantasia;
    @Column(name = "cnpj", nullable = false)
    private String cnpj;
    @Column(name = "nome_solicitante", nullable = true)
    private String nomeSolicitante;
    @Column(name = "telefone_solicitante", nullable = true)
    private String telefoneSolicitante;
    @Column(name = "inscricao_social", nullable = true)
    private String inscricaoSocial;
    @Column(name = "ramo", nullable = false)
    private String ramo;
    @Column(name = "porte", nullable = false)
    private String porte;
    @Column(name = "logo", nullable = false)
    private File logo;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "telefone_empresa", nullable = false)
    private String telefoneEmpresa;


    
    public long getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public String getRazaoSocial() {
        return razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    public String getNomeFantasia() {
        return nomeFantasia;
    }
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getNomeSolicitante() {
        return nomeSolicitante;
    }
    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }
    public String getTelefoneSolicitante() {
        return telefoneSolicitante;
    }
    public void setTelefoneSolicitante(String telefoneSolicitante) {
        this.telefoneSolicitante = telefoneSolicitante;
    }
    public String getInscricaoSocial() {
        return inscricaoSocial;
    }
    public void setInscricaoSocial(String inscricaoSocial) {
        this.inscricaoSocial = inscricaoSocial;
    }
    public String getRamo() {
        return ramo;
    }
    public void setRamo(String ramo) {
        this.ramo = ramo;
    }
    public String getPorte() {
        return porte;
    }
    public void setPorte(String porte) {
        this.porte = porte;
    }
    public File getLogo() {
        return logo;
    }
    public void setLogo(File logo) {
        this.logo = logo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefoneEmpresa() {
        return telefoneEmpresa;
    }
    public void setTelefoneEmpresa(String telefoneEmpresa) {
        this.telefoneEmpresa = telefoneEmpresa;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idEmpresa ^ (idEmpresa >>> 32));
        result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
        result = prime * result + ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
        result = prime * result + ((nomeSolicitante == null) ? 0 : nomeSolicitante.hashCode());
        result = prime * result + ((telefoneSolicitante == null) ? 0 : telefoneSolicitante.hashCode());
        result = prime * result + ((inscricaoSocial == null) ? 0 : inscricaoSocial.hashCode());
        result = prime * result + ((ramo == null) ? 0 : ramo.hashCode());
        result = prime * result + ((porte == null) ? 0 : porte.hashCode());
        result = prime * result + ((logo == null) ? 0 : logo.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((telefoneEmpresa == null) ? 0 : telefoneEmpresa.hashCode());
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
        Empresa other = (Empresa) obj;
        if (idEmpresa != other.idEmpresa)
            return false;
        if (razaoSocial == null) {
            if (other.razaoSocial != null)
                return false;
        } else if (!razaoSocial.equals(other.razaoSocial))
            return false;
        if (nomeFantasia == null) {
            if (other.nomeFantasia != null)
                return false;
        } else if (!nomeFantasia.equals(other.nomeFantasia))
            return false;
        if (cnpj == null) {
            if (other.cnpj != null)
                return false;
        } else if (!cnpj.equals(other.cnpj))
            return false;
        if (nomeSolicitante == null) {
            if (other.nomeSolicitante != null)
                return false;
        } else if (!nomeSolicitante.equals(other.nomeSolicitante))
            return false;
        if (telefoneSolicitante == null) {
            if (other.telefoneSolicitante != null)
                return false;
        } else if (!telefoneSolicitante.equals(other.telefoneSolicitante))
            return false;
        if (inscricaoSocial == null) {
            if (other.inscricaoSocial != null)
                return false;
        } else if (!inscricaoSocial.equals(other.inscricaoSocial))
            return false;
        if (ramo == null) {
            if (other.ramo != null)
                return false;
        } else if (!ramo.equals(other.ramo))
            return false;
        if (porte == null) {
            if (other.porte != null)
                return false;
        } else if (!porte.equals(other.porte))
            return false;
        if (logo == null) {
            if (other.logo != null)
                return false;
        } else if (!logo.equals(other.logo))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (telefoneEmpresa == null) {
            if (other.telefoneEmpresa != null)
                return false;
        } else if (!telefoneEmpresa.equals(other.telefoneEmpresa))
            return false;
        return true;
    }
    
}
