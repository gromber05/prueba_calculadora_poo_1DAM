package es.iesraprog2425.pruebaes.utils

import es.iesraprog2425.pruebaes.data.IExportable
import es.iesraprog2425.pruebaes.ui.IEntradaSalida
import java.io.File
import java.io.IOException

open class Ficheros(private val consola: IEntradaSalida) :IUtilFicheros {

    override fun existeDirectorio(ruta: String): Boolean {
        return File(ruta).exists() && File(ruta).isDirectory
    }

    override fun existeFichero(ruta: String): Boolean {
        return File(ruta).exists() && File(ruta).isFile
    }

    override fun leerArchivo(ruta: String): List<String> {
        return try {
            File(ruta).readLines()
        } catch (e: IOException) {
            consola.mostrarError(e.message.toString())
            emptyList()
        }
    }

    override fun agregarLinea(ruta: String, linea: String): Boolean {
        return try {
            File(ruta).appendText("$linea\n")
            true
        } catch (e: IOException) {
            consola.mostrarError(e.message.toString())
            true
        }
    }

    override fun <T: IExportable> escribirArchivo(ruta: String, elementos: List<T>): Boolean {
        return try {
            File(ruta).writeText(elementos.joinToString("\n") { it.serializar() })
            true
        } catch (e: IOException) {
            consola.mostrarError(e.message.toString())
            false
        }
    }

    override fun crearDirectorio(ruta: String): Boolean {
        return try {
            File(ruta).mkdir()
        } catch (e: IOException) {
            consola.mostrarError(e.message.toString())
            false
        }
    }

    override fun crearFichero(ruta: String): Boolean {
        return try {
            File(ruta).createNewFile()
        } catch (e: IOException) {
            consola.mostrarError(e.message.toString())
            false
        }
    }

}