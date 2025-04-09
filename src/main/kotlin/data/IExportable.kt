package es.iesraprog2425.pruebaes.data

interface IExportable {
    fun serializar(separador: String = ";", args: List<String> = mutableListOf<String>()): String
    fun serializar(separador: String = ";", args: String): String
}