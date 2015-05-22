/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import entities.Artist;
import helloRemote.ArtistBeanRemote;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jan
 */
@Stateless
    public class ArtistBean implements ArtistBeanRemote {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Artist> fetchArtists() {
        return em.createNamedQuery("Artist.findAll", Artist.class).getResultList();
    }

    @Override
    public void addArtist(String name) {
        Artist newArtist = new Artist();
        newArtist.setName(name);
        em.persist(newArtist);
    }
}
