package com.eks.kotlineks.data.vo.v1.request


import java.util.*

data class EventoRequestVO(
    var idEvento: Long = 0,
    var nomeEvento: String = "",
    var centroCusto: String = "",
    var descricaoEvento: String = "",
    var dataInicioVenda: Date? = null,
    var dataFinalVenda: Date? = null,
    var dataInicioEvento: Date? = null,
    var dataFinalEvento: Date? = null,
    var quantidadeConvitesGeral: Int? = null,
    var eventoPago: String = "",
    var bloquearEmissao: String = "",
    var portalConvite: String = "",
    var portalMesa: String = "",
    var tipoEvento: String = ""
)