package com.finninger.aoc2019

import scala.annotation.tailrec
import scala.io.Source

object Day02 extends App {

  @tailrec
  def processOpcode(input: Array[Int], index: Int = 0): Array[Int] = {
    val opcode = input(index)
    if (opcode == 99) input
    else {
      val first = input(input(index + 1))
      val second = input(input(index + 2))
      val target = input(index + 3)

      if (opcode == 1) processOpcode(input.updated(target, first + second), index + 4)
      else if (opcode == 2) processOpcode(input.updated(target, first * second), index + 4)
      else throw new RuntimeException
    }
  }

  val program: Array[Int] = Source.fromResource("day02/input.txt")
    .getLines
    .mkString
    .split(",")
    .map(_.toInt)

  program.update(1, 12)
  program.update(2, 2)
  val completedProgram = processOpcode(program)
  println(completedProgram(0))

  // need to find 19690720
  for (noun <- 0 to 100) {
    for (verb <- 0 to 100) {
      program.update(1, noun)
      program.update(2, verb)
      val processed = processOpcode(program)
      if (processed(0) == 19690720) {
        println(100 * noun + verb)
      }
    }
  }
}
