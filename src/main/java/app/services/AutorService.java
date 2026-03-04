package app.services;

import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import app.model.Livro;
import app.model.Autor;
import app.record.AutorDTO;
import app.record.AutorInsertDTO;
import app.repository.AutorRepository;
import app.services.LivroService;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepo;
    
    @Autowired
    private LivroService livroService;

    public Iterable<AutorDTO> findAll() {
        return autorRepo.findAll().stream().map(AutorDTO::new).toList();
    }

    public AutorDTO insert(AutorInsertDTO dados) {
        Livro livro = new Livro(livroService.findOne(dados.id_livro()));

        Autor autor = new Autor();
        autor.setNome(dados.nome());
        autor.setLivro(livro);

        return new AutorDTO(autorRepo.save(autor));
    }

    public AutorDTO update(long id, AutorInsertDTO dados) {
        Optional<Autor> resultado = autorRepo.findById(id);
        if (resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Autor Não Encontrado"
            );
        }

        Livro livro = new Livro(livroService.findOne(dados.id_livro()));
        resultado.get().setNome(dados.nome());
        resultado.get().setLivro(livro);
        return new AutorDTO(autorRepo.save(resultado.get()));
    }
}