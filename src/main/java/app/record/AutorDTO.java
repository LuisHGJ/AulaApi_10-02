package app.record;

import app.model.Autor;
import app.record.LivroDTO;

public record AutorDTO(long id, String nome, LivroDTO livro) {
    public AutorDTO(Autor dados) {
        this(dados.getId(), dados.getNome(), new LivroDTO(dados.getLivro()));
    }
}