/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloRemote;

import entities.Artist;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jan
 */
@Remote
public interface ArtistBeanRemote {
    public List<Artist> fetchArtists();
    public void addArtist(String name);
    public Artist getArtistById(int id);
}
