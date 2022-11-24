package web.music.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.music.hello.entity.Album;
import web.music.hello.entity.Artist;
import web.music.hello.entity.Song;
import web.music.hello.service.AlbumService;
import web.music.hello.service.ArtistService;
import web.music.hello.service.SongService;

import java.util.List;
@Controller
public class MainController {
    @Autowired
    private SongService service;
    @Autowired
    private AlbumService abservice;
    @Autowired
    private ArtistService atservice;

    @GetMapping("/")
    public String test(Model model){
        model.addAttribute("songs12", service.get12Songs());
        model.addAttribute("songs", service.getAllSongs());
        model.addAttribute("albums", abservice.getAllAlbumsByOrderByDateAsc());
        List<Album> albums2 = abservice.get2Albums();
        model.addAttribute("albums2", albums2);
        model.addAttribute("firstsong", service.getFirstSongAlbum(albums2.get(0).getName()));
        model.addAttribute("artists5", atservice.get5Artists());
        return "index";
    }
    @GetMapping("/player")
    public String showSong(Model model, @RequestParam int id){
        Song song=service.getSongById(id);
        model.addAttribute("song", service.getSongById(id));
        String album=song.getAlbum();
        List<Song> albums = service.findByAlbum(album);
        model.addAttribute("albums", albums);
        return "player";
    }
    @GetMapping("/songs")
    public String showAlbum(Model model){
        model.addAttribute("songs", service.getAllSongs());
        return "songs";
    }
    @GetMapping("/album")
    public String showAlbum(Model model, @RequestParam int id){
        Album album=abservice.getAlbumById(id);
        String albumName=album.getName();
        model.addAttribute("album", album);
        List<Song> songs = service.findByAlbum(albumName);
        model.addAttribute("songs", songs);
        model.addAttribute("albums", abservice.getAllAlbumsByOrderByDateAsc());
        model.addAttribute("songs12", service.get12Songs());
        model.addAttribute("artists5", atservice.get5Artists());
        return "album";
    }
    @GetMapping("/artists")
    public String showArtists(Model model){
        model.addAttribute("artists", atservice.getAllArtists());
        return "artists";
    }
    @GetMapping("/artist_info")
    public String showArtistInfo(Model model, @RequestParam int id){
        Artist artist=atservice.getArtistById(id);
        model.addAttribute("artist", artist);
        model.addAttribute("songs",service.getAllSongByArtist(artist.getName()));
        return "artist_info";
    }
}
