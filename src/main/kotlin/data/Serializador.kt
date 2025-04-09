package es.iesraprog2425.pruebaes.data

open class Serializador: IExportable {

    override fun serializar(separador: String, args: String): String {
        return args
        TODO("Revisar esto")
    }

    override fun serializar(separador: String, args: List<String>): String {
        return if (args.size == 4) {
                return "${args[0]}$separador${args[1]}$separador${args[2]}$separador${args[3]}"
        } else throw Exception()
    }
}