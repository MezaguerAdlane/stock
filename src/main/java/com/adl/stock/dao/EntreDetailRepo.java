package com.adl.stock.dao;

import com.adl.stock.Entity.DetailEntre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EntreDetailRepo extends JpaRepository<DetailEntre, Integer> {

}
