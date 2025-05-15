package com.carlosoliveira.crudclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlosoliveira.crudclient.dto.ClientDTO;
import com.carlosoliveira.crudclient.services.ClientService;

@RestController
@RequestMapping(value="/clients")
public class ClientController{

	@Autowired
	private ClientService service;
	@GetMapping(value="/{id}")
	public ResponseEntity<ClientDTO> findByID(@PathVariable Long id){
		ClientDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable){
		Page<ClientDTO> dto = service.findAll(pageable);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ClientDTO insert(@RequestBody ClientDTO dto){
		return service.insert(dto);
	}
	
	@PutMapping(value="/{id}")
	public ClientDTO update(@PathVariable Long id, @RequestBody ClientDTO dto){
		dto = service.update(id, dto);
		return dto;
	}
	
}
