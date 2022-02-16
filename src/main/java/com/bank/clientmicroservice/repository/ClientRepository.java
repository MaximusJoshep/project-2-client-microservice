package com.bank.clientmicroservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bank.clientmicroservice.model.Client;

public interface ClientRepository extends ReactiveMongoRepository<Client, String>{
	

}
