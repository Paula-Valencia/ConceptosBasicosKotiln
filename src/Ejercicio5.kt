//Ejercicio 5
open class Phone(var isScreenLightOn: Boolean = false) {
    // Método para encender la pantalla
    open fun switchOn() {
        isScreenLightOn = true
    }
    // Método para apagar la pantalla
    fun switchOff() {
        isScreenLightOn = false
    }

    // Método para comprobar el estado de la luz de la pantalla del teléfono
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}


// Clase derivada FoldablePhone
class FoldablePhone(isScreenLightOn: Boolean = false, var isFolded: Boolean = true) : Phone(isScreenLightOn) {
    // Sobrescribe el método switchOn para encender la pantalla solo si el teléfono no está plegado
    override fun switchOn() {
        if (!isFolded) {
            isScreenLightOn = true
        } else {
            println("No se puede encender la pantalla mientras el teléfono está plegado.")
        }
    }

    // Método para plegar el teléfono
    fun fold() {
        isFolded = true
        switchOff() // Apaga la pantalla cuando el teléfono se pliega
    }

    // Método para desplegar el teléfono
    fun unfold() {
        isFolded = false
    }
}

// Ejemplo de uso
fun main() {
    val myFoldablePhone = FoldablePhone()

    myFoldablePhone.checkPhoneScreenLight() // La luz de la pantalla del teléfono está apagada.

    myFoldablePhone.switchOn() // No se puede encender la pantalla mientras el teléfono está plegado.
    myFoldablePhone.checkPhoneScreenLight() // La luz de la pantalla del teléfono está apagada.

    myFoldablePhone.unfold()
    myFoldablePhone.switchOn()
    myFoldablePhone.checkPhoneScreenLight() // La luz de la pantalla del teléfono está encendida.

    myFoldablePhone.fold()
    myFoldablePhone.checkPhoneScreenLight() // La luz de la pantalla del teléfono está apagada.
}

