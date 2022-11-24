package web.music.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.music.hello.entity.Song;
import web.music.hello.repository.SongRepository;

import java.util.List;

@Service
public class SongService {
    @Autowired
    private SongRepository repository;
    public List<Song> getAllSongs() {
        return  repository.findAll();
    }

    public List<Song> get12Songs() {
        return  repository.findTop12ByOrderByDateDesc();
    }

    public Song getSongById(int id) {
        return repository.getSongById(id);
    }

    public List<Song> findByAlbum(String album) {
        return repository.findByAlbum(album);
    }
    public Song getFirstSongAlbum(String album) {
        return repository.findByAlbum(album).get(0);
    }

    public List <Song> getAllSongByArtist(String artist) {
        return repository.findAllByArtistOrderByNameAsc(artist);
    }
}
