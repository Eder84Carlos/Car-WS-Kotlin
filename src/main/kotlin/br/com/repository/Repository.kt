package br.com.repository;

import org.springframework.stereotype.Repository
import br.com.model.Factories
import org.springframework.data.jpa.repository.JpaRepository


@Repository
interface Repository: JpaRepository<Factories,Long>