package web.music.hello.entity;

import javax.persistence.*;

@Entity
@Table(name = "song")
public class Song {

//    public Song() {
//    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 64, nullable = false)
    private String name;


    @Column(length = 256, nullable = false)
    private String artist;
    @Column(length = 256, nullable = false)
    private String album;


    @Column(nullable = false)
    private String photo;

    @Column(nullable = false)
    private String url;
    @Column(length =1,nullable = false)
    private String sort;
    @Column(nullable = false)
    private String date;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String author) {
        this.artist = author;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
