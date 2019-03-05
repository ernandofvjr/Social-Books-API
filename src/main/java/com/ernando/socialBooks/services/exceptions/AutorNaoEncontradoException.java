package com.ernando.socialBooks.services.exceptions;

public class AutorNaoEncontradoException extends Exception{
	
	public AutorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public AutorNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
