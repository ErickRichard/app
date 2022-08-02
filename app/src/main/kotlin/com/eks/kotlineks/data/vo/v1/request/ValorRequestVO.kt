package com.eks.kotlineks.data.vo.v1.request


import java.math.BigDecimal

data class ValorRequestVO(
    var tipoPagamento: String = "",
    var preco: BigDecimal? = null
)