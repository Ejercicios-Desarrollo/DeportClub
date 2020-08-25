package domain.trofeos;

import domain.Persistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trofeo")
public class Trofeo extends Persistente {
    @Column(name = "descripcion")
    private String descripcion;

    public Trofeo(){

    }

    public Trofeo(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
