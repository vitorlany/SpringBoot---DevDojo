package academy.devdojo.repository;

import academy.devdojo.domain.Anime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@DisplayName("Tests for Anime Repository")
class AnimeRepositoryTest {
    @Autowired
    private AnimeRepository animeRepository;

    @Test
    @DisplayName("Save")
    void save_PersistAnime_WhenSuccessful() {
        Anime anime = createAnime();
        Anime savedAnime = this.animeRepository.save(anime);
        Assertions.assertThat(savedAnime).isNotNull();
        Assertions.assertThat(savedAnime.getId()).isNotNull();
        Assertions.assertThat(savedAnime.getName()).isEqualTo(anime.getName());
    }

    @Test
    @DisplayName("Update")
    void save_UpdatesPersistAnime_WhenSuccessful() {
        Anime anime = createAnime();

        Anime animeSaved = this.animeRepository.save(anime);
        animeSaved.setName("DevDojo");

        Anime animeUpdated = this.animeRepository.save(anime);

        Assertions.assertThat(animeUpdated).isNotNull();
        Assertions.assertThat(animeUpdated.getId()).isNotNull();
        Assertions.assertThat(animeUpdated.getName()).isEqualTo(animeSaved.getName());
    }


    @Test
    @DisplayName("Delete")
    void delete_RemoveAnime_WhenSuccessful() {
        Anime anime = createAnime();

        Anime animeSaved = this.animeRepository.save(anime);
        this.animeRepository.delete(animeSaved);

        Optional<Anime> animeOptional = animeRepository.findById(animeSaved.getId());
        Assertions.assertThat(animeOptional.isEmpty()).isTrue();
    }

    private Anime createAnime() {
        return Anime.builder()
                .name("Hajime")
                .build();
    }
}