package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {
	
	//Injetando os dados no banco
	@Autowired
	private PostagemRepository repository;
	
	//Buscando a lista de dados do banco
	@GetMapping
	public ResponseEntity<List<PostagemModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//Fazendo a busca por Id
	@GetMapping("/{id}")
	public Optional<PostagemModel> getById(@PathVariable Long id){
		return repository.findById(id);
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<PostagemModel>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping("/postagem")
	public PostagemModel criar(@RequestBody PostagemModel itemPostagem) {
		repository.save(itemPostagem);
		return itemPostagem;
	}
	
	
}
