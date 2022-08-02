package com.eks.kotlineks.data.vo.v1.response


data class MesaResponseVO(
    var idMesa: Long = 0,
    var numeroMesa: Int = 0,
    var situacao: String = "",
    var areaEvento: AreaResponseVO? = null
)