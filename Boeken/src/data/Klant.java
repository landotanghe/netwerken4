/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Lando Tanghe
 */
@Entity
@Table(name="KOPERS")
@PrimaryKeyJoinColumn(name="PID")
@DiscriminatorValue(value = "koper")
public class Klant extends Persoon implements Serializable{
    private String type;

    private Voorkeur voorkeur;
    
    public Klant() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToOne(optional=false)
    @JoinColumn(name = "VOORKEUR",unique = true,nullable = false,updatable = false)
    public Voorkeur getVoorkeur() {
        return voorkeur;
    }

    public void setVoorkeur(Voorkeur voorkeur) {
        this.voorkeur = voorkeur;
    }
    
    
}
