package app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import app.record.GeneroDTO;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="genero")
public class Genero {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nome;

    public Genero(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Genero(GeneroDTO dados) {
        this.id = dados.id();
        this.nome = dados.nome();
    }
}