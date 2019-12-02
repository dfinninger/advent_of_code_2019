package com.finninger.aoc2019

class Day01Test extends org.scalatest.FunSuite {
  test("part 1") {
    val input = List(12, 14, 1969, 100756)
    val output = 2 + 2 + 654 + 33583

    assert(Day01.calculateFuelRequirements(input) === output)
  }

  test("part 2") {
    assert(Day01.calculateFuelForFuel(654) === 966)
    assert(Day01.calculateFuelForFuel(33583) === 50346)
  }
}
