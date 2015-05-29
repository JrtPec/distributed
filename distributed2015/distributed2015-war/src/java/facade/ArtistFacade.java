/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Artist;
import entities.Song;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import helloRemote.ArtistBeanRemote;
import java.util.List;

/**
 *
 * @author Jan
 */
@Named
@RequestScoped
public class ArtistFacade {
    private String name;
    private Artist artist;
    private List<Song> songs;
    
    @EJB
    private ArtistBeanRemote artistRemote;
    
    public ArtistFacade() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addArtist(){
        artistRemote.addArtist(this.getName());
    }

    public List<Artist> getArtists() {
        return artistRemote.fetchArtists();
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    
    public Artist fetchArtist(int id){
        this.setArtist(artistRemote.getArtistById(id));
        this.setName(this.artist.getName());
        this.setSongs(this.artist.getSongs());
        return artist;
    }
}