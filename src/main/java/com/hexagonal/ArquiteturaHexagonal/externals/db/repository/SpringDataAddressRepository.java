package com.hexagonal.ArquiteturaHexagonal.externals.db.repository;

import com.hexagonal.ArquiteturaHexagonal.externals.entity.AdressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SpringDataAddressRepository extends JpaRepository<AdressEntity, Long> {

    @Query("SELECT a FROM AdressEntity a JOIN FETCH a.usuario WHERE a.id = :id")
    Optional<AdressEntity> findEnderecoComUsuario(@Param("id") Long id);
}

