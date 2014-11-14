/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Lando Tanghe
 */
@Entity
@Table(name= "VOORKEUREN")
public class Voorkeur  implements Serializable{
    private int id;
    private int maxPrijs;
    private String genre;

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name= "MAX_PRIJS")
    public int getMaxPrijs() {
        return maxPrijs;
    }

    public void setMaxPrijs(int maxPrijs) {
        this.maxPrijs = maxPrijs;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
}
