package com.ernando.socialBooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ernando.socialBooks.domain.Autor;
import com.ernando.socialBooks.repository.AutoresRepository;
import com.ernando.socialBooks.services.exceptions.AutorExistenteException;
import com.ernando.socialBooks.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresService {
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	
	public List<Autor> listar(){
		return autoresRepository.findAll();
	}
	
	public Autor salvar(Autor autor) throws AutorExistenteException {
		
//		if(autor.getId() != null) {
//			try {
//				Autor a = autoresRepository.findById(autor.getId()).get();
//				
//				throw new AutorExistenteException("O autor já existe");
//			}catch (NoSuchElementException e) {
//				return autoresRepository.save(autor);
//			}
//		}
//		return autoresRepository.save(autor);
		
		if(autor.getId() != null) {
			Optional<Autor> a = autoresRepository.findById(autor.getId());
			
			if(a.isPresent()) {
				throw new AutorExistenteException("O autor já existe");
			}
		}
		
		return autoresRepository.save(autor);
	}
	
	public Autor buscar(Long id) throws AutorNaoEncontradoException {
		
		Optional<Autor> autorBuscado = autoresRepository.findById(id);
		
		if(!autorBuscado.isPresent()) {
			throw new AutorNaoEncontradoException("O autor não pôde ser encontrado.");
		}
		
		return autorBuscado.get();
		
	}

}
