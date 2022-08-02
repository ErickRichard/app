package com.eks.kotlineks.repository

import com.eks.kotlineks.model.AreaEvento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AreaRepository : JpaRepository<AreaEvento, Long?> {

    @Query("SELECT a FROM AreaEvento a WHERE 1=1")
    fun buscarAreas(): List<AreaEvento>

}
