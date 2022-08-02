package com.eks.kotlineks.services

import com.eks.kotlineks.data.vo.v1.request.MesaRequestVO
import com.eks.kotlineks.data.vo.v1.response.MesaResponseVO
import com.eks.kotlineks.mapper.DozerMapper
import com.eks.kotlineks.model.Mesa
import com.eks.kotlineks.repository.AreaRepository
import com.eks.kotlineks.repository.MesaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger


@Service
class MesaService {

    @Autowired
    private lateinit var mesaRepository: MesaRepository

    @Autowired
    private lateinit var areaRepository: AreaRepository

    private val logger = Logger.getLogger(MesaService::class.java.name)

    fun buscarTodasMesas(): List<MesaResponseVO> {
        val mesas = mesaRepository.buscarMesas()
        return mesas.map { me -> DozerMapper.parseObject(me, MesaResponseVO::class.java) }
    }

    fun novaMesa(mesa: MesaRequestVO): String {
        val areaEntity = areaRepository.findById(1L)
        for (i in 1..mesa.quantidade) {
            val mesaEntity: Mesa = DozerMapper.parseObject(mesa, Mesa::class.java)
            mesaEntity.numeroMesa = i
            //mesaEntity.areaEvento = areaEntity.get()
            mesaEntity.situacao = "A"
        }
        return "Salvou"
    }
}