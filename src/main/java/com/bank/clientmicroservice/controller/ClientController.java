package com.bank.clientmicroservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.clientmicroservice.model.Client;
import com.bank.clientmicroservice.service.IClientService;


import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {
	private final IClientService service;
	
	@GetMapping("saluda")
	public ResponseEntity<String> getHello()
	{
		return ResponseEntity.ok("Funciona");
	}
	@GetMapping("")
	public Flux<Client> findAll(){
		
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Client> findById(@PathVariable String id){
		
		return service.findClientById(id);
	}
	
	
	
	@DeleteMapping("/{id}")
	void delete(@PathVariable String id){
		
		service.deleteById(id);
	}
	
	@PostMapping("/save")
	public Mono<Client> save(@RequestBody Client client){
		
		return service.save(client);
	}
	@PutMapping("/edit/{id}")
	void edit(@PathVariable String id, @RequestBody Client client){
		service.update(client, id);
	}
	

}
