package es.iesraprog2425.pruebaes.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Fecha: IUtilFecha {

    override fun parseadorFecha(): DateTimeFormatter{
        return DateTimeFormatter.ofPattern("ddMMYYYYhhmmss")
    }

    override fun formatearFecha(fecha: LocalDateTime): String {
        return parseadorFecha().format(fecha)
    }

}