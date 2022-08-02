package com.eks.kotlineks.repository

import com.eks.kotlineks.model.Mesa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MesaRepository : JpaRepository<Mesa, Long?> {

    @Query("SELECT m FROM Mesa m WHERE 1=1")
    fun buscarMesas(): List<Mesa>

}
