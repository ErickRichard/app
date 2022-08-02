package com.eks.kotlineks.services

import com.eks.kotlineks.data.vo.v1.request.AreaRequestVO
import com.eks.kotlineks.data.vo.v1.response.AreaResponseVO
import com.eks.kotlineks.mapper.DozerMapper
import com.eks.kotlineks.model.AreaEvento
import com.eks.kotlineks.model.Mesa
import com.eks.kotlineks.model.ValorArea
import com.eks.kotlineks.repository.AreaRepository
import com.eks.kotlineks.repository.EventoRepository
import com.eks.kotlineks.repository.MesaRepository
import com.eks.kotlineks.repository.ValorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger


@Service
class AreaEventoService {

    @Autowired
    private lateinit var areaRepository: AreaRepository

    @Autowired
    private lateinit var eventoRepository: EventoRepository

    @Autowired
    private lateinit var mesaRepository: MesaRepository

    @Autowired
    private lateinit var valorRepository: ValorRepository

    private val logger = Logger.getLogger(AreaEventoService::class.java.name)

    fun buscarTodasAreas(): List<AreaResponseVO> {
        val areas = areaRepository.buscarAreas()
        return areas.map { ar -> DozerMapper.parseObject(ar, AreaResponseVO::class.java) }
    }

    fun novaAreaEvento(areaEvento: AreaRequestVO): String {
        val eventoEntity = eventoRepository.findById(areaEvento.idEvento)
        val areaEntity: AreaEvento = DozerMapper.parseObject(areaEvento, AreaEvento::class.java)
        areaEntity.evento = eventoEntity.get()
        areaEntity.situacao = "A"

        val valorEntity: ValorArea = DozerMapper.parseObject(areaEvento.valorRequest, ValorArea::class.java)
        valorEntity.tipoPagamento = areaEvento.valorRequest!!.tipoPagamento
        valorEntity.preco = areaEvento.valorRequest!!.preco
        valorRepository.save(valorEntity)

        areaEntity.valorArea = valorEntity
        areaRepository.save(areaEntity)

        if (areaEvento.tipoArea == "MSA") {
            for (i in 1..areaEvento.quantidade) {
                val mesaEntity: Mesa = Mesa()
                mesaEntity.numeroMesa = i
                mesaEntity.situacao = "A"
                mesaEntity.areaEvento = areaEntity
                mesaRepository.save(mesaEntity)
            }
        }

        return "Salvou"
    }

}