package academy.devdojo.controller;

import academy.devdojo.domain.Anime;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("anime")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {

    @GetMapping("list")
    public List<Anime> list() {
        return List.of(new Anime("DBZ"), new Anime("Bersek"));
    }
}
