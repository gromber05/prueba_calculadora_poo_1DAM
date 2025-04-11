package es.iesraprog2425.pruebaes

import es.iesraprog2425.pruebaes.app.Calculadora
import es.iesraprog2425.pruebaes.data.RepoOperaciones
import es.iesraprog2425.pruebaes.service.GestorOperaciones
import es.iesraprog2425.pruebaes.ui.Consola
import es.iesraprog2425.pruebaes.utils.Fecha
import es.iesraprog2425.pruebaes.utils.Ficheros

fun main() {

    val rutaArchivo = "./logs"

    val consola = Consola()
    val gestorFicheros = Ficheros(consola)

    val repoOperaciones = RepoOperaciones(gestorFicheros)

    val gestorOperaciones = GestorOperaciones(repoOperaciones, consola)
    val gestorFecha = Fecha()

    val calculadora = Calculadora(consola, gestorFicheros, gestorOperaciones, rutaArchivo, gestorFecha)
    calculadora.iniciar()

}
