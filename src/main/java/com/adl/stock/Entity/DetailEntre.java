package com.adl.stock.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetailEntre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codeIn;
    private Float puHt;
    @ManyToOne
    private Produit produit;
    @ManyToOne
    private Entre entre;

    public Float getPuHt() {
        return puHt;
    }

    public void setPuHt(Float puHt) {
        this.puHt = puHt;
    }

    public Entre getEntre() {
        return entre;
    }

    public void setEntre(Entre entre) {
        this.entre = entre;
    }
}
