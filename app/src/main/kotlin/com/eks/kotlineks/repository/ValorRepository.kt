package com.eks.kotlineks.repository

import com.eks.kotlineks.model.ValorArea
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ValorRepository : JpaRepository<ValorArea, Long?>
