/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa4_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Viktor
 */
@Entity
public class Kniha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nazov;

    // Nvm co sa stalo, asi ked nemame vytvorene referencovane data tak si ich vytvori samo aby to nepadlo
    @ManyToMany(cascade=CascadeType.PERSIST)
    private List<Osoba> autor = new ArrayList<Osoba>();

    Kniha(){
    
    }
    
    Kniha(String nazov){
        this.nazov = nazov;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public List<Osoba> getAutor() {
        return autor;
    }

    public void setAutor(List<Osoba> autor) {
        this.autor = autor;
    }
    
    public void addAutor(Osoba autor)
    {
        this.autor.add(autor);
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
        if (!(object instanceof Kniha)) {
            return false;
        }
        Kniha other = (Kniha) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vsa4_1.Kniha[ id=" + id + " ]";
    }
    
}
