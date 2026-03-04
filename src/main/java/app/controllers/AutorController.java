package app.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import app.record.AutorDTO;
import app.record.AutorInsertDTO;
import app.services.AutorService;

@RestController
@RequestMapping("/autores") 
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping
    public Iterable<AutorDTO> getAll() {
        return autorService.findAll();
    }

    @PostMapping
    public AutorDTO insert(@RequestBody AutorInsertDTO dados) {
        return autorService.insert(dados);
    }

    @PutMapping("/{id}")
    public AutorDTO update(@PathVariable long id, @RequestBody AutorInsertDTO dados) {
        return autorService.update(id, dados);
    }
}