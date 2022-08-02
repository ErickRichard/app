package com.eks.kotlineks.model

import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "area_mesa")
class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mesa")
    var idMesa: Long = 0

    @Column(name = "numero")
    var numeroMesa: Int = 0

    @Column(name = "situacao")
    var situacao: String = ""

    @ManyToOne
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    lateinit var areaEvento: AreaEvento
}

