package pl.tomaszperek.projecteuler57

import scala.annotation.tailrec

/**
 * Created by tomasz on 5/4/14.
 */
object PE57 extends App {

  @tailrec
  def calculate(howMuchMore : BigInt, foundSoFar : List[(BigInt, BigInt)], prevNumerator : BigInt, prevDenominator: BigInt) : List[(BigInt, BigInt)] = {
    if (howMuchMore == 0) foundSoFar
    else {
      val numerator = prevNumerator + 2 * prevDenominator
      val denominator = prevNumerator + prevDenominator
      val numDigits = Math.floor(Math.log10(numerator.toDouble))
      val denomDigits = Math.floor(Math.log10(denominator.toDouble))
      val newFoundSoFar = if (numDigits > denomDigits) (numerator, denominator) :: foundSoFar else foundSoFar
      calculate(howMuchMore -1, newFoundSoFar, numerator, denominator)
    }
  }
  
  def calculateSolution =  calculate(1000, Nil, 3, 2)

  val startMs = System.currentTimeMillis();
  private val solutuion: List[(BigInt, BigInt)] = calculateSolution
  println(solutuion)
  println(s"found items: ${solutuion.length}")
  println(s"time taken: ${System.currentTimeMillis() - startMs} ms")


}
