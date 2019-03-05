package com.ernando.socialBooks.services;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ernando.socialBooks.domain.Comentario;
import com.ernando.socialBooks.domain.Livro;
import com.ernando.socialBooks.repository.ComentariosRepository;
import com.ernando.socialBooks.repository.LivrosRepository;
import com.ernando.socialBooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {
	
	@Autowired
	private LivrosRepository livrosRepository;
	@Autowired
	private ComentariosRepository comentariosRepository;
	
	
	public List<Livro> listar(){
		return livrosRepository.findAll();
		
		
	}
	
	public Livro buscar(Long id) throws LivroNaoEncontradoException{
		

		
		try {
		
			Livro livro = livrosRepository.findById(id).get();
			
			if(livro == null) {
				throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
			}
			return livro;
			
		}catch(NoSuchElementException e) {
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
		}
		
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);
	}
	
	public void deletar(Long id) throws LivroNaoEncontradoException{
		
		try {
			
			livrosRepository.deleteById(id);
			
		}catch(EmptyResultDataAccessException e) {
			
			throw new LivroNaoEncontradoException("O livro não pode ser encontrado.");
			
		}
		
		
	}
	
	public void atualizar(Livro livro) throws LivroNaoEncontradoException {
		verificarExistencia(livro.getId());
		livrosRepository.save(livro);
	}
	
	private void verificarExistencia(Long id) throws LivroNaoEncontradoException {
		buscar(id);
	}
	
	
	public Comentario salvarComentario(Long livroId, Comentario comentario) throws LivroNaoEncontradoException {
		Livro livro = buscar(livroId);
		comentario.setLivro(livro);
		comentario.setData(new Date());
		
		return comentariosRepository.save(comentario);
		
		
	}
	
	public List<Comentario> listarComentarios(Long livroId) throws LivroNaoEncontradoException{
		Livro livro = buscar(livroId);
		
		return livro.getComentarios();
	}
	
}
