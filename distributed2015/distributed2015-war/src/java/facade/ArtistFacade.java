/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Artist;
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
}