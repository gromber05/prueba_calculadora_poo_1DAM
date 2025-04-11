package es.iesraprog2425.pruebaes.data

import es.iesraprog2425.pruebaes.model.Operadores
import es.iesraprog2425.pruebaes.utils.IUtilFicheros

class RepoOperaciones(private val fichero: IUtilFicheros): IRepoOperaciones, Serializador() {

    override fun guardarOperaciones(error: String, rutaArchivo: String) : Boolean{
        return if (fichero.existeFichero(rutaArchivo)) {
            fichero.agregarLinea(rutaArchivo, serializar(args= error))
        } else false
    }

    override fun guardarOperaciones(n1: Double, operador: Operadores, n2: Double, resutado: Double, rutaArchivo: String): Boolean {
        return if (fichero.existeFichero(rutaArchivo)) {
            fichero.agregarLinea(rutaArchivo, serializar(args = mutableListOf(n1.toString(), operador.toString(), n2.toString(), resutado.toString())))
        } else false
    }
}