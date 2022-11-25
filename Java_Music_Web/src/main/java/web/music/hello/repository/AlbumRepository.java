package web.music.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.music.hello.entity.Album;

import java.util.List;

public interface AlbumRepository extends JpaRepository <Album, Integer> {
    Album getAlbumById(int id);

    List<Album> findTop2ByOrderByDateDesc();

    List<Album> findAllAlbumByOrderByDateDesc();
}

