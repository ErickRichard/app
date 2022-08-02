package com.eks.kotlineks.model

import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "valor_area")
class ValorArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valor")
    var idValor: Long = 0

    @Column(name = "tipo_pagamento")
    var tipoPagamento: String = ""

    @Column(name = "preco")
    var preco: BigDecimal? = null

}

