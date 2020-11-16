package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	
	@Query(value="select * from postagem where ano > 2011", nativeQuery = true)
	List<Postagem> findAllMaior();
	
	@Query(value="select * from postagem ORDER BY ano DESC", nativeQuery = true)
	List<Postagem> anoDesc();
	
	@Query(value="select * from postagem ORDER BY ano ASC", nativeQuery = true)
	List<Postagem> anoAsc();
	
	@Query(value="select * from postagem where ano >= 2011 and ano <= 2013", nativeQuery = true)
	List<Postagem> anosIntervalo();
	
}
