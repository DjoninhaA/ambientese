package com.Integrador.ambientese.model;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.Optional;

import com.Integrador.ambientese.model.enums.Cargo;
import com.Integrador.ambientese.model.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
//@Table(name = "Funcionarios")
public class Funcionarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFuncionario;
    @Column(name = "nome")
    private String name;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @Column(name = "Cargo")
    private Cargo cargo;
    @Column(name = "genero")
    private Genero genero;

    @OneToOne(cascade = CascadeType.REMOVE)
	private Usuario usuario;

//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + (int) (idFuncionario ^ (idFuncionario >>> 32));
//        return result;
//    }
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//        return true;
//        if (obj == null)
//        return false;
//        if (getClass() != obj.getClass())
//        return false;
//        Funcionarios other = (Funcionarios) obj;
//        if (idFuncionario != other.idFuncionario)
//        return false;
//        return true;
//    }


}
