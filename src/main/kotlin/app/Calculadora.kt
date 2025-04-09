package es.iesraprog2425.pruebaes.app

import es.iesraprog2425.pruebaes.data.IRepoOperaciones
import es.iesraprog2425.pruebaes.model.Operadores
import es.iesraprog2425.pruebaes.service.IOperacionesService
import es.iesraprog2425.pruebaes.ui.IEntradaSalida
import es.iesraprog2425.pruebaes.utils.IUtilFicheros
import java.time.LocalDate
import java.time.LocalDateTime

class Calculadora(
    private val ui: IEntradaSalida,
    private val gestorFicheros: IUtilFicheros,
    private val gestorOperaciones: IOperacionesService,
    private var rutaArchivo: String
) {

    private fun pedirNumero(msj: String, msjError: String = "Número no válido!"): Double {
        return ui.pedirDouble(msj) ?: throw InfoCalcException(msjError)
    }

    private fun pedirInfo() = Triple(
        pedirNumero("Introduce el primer número: ", "El primer número no es válido!"),
        Operadores.getOperador(ui.pedirInfo("Introduce el operador (+, -, *, /): ").firstOrNull())
            ?: throw InfoCalcException("El operador no es válido!"),
        pedirNumero("Introduce el segundo número: ", "El segundo número no es válido!"))

    private fun realizarCalculo(numero1: Double, operador: Operadores, numero2: Double) =
        when (operador) {
            Operadores.SUMA -> numero1 + numero2
            Operadores.RESTA -> numero1 - numero2
            Operadores.MULTIPLICACION -> numero1 * numero2
            Operadores.DIVISION -> numero1 / numero2
        }

    fun iniciar() {
        do {

            gestorFicheros.crearDirectorio(rutaArchivo)
            rutaArchivo = "$rutaArchivo/log${LocalDateTime.now()}.txt"

            while (!gestorFicheros.existeFichero(rutaArchivo)) {
                if (!gestorFicheros.existeFichero(rutaArchivo)){
                    ui.mostrar("No hay creada ruta de log")
                    gestorFicheros.crearFichero(rutaArchivo)
                } else if (gestorFicheros.leerArchivo(rutaArchivo).isEmpty()) {
                    ui.mostrar("El log está vacío")
                } else {
                    gestorFicheros.leerArchivo(rutaArchivo).forEach { linea ->
                        ui.mostrar(linea)
                    }
                }

                ui.pausa(2000)
            }


            try {
                ui.limpiarPantalla()
                val (numero1, operador, numero2) = pedirInfo()
                val resultado = realizarCalculo(numero1, operador, numero2)
                gestorOperaciones.guardarOperaciones(numero1, operador, numero2, resultado)
                ui.mostrar("Resultado: %.2f".format(resultado))
            } catch (e: NumberFormatException) {
                ui.mostrarError(e.message ?: "Se ha producido un error!")
                // Ahora captura el nuevo error, que hacía que el programa no se ejecutase como se esperaba
                gestorOperaciones.guardarOperaciones(e.message ?: "Se ha producido un error!")
            } catch (ie: InfoCalcException) {
                ui.mostrarError(ie.message ?: "Se ha producido un error!")
                gestorOperaciones.guardarOperaciones(ie.message ?: "Se ha producido un error!")
            } catch (ex: Exception) {
                ui.mostrarError(ex.message ?: "Se ha producido un error!")
                gestorOperaciones.guardarOperaciones(ex.message ?: "Se ha producido un error!")
            }
        } while (ui.preguntar())
        ui.limpiarPantalla()
    }

}