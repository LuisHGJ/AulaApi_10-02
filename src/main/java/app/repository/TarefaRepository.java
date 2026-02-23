package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}