package es.iesraprog2425.pruebaes.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

interface IUtilFecha {

    fun parseadorFecha(): DateTimeFormatter

    fun formatearFecha(fecha: LocalDateTime): String

}