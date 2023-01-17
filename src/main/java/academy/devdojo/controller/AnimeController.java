package academy.devdojo.controller;

import academy.devdojo.domain.Anime;
import academy.devdojo.service.AnimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("anime")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> list() {
        return ResponseEntity.ok(animeService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findByName(@PathVariable Long id) {
        return ResponseEntity.ok(animeService.findById(id));
    }
}
