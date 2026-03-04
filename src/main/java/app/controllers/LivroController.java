package app.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import app.record.LivroDTO;
import app.record.LivroInsertDTO;
import app.services.LivroService;

@RestController
@RequestMapping("/livros") 
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public Iterable<LivroDTO> getAll() {
        return livroService.findAll();
    }

    @PostMapping
    public LivroDTO insert(@RequestBody LivroInsertDTO dados) {
        return livroService.insert(dados);
    }

    @PutMapping("/{id}")
    public LivroDTO update(@PathVariable long id, @RequestBody LivroInsertDTO dados) {
        return livroService.update(id, dados);
    }
}