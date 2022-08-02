package com.eks.kotlineks.repository

import com.eks.kotlineks.model.Evento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface EventoRepository : JpaRepository<Evento, Long?> {

    @Query("SELECT e FROM Evento e WHERE 1=1")
    fun buscarTodosEventos(): List<Evento>

}


