package com.adl.stock.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Entre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateIn;
    private String factur;
    @OneToMany(mappedBy = "entre", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<DetailEntre> detailEntre;

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public void setFactur(String factur) {
        this.factur = factur;
    }

    public void setDetailEntre(List<DetailEntre> detailEntre) {
        this.detailEntre = detailEntre;
    }


    //  @OneToOne
    //  private Categorie categorie;

}
