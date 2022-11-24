package web.music.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.music.hello.entity.Artist;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    Artist getArtistById(int id);

    List<Artist> findTop5ByOrderByIdDesc();
}
