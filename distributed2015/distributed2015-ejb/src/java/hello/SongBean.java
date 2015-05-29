/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import entities.Song;
import entities.Artist;
import helloRemote.SongBeanRemote;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jan
 */
@Stateless
    public class SongBean implements SongBeanRemote {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Song> fetchSongs() {
        return em.createNamedQuery("Song.findAll", Song.class).getResultList();
    }

    @Override
    public void addSong(String name, Artist artist) {
        Song newSong = new Song();
        newSong.setName(name);
        newSong.setArtist(artist);
        
        artist.addSong(newSong);
        
        em.merge(artist);
    }
}