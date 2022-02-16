package com.bank.clientmicroservice.service;

import org.springframework.stereotype.Service;

import com.bank.clientmicroservice.model.Client;
import com.bank.clientmicroservice.repository.ClientRepository;


import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ClientServiceDB implements IClientService{
	
	private final ClientRepository repository;

	@Override
	public Flux<Client> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<Client> save(Client client) {
		// TODO Auto-generated method stub
		return repository.save(client);
	}

	@Override
	public Mono<Client> findClientById(String id) {
		// TODO Auto-generated method stub
		
		return repository.findById(id);
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}
	public Client getObject(Mono<Client> mono_client)
	{
		return mono_client.block();
	}
	@Override
	public void update(Client client, String id)
	{
		Mono<Client> mono_client_wanted=repository.findById(id);
		Client client_wanted=getObject(mono_client_wanted);
		client_wanted.setDni(client.getDni());
		client_wanted.setName(client.getName());
		client_wanted.setType(client.getType());
		repository.save(client_wanted);
		
	}

}
