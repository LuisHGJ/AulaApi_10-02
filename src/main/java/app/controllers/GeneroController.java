package app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import app.model.Genero;
import app.repository.GeneroRepository;

import java.util.Optional;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/generos")
public class GeneroController {
    @Autowired
    private GeneroRepository generoRepo;

    @GetMapping
    public Iterable<Genero> list() {
        return generoRepo.findAll();
    }

    @GetMapping("/{id}")
    public Genero getOne(@PathVariable long id) {
        return generoRepo.findById(id).get();
    }

    @PostMapping
    public Genero insert(@RequestBody Genero novoGenero) {
        return generoRepo.save(novoGenero);
    }

    @PutMapping("/{id}")
    public Genero update(@PathVariable long id, @RequestBody Genero modif){
        Optional<Genero> busca = generoRepo.findById(id);
        busca.get().setNome(modif.getNome());
        return generoRepo.save(busca.get());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        generoRepo.deleteById(id);
    }
}