package application.controller;

import application.model.Genero;
import application.record.GeneroDTO;
import application.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public List<Genero> getAllGeneros() {
        return generoService.getAllGeneros();
    }

    @GetMapping("/{id}")
    public Optional<Genero> getGeneroById(@PathVariable Long id) {
        return generoService.getGeneroById(id);
    }

    @PostMapping
    public Genero createGenero(@RequestBody GeneroDTO generoDTO) {
        return generoService.createGenero(generoDTO);
    }

    @PutMapping("/{id}")
    public Genero updateGenero(@PathVariable Long id, @RequestBody GeneroDTO generoDTO) {
        return generoService.updateGenero(id, generoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteGenero(@PathVariable Long id) {
        generoService.deleteGenero(id);
    }
}