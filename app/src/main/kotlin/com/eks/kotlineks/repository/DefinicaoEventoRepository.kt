package com.eks.kotlineks.repository

import com.eks.kotlineks.model.DefinicaoEvento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface DefinicaoEventoRepository : JpaRepository<DefinicaoEvento, Long?>

