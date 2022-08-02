package com.eks.kotlineks.model

import javax.persistence.*

@Entity
@Table(name = "area_evento")
class AreaEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area")
    var idArea: Long = 0

    @Column(name = "descricao")
    var descricao: String = ""

    @Column(name = "observacao")
    var observacao: String = ""

    @Column(name = "quantidade_convites")
    var quantidadeConvitesArea: Int = 0

    @Column(name = "situacao")
    var situacao: String = ""

    @ManyToOne
    @JoinColumn(name = "id_evento", referencedColumnName = "id_evento")
    lateinit var evento: Evento

    @ManyToOne
    @JoinColumn(name = "id_valor", referencedColumnName = "id_valor")
    lateinit var valorArea: ValorArea

}

