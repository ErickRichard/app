package com.eks.kotlineks.services

import com.eks.kotlineks.data.vo.v1.request.EventoRequestVO
import com.eks.kotlineks.data.vo.v1.response.EventoResponseVO
import com.eks.kotlineks.mapper.DozerMapper
import com.eks.kotlineks.model.DefinicaoEvento
import com.eks.kotlineks.model.Evento
import com.eks.kotlineks.repository.DefinicaoEventoRepository
import com.eks.kotlineks.repository.EventoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger


@Service
class EventoService {

    @Autowired
    private lateinit var eventoRepository: EventoRepository

    @Autowired
    private lateinit var definicaoEventoRepository: DefinicaoEventoRepository

    private val logger = Logger.getLogger(EventoService::class.java.name)

    fun buscarTodosEventos(): List<EventoResponseVO> {
        val eventos = eventoRepository.buscarTodosEventos();
        return eventos.map { ev -> DozerMapper.parseObject(ev, EventoResponseVO::class.java) }
    }

    fun novoEvento(evento: EventoRequestVO): EventoRequestVO {
        val eventoEntity: Evento = DozerMapper.parseObject(evento, Evento::class.java)
        val eventoCriado: EventoRequestVO = DozerMapper.parseObject(eventoRepository.save(eventoEntity), EventoRequestVO::class.java)
        val definicaoEvento = DefinicaoEvento()
        definicaoEvento.eventoPago = evento.eventoPago
        definicaoEvento.bloquearEmissao = evento.bloquearEmissao
        definicaoEvento.portalConvite = evento.portalConvite
        definicaoEvento.portalMesa = evento.portalMesa
        definicaoEvento.tipoEvento = evento.tipoEvento
        definicaoEvento.evento = eventoEntity
        definicaoEvento.situacaoEvento = "A"
        definicaoEventoRepository.save(definicaoEvento)
        return eventoCriado
    }
}