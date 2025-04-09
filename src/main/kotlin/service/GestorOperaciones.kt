package es.iesraprog2425.pruebaes.service

import es.iesraprog2425.pruebaes.data.IRepoOperaciones
import es.iesraprog2425.pruebaes.model.Operadores
import es.iesraprog2425.pruebaes.ui.IEntradaSalida

class GestorOperaciones(private val repoOperaciones: IRepoOperaciones, private val consola: IEntradaSalida): IOperacionesService {

    override fun guardarOperaciones(error: String): Boolean {
        return repoOperaciones.guardarOperaciones(error)
    }

    override fun guardarOperaciones(n1: Double, operador: Operadores, n2: Double, resultado: Double): Boolean {
        return repoOperaciones.guardarOperaciones(n1, operador, n2, resultado)
    }


}