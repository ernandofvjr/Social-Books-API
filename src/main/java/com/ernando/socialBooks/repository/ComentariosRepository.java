package com.ernando.socialBooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ernando.socialBooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long>{

}
