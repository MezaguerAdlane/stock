package com.adl.stock.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Produit implements Serializable {
    @Id
    private String refProd;
    private String libProd;
    private String typeProd;
    private Float tva;
    private String nLot;
    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DetailEntre> detailEntres;


}
