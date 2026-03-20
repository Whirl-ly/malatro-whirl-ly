package cl.uchile.dcc
package mcd

/*
El siguiente import es necesario sí quieren leer números enteros desde la consola.
Pueden leer un entero de la siguiente forma:

  val a = readInt()
  
y luego usarlo como deseen

  val res = a + 5
  println(s"El resultado del número ingresado más 5 es $res")
  
*/
import scala.io.StdIn.readInt
import scala.annotation.tailrec

@main def euclidesInteractivo(): Unit = {
  // Inicio de la zona donde deben editar el código
  
  //por sugerencia de Scala colocamos @tailrec 
  @tailrec
  def mcd(p: Int, q:Int):  Int = {

    if (q == 0) p 
    else mcd(q, p%q)
  }
  println("Ingrese el primer número (0 para salir): ")
  val a: Int = readInt()

  if (a == 0) println("Adiós!")
  else
    println("Ingrese el segundo número ")
    val b: Int = readInt()
    val c: Int = mcd(a,b)
    println(s"El MCD de $a y $b es $c")


  // Fin de la zona donde deben editar el código
}
