package com.bank.clientmicroservice.service;
import com.bank.clientmicroservice.model.Client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface IClientService {
	Flux<Client> findAll();
	Mono<Client> save(Client client);
	Mono<Client> findClientById(String id);
	void deleteById(String id);
	void update(Client client, String id);

}
