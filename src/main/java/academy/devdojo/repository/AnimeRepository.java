package academy.devdojo.repository;

import academy.devdojo.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
