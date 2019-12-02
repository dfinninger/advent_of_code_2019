package com.finninger.aoc2019

import scala.annotation.tailrec
import scala.io.Source

object Day01 extends App {

  def fuelForWeight(weight: Int): Int = {
    val fuel = math.floor(weight / 3).intValue - 2

    if (fuel <= 0) 0
    else fuel
  }

  def calculateFuelRequirements(weights: List[Int]): Int =
    weights
      .map(fuelForWeight)
      .sum

  def calculateRecursiveFuelRequirements(weights: List[Int]): Int =
    weights
      .map(x =>{
        val fuel = fuelForWeight(x)
        calculateFuelForFuel(fuel)
      })
      .sum

  @tailrec
  def calculateFuelForFuel(weight: Int, accumulator: Int = 0): Int = {
    val resultWeight = fuelForWeight(weight)

    if (resultWeight <= 0) accumulator + weight
    else calculateFuelForFuel(resultWeight, accumulator + weight)
  }

  val moduleWeights: List[Int] = Source.fromResource("day01/input.txt")
    .getLines
    .toList
    .map(_.toInt)

  // part 1
  val baselineFuel = calculateFuelRequirements(moduleWeights)
  println(baselineFuel)

  // part 2
  // too high: 5006364
  println(calculateRecursiveFuelRequirements(moduleWeights))

}
