package com.api.locadoradejogos.repositories;

import com.api.locadoradejogos.models.LocacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocacaoRepository extends JpaRepository<LocacaoModel, UUID> {
}
