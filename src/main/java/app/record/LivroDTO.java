package app.record;

import app.model.Livro;

public record LivroDTO (
    long id,
    String titulo,
    GeneroDTO genero
) {
    public LivroDTO(Livro dados) {
        this(
            dados.getId(),
            dados.getTitulo(),
            new GeneroDTO(dados.getGenero())
        );
    }
}