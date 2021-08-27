package org.wcci.apimastery.pojos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.util.Collection;
import java.util.Set;

@Entity
public class Song {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Integer duration;
    private Double rating;
    private String linkURL;

    @ManyToOne
    @JsonIgnore
    private Album album;

    @ElementCollection
    private Collection<String> comments;
        
    public Song(Album album ,String name, Integer duration, Double rating, String linkURL, String... comments){
        this.album = album;
        this.title = name;
        this.duration = duration;
        this.rating = rating;
        this.linkURL = linkURL;
        this.comments = Set.of(comments);
    }

    protected Song(){
    }
   
    public String getTitle(){
        return title;
    }

    public Integer getDuration(){
        return duration;
    }

    public Double getRating(){
        return rating;
    }

    public String getLinkURL(){
        return linkURL;
    }
    
    public Long getId(){
        return id;
    }

    public Collection<String> getComments(){
        return comments;
    }

    public void changeAlbum(Album album){
        this.album = album;
    }

    public void changeRating(Double newRating){ 
        rating = newRating;
    }

    public void addSongComment(String comment) {
        comments.add(comment);
    }
}

