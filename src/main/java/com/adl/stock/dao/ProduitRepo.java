package com.adl.stock.dao;

import com.adl.stock.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(path = "Produits")
@CrossOrigin("*")
public interface ProduitRepo extends JpaRepository<Produit, String> {
}
