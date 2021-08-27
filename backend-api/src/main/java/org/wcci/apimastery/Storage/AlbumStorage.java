package org.wcci.apimastery.Storage;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.Repos.AlbumRepository;
import org.wcci.apimastery.pojos.Album;

@Service
public class AlbumStorage {
    private AlbumRepository albumRepo;

    public AlbumStorage(AlbumRepository albumRepo) {
        this.albumRepo = albumRepo;
    }

    public Iterable<Album> retrieveAllAlbums(){
        return albumRepo.findAll();
    }

    public Album findAlbumById(Long id){
        return albumRepo.findById(id).get();
    }

    public void saveAlbum(Album albumToAdd){
        albumRepo.save(albumToAdd);
    }


    public void deleteAlbumById(Long id) {
        albumRepo.deleteById(id);
    }


}
