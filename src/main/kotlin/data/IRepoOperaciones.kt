package es.iesraprog2425.pruebaes.data

import es.iesraprog2425.pruebaes.model.Operadores

interface IRepoOperaciones {
    fun guardarOperaciones(n1: Double, operador: Operadores, n2: Double, resultado: Double): Boolean
    fun guardarOperaciones(error: String): Boolean
}