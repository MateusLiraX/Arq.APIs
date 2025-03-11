package application.service;

import application.model.Genero;
import application.record.GeneroDTO;
import application.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> getAllGeneros() {
        return generoRepository.findAll();
    }

    public Optional<Genero> getGeneroById(Long id) {
        return generoRepository.findById(id);
    }

    public Genero createGenero(GeneroDTO generoDTO) {
        Genero genero = new Genero();
        genero.setDescricao(generoDTO.descricao());
        return generoRepository.save(genero);
    }

    public Genero updateGenero(Long id, GeneroDTO generoDTO) {
        Genero genero = generoRepository.findById(id).orElseThrow();
        genero.setDescricao(generoDTO.descricao());
        return generoRepository.save(genero);
    }

    public void deleteGenero(Long id) {
        generoRepository.deleteById(id);
    }
}