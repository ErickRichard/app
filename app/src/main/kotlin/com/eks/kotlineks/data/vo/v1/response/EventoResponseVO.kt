package com.eks.kotlineks.data.vo.v1.response


import java.util.*

data class EventoResponseVO(
    var idEvento: Long = 0,
    var nomeEvento: String = "",
    var descricaoEvento: String = "",
    var dataInicioVenda: Date? = null,
    var dataFinalVenda: Date? = null,
    var dataInicioEvento: Date? = null,
    var dataFinalEvento: Date? = null,
    var quantidadeConvitesGeral: Int? = null
)