package web.music.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.music.hello.entity.Song;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Integer> {

    Song getSongById(int id);

    List<Song> findByAlbum(String album);

    List<Song> findTop12ByOrderByDateDesc();
    List<Song> findTop5ByAlbumOrderByDateDesc(String album);

    List<Song> findAllByArtistOrderByNameAsc(String artist);
}

