package academy.devdojo.service;

import academy.devdojo.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimeService {
    private List<Anime> animes = List.of(new Anime(1L, "DBZ"), new Anime(2L, "Bersek"));

    public List<Anime> listAll() {
        return animes;
    }

    public List<Anime> findById(Long id) {
        return animes.stream()
                .filter(anime -> anime.getId() == id)
                .findFirst()
                .orElseThrow();
    }
}
