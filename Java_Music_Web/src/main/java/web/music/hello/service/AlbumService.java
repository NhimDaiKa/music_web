package web.music.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.music.hello.entity.Album;
import web.music.hello.repository.AlbumRepository;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository repository;


    public Album getAlbumById(int id) {
        return repository.getAlbumById(id);
    }

    public List<Album> get2Albums() {
        return repository.findTop2ByOrderByDateDesc();
    }

    public List<Album> getAllAlbumsByOrderByDateDesc() {
        return repository.findAllAlbumByOrderByDateDesc();
    }
}
