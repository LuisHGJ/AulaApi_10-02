package app.record;

import app.model.Genero;

public record GeneroDTO(Long id, String nome) {
    public GeneroDTO(Genero dados) {
        this(dados.getId(), dados.getNome());
    }
}