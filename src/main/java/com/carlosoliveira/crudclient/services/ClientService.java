package com.carlosoliveira.crudclient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carlosoliveira.crudclient.dto.ClientDTO;
import com.carlosoliveira.crudclient.entities.Client;
import com.carlosoliveira.crudclient.repositories.ClientRepository;
import com.carlosoliveira.crudclient.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional
	public ClientDTO findById(Long id) {
		Client client = repository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Tentei, mas não foi dessa vez. Recurso não encontrado."));
		return new ClientDTO(client);
	}
	
	@Transactional
	public Page<ClientDTO> findAll(Pageable pageable){
		Page<Client> result = repository.findAll(pageable);
		return result.map(x -> new ClientDTO(x));
		
	}
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		
		copyDtoToEntity(dto, entity); //Copiou
		entity = repository.save(entity);//Salvou
		return new ClientDTO(entity);
		
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client entity = new Client();
			entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity); //Copiou
			entity = repository.save(entity);//Salvou
			return new ClientDTO(entity);	
		}
		catch (EntityNotFoundException e) {
			
			throw new ResourceNotFoundException("Recurso não encontrado. Nada feito.");
			
		}
	}
	
	private void copyDtoToEntity(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
	}
	@Transactional
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Cadê? Cadê? O que não tem remédio... é isso aí! Recurso não encontrado");
		}
		repository.deleteById(id);
	}

}
