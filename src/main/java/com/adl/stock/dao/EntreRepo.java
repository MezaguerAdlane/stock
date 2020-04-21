package com.adl.stock.dao;

import com.adl.stock.Entity.Entre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(path = "Entres")
@CrossOrigin("*")
public interface EntreRepo extends JpaRepository<Entre, Long> {
    @RestResource(path = "/recheFact")
    public List<Entre> findByFacturContains(@Param("mc") String fact);
}
