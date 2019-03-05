package com.ernando.socialBooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O campo nome não pode ser vazio.")
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "O campo nascimento é de preenchimento obrigatório.")
	private Date nascimento;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "O campo nacionalidade é de preenchimento obrigatório.")
	private String nacionalidade;
	
	@OneToMany(mappedBy = "autor")
	@JsonIgnore
	private List<Livro> livros;
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public List<Livro> getLivros() {
		return livros;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
	
}
