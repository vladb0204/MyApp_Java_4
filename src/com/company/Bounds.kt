package com.company

class Bounds {
    fun bounds(elem: Int) {
        val elemChar: Char = elem.toChar()
        if (elemChar !in '0'..'9') {
            println("You need to input only numbers!!!")
        }
    }
}