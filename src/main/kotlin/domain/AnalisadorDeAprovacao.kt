package domain

import domain.criterios.Basico
import domain.criterios.CriterioDeAprovacao
import domain.criterios.Intermediario
import domain.criterios.Rigoroso
import domain.Boletim
import domain.BoletimFechado

class AnalisadorDeAprovacao {

    // ---------------------------------
    //
    //      Seu código deve vir aqui
    //
    //      Defina atributos e métodos conforme especificado
    //      no arquivo de teste encontrado em
    //      'src/test/kotlin/domain/AnalisadorDeAprovacaoTest'
    //
    // ---------------------------------

    lateinit var criterioAp: CriterioDeAprovacao
    var boletimF = BoletimFechado(mediaEPs = 0.0, mediaMiniEPs = 0.0, mediaFinal = 0.0, foiAprovado = false)
    fun defineCriterio(criterio: CriterioDeAprovacao): CriterioDeAprovacao {
        criterioAp = criterio
        return criterioAp
    }

    fun fechaBoletim(boletim: Boletim): BoletimFechado {

        boletimF.mediaEPs = boletim.mediaEPs
        boletimF.mediaMiniEPs = boletim.mediaMiniEPs

        boletimF.mediaFinal = criterioAp.mediaFinal(boletim)
        boletimF.foiAprovado = criterioAp.estaAprovado(boletim)
        return boletimF
    }
}
