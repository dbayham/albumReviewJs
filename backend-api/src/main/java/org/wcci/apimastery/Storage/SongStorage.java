package org.wcci.apimastery.Storage;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.Repos.SongRepository;
import org.wcci.apimastery.pojos.Song;

@Service
public class SongStorage {
    private SongRepository songRepo;

    public SongStorage(SongRepository songRepo){
        this.songRepo = songRepo;
    }

    public Iterable<Song> retrieveAllSongs(){
        return songRepo.findAll();
    }

    public Song findById(Long id){
        return songRepo.findById(id).get();
    }

    public void saveSong(Song songToAdd){
        songRepo.save(songToAdd);
    }


    public void deleteSongById(Long id) {
        songRepo.deleteById(id);
    }


}
