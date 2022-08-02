package com.eks.kotlineks.model

import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "evento")
class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    var idEvento: Long = 0

    @Column(name = "centro_custo")
    var centroCusto: String = ""

    @Column(name = "nome")
    var nomeEvento: String = ""

    @Column(name = "descricao")
    var descricaoEvento: String = ""

    @Column(name = "data_inicio_venda")
    var dataInicioVenda: Date? = null

    @Column(name = "data_final_venda")
    var dataFinalVenda: Date? = null

    @Column(name = "data_inicio_evento")
    var dataInicioEvento: Date? = null

    @Column(name = "data_final_evento")
    var dataFinalEvento: Date? = null

    @Column(name = "quantidade_convites_geral")
    var quantidadeConvitesGeral: Int = 0

}

