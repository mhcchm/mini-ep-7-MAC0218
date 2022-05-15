package domain

class BoletimFechado(
    override var mediaEPs: Double,
    override var mediaMiniEPs: Double,
    var mediaFinal: Double,
    var foiAprovado: Boolean
) : Boletim(mediaEPs, mediaMiniEPs)