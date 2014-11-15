/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Lando Tanghe
 */

@Entity
@Table(name="BOEKEN")
public class Boek implements Serializable{
    private int id;
    private String isbn;
    private String titel;

    private Uitgeverij uitgeverij;
    private Set<Auteur> auteurs;
    
    public Boek() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    @ManyToOne()    
    @JoinColumn(name = "UITGEVERIJ")
    public Uitgeverij getUitgeverij() {
        return uitgeverij;
    }

    protected void setUitgeverij(Uitgeverij uitgeverij) {
        this.uitgeverij = uitgeverij;
    }

    @ManyToMany()
    @JoinTable(name = "UITGAVE_BOEKEN", joinColumns = @JoinColumn(name="BOEK"),inverseJoinColumns = @JoinColumn(name="AUTEUR"))
    private Set<Auteur> getAuteurs() {
        return auteurs;
    }

    private void setAuteurs(Set<Auteur> auteurs) {
        this.auteurs = auteurs;
    }
/*
    public Iterator<Auteur> getAuteurIterator(){
        return auteurs.iterator();
    }
  */  
    
    public String toString(){
        return titel+"("+isbn+")";
    }
}
