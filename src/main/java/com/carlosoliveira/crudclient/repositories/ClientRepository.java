package com.carlosoliveira.crudclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlosoliveira.crudclient.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
