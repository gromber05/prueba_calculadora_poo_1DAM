package es.iesraprog2425.pruebaes.service

import es.iesraprog2425.pruebaes.model.Operadores

interface IOperacionesService {
    fun guardarOperaciones(n1: Double, operador: Operadores, n2: Double, resultado: Double,  rutaArchivo: String): Boolean
    fun guardarOperaciones(error: String, rutaArchivo: String): Boolean
}