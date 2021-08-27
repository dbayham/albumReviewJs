package org.wcci.apimastery.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Storage.AlbumStorage;
import org.wcci.apimastery.Storage.SongStorage;
import org.wcci.apimastery.pojos.Album;
import org.wcci.apimastery.pojos.Song;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlbumController {

    private AlbumStorage albumStorage;
    private SongStorage songStorage;

    public AlbumController(AlbumStorage albumStorage, SongStorage songStorage){
        this.albumStorage = albumStorage;
        this.songStorage = songStorage;
    }

    //GET localhost:8080/api/albums
    @GetMapping("/api/albums")
    public Iterable<Album> retrieveAllAlbums(){
        return albumStorage.retrieveAllAlbums();
    }

    //GET localhost:8080/api/albums/1
    @GetMapping("/api/albums/{id}")
    public Album retrieveAlbumById(@PathVariable Long id){
        return albumStorage.findAlbumById(id);
    }

    //DELETE http://localhost:8080/api/albums/1
    @DeleteMapping("/api/albums/{id}")
    public Iterable<Album> deleteAlbumById(@PathVariable Long id){
        albumStorage.deleteAlbumById(id);
        return albumStorage.retrieveAllAlbums();
    }

    // PUT http://localhost:8080/api/albums
    // Content-Type: application/json
    @PostMapping("/api/albums")
    public Iterable<Album> addNewAlbum(@RequestBody Album albumToAdd){
        albumStorage.saveAlbum(albumToAdd);
        return albumStorage.retrieveAllAlbums();
    }
    

    // {"id":1,"title": "Greatest Hits","TechElevator Sucks"}
    @PutMapping("/api/albums")
    public Iterable<Album> modifyAlbum(@RequestBody Album albumToModify){
        if(albumToModify.getId()!=null){
            albumStorage.saveAlbum(albumToModify);
        }
        return albumStorage.retrieveAllAlbums();
    }


    @PutMapping("/api/albums/{id}/rating")
    public Album changeAlbumRating(@PathVariable Long id, @RequestBody Double rating){
        Album albumToChange = albumStorage.findAlbumById(id);
        albumToChange.changeRating(rating);
        albumStorage.saveAlbum(albumToChange);
        return albumToChange;
    }
//album comment
    @PatchMapping("/api/albums/{id}/comments")
    public Album addAlbumComment(@PathVariable Long id, @RequestBody String comment){
        Album albumToChange = albumStorage.findAlbumById(id);
        albumToChange.addComment(comment);
        albumStorage.saveAlbum(albumToChange);
        return albumToChange;
    }

 //     ### Add a new song resource to the albums song
    //PATCH http://localhost:8080/api/albums/1/songs
    // Content-Type: application/json

    @PatchMapping("/api/albums/{id}/songs")
    public Album addSongToAlbum (@PathVariable Long id, @RequestBody Song songToAdd){
        Album albumToChange = albumStorage.findAlbumById(id);
        songToAdd.changeAlbum(albumToChange);
        songStorage.saveSong(songToAdd);
        albumToChange.addSong(songToAdd);
        albumStorage.saveAlbum(albumToChange);
        return albumToChange;
    }


    @DeleteMapping("/api/albums/{id}/songs/{songId}")
    public Album deleteSongFromAlbum(@PathVariable Long id, @PathVariable Long songId){
        Album albumToChange = albumStorage.findAlbumById(id);
        Song song = songStorage.findById(songId);
        albumToChange.removeSong(song);
        songStorage.deleteSongById(songId);
        albumStorage.saveAlbum(albumToChange);
        return albumToChange;
    }

    @GetMapping("/api/albums/{id}/songs")
    public Iterable<Song> retrieveAllSongsByAlbum(@PathVariable Long id){
        Album albumToFind = albumStorage.findAlbumById(id);
        return albumToFind.getSongs();
    }

    @GetMapping("/api/albums/{albumId}/songs/{songId}")
    public Song retrieveSongById(@PathVariable Long albumId, @PathVariable Long songId){
       // Album albumToFind = albumStorage.findAlbumById(albumId);
        Song songToRetrieve = songStorage.findById(songId);
        return songToRetrieve;
    }

    @PutMapping("/api/albums/{albumId}/songs/{songId}/rating")
    public Album changeSongRating (@PathVariable Long albumId, @PathVariable Long songId, @RequestBody Double rating){
        Album albumToFind = albumStorage.findAlbumById(albumId);
        Song songToRetrieve = songStorage.findById(songId);
        songToRetrieve.changeRating(rating);
        songStorage.saveSong(songToRetrieve);
        albumStorage.saveAlbum(albumToFind);
        return albumToFind;
    }

    @PatchMapping("/api/albums/{albumId}/songs/{songId}/comments")
    public Album changeSongComment (@PathVariable Long albumId, @PathVariable Long songId, @RequestBody String comment){
        Album albumToFind = albumStorage.findAlbumById(albumId);
        Song songToRetrieve = songStorage.findById(songId);
        songToRetrieve.addSongComment(comment);
        songStorage.saveSong(songToRetrieve);
        albumStorage.saveAlbum(albumToFind);
        return albumToFind;
    }
}