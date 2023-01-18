package academy.devdojo.service;

import academy.devdojo.domain.Anime;
import academy.devdojo.exception.BadRequestException;
import academy.devdojo.mapper.AnimeMapper;
import academy.devdojo.repository.AnimeRepository;
import academy.devdojo.requests.AnimePostRequestBody;
import academy.devdojo.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {
    private final AnimeRepository animeRepository;

    public Page<Anime> listAll(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequest(Long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime ID not Found"));
    }

    @Transactional
    public Anime save(AnimePostRequestBody anime) {
        Anime res = AnimeMapper.INSTANCE.toAnime(anime);
        return animeRepository.save(res);
    }

    public void delete(Long id) {
        animeRepository.delete(findByIdOrThrowBadRequest(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime saved = findByIdOrThrowBadRequest(animePutRequestBody.getId());

        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(saved.getId());
        animeRepository.save(anime);
    }
}
