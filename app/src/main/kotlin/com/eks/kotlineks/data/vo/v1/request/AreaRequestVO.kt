package com.eks.kotlineks.data.vo.v1.request


data class AreaRequestVO(
    var idArea: Long = 0,
    var descricao: String = "",
    var observacao: String = "",
    var quantidadeConvitesArea: Int = 0,
    var tipoArea: String = "",
    var idEvento: Long = 0,
    var valorRequest: ValorRequestVO? = null,
    var quantidade: Int = 0,
)