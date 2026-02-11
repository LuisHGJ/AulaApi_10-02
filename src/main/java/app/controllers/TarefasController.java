package app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import app.model.Tarefa;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {
    @GetMapping
    public Tarefa list() {
        return new Tarefa(1, "Teste");
    }

    @PostMapping
    public Tarefa insert(@RequestBody Tarefa nova) {
        return nova;
    }
}