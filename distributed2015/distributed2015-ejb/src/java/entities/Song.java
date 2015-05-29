/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arne
 */
@Entity
@Table(name = "SONG")
@XmlRootElement
@NamedQueries ({
    @NamedQuery(name="Song.findAll",
            query="SELECT S FROM Song S"),
    @NamedQuery(name="Song.findId",
            query="SELECT S FROM Song S WHERE S.id = :songid"),
})
public class Song implements Serializable {
    private static final long serialVersionUID = 1L;
    @ManyToMany
    private List<Person> persons;
    @ManyToOne
    private Artist artist;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAME")
    private String name;
    
    public enum Genre{ROCK,CLASSIC,POP,RAP,ELECTRONIC};
    
    @Enumerated(EnumType.ORDINAL)
    private Genre genre;
    
    public Genre getGenre(){
        return genre;
    }
    public Long getId() {
        return id;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    
    public void addPerson(Person person){
        this.persons.add(person);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Song)) {
            return false;
        }
        Song other = (Song) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Song[ id=" + id + " ]";
    }
    
}
