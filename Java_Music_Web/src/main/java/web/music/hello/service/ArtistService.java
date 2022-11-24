package web.music.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.music.hello.entity.Artist;
import web.music.hello.repository.ArtistRepository;

import java.util.List;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository repository;
    public List<Artist> getAllArtists() {
        return repository.findAll();
    }
    public Artist getArtistById(int id) {
        return repository.getArtistById(id);
    }
    public List<Artist> get5Artists() {
        return repository.findTop5ByOrderByIdDesc();
    }

}
