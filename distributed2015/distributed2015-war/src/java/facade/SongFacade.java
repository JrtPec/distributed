/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Song;
import entities.Artist;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import helloRemote.SongBeanRemote;
import helloRemote.ArtistBeanRemote;
import java.util.List;

/**
 *
 * @author Jan
 */
@Named
@RequestScoped
public class SongFacade {
    private String name;
    private int artistId;
    
    @EJB
    private SongBeanRemote songRemote;
    
    @EJB
    private ArtistBeanRemote artistRemote;
    
    public SongFacade() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
    
    public void addSong(){
        Artist a = artistRemote.getArtistById(this.artistId);
        songRemote.addSong(this.getName(), a);
    }

    public List<Song> getSongs() {
        return songRemote.fetchSongs();
    }
}