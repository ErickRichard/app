package com.eks.kotlineks.data.vo.v1.response


data class AreaResponseVO(
    var idArea: Long = 0,
    var descricao: String = "",
    var observacao: String = "",
    var quantidadeConvitesArea: Int = 0,
    var evento: EventoResponseVO? = null
)