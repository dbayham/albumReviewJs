package org.wcci.apimastery.pojos;


import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Album {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String recordLabel;
    private Double rating;
    
    @Lob
    private String imageUrl;

    private String artist;

    @OneToMany(mappedBy = "album" , orphanRemoval = true)
    private Collection<Song> songs;

    @ElementCollection
    private Collection<String> comments;

    public Album(String title, String recordLabel, Double rating, String imageUrl, String artist, String... comments){
        this.title = title;
        this.recordLabel = recordLabel;
        this.rating = rating;
        this.comments = Set.of(comments);
        this.imageUrl = imageUrl;
        this.artist = artist;
    }

    protected Album() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public Double getRating() {
        return rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getArtist() {
        return artist;
    }

    public Iterable<Song> getSongs() {
        return songs;
    }
    
    public Collection<String> getComments() {
        return comments;
    }

    public void addComment(String comment){
        comments.add(comment);
    }

    public void addSong(Song song){
        songs.add(song);
    }

    public void removeSong(Song song){
        songs.remove(song);
    }

    public void changeRating(Double newRating){
        rating = newRating;
    }
}
