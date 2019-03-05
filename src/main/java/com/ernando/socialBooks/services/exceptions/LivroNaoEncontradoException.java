package com.ernando.socialBooks.services.exceptions;

public class LivroNaoEncontradoException extends Exception{
	
	public LivroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public LivroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
