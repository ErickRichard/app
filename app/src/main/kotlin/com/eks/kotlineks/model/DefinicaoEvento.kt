package com.eks.kotlineks.model

import javax.persistence.*

@Entity
@Table(name = "definicao_evento")
class DefinicaoEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_definicao")
    var idDefinicao: Long = 0

    @Column(name = "evento_pago")
    var eventoPago: String = ""

    @Column(name = "bloquear_emissao")
    var bloquearEmissao: String = ""

    @Column(name = "liberar_portal_convite")
    var portalConvite: String = ""

    @Column(name = "liberar_portal_mesa")
    var portalMesa: String = ""

    @Column(name = "tipo_evento")
    var tipoEvento: String = ""

    @Column(name = "situacao")
    var situacaoEvento: String = ""

    @ManyToOne
    @JoinColumn(name = "id_evento", referencedColumnName = "id_evento")
    lateinit var evento: Evento

}

