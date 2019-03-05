package com.ernando.socialBooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ernando.socialBooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{

}
