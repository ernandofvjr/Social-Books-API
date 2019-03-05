package com.ernando.socialBooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ernando.socialBooks.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long>{

}
