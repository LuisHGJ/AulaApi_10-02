package app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import app.record.GeneroDTO;
import app.record.GeneroInsertDTO;
import app.services.GeneroService;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/generos")
public class GeneroController {
    @Autowired
    private GeneroService generoService;

    @GetMapping
    public Iterable<GeneroDTO> list() {
        return generoService.findAll();
    }

    @GetMapping("/{id}")
    public GeneroDTO getOne(@PathVariable long id) {
        return generoService.findOne(id);
    }

    @PostMapping
    public GeneroDTO insert(@RequestBody GeneroInsertDTO novoGenero) {
        return generoService.insert(novoGenero);
    }

    @PutMapping("/{id}")
    public GeneroDTO update(@PathVariable long id, @RequestBody GeneroInsertDTO modif){
        return generoService.update(id, modif);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        generoService.delete(id);
    }
}