package app.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tarefa {
    private long id;
    private String descricao;

    public Tarefa(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
}