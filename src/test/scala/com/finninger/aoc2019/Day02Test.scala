package com.finninger.aoc2019

import org.scalatest.FunSuite
import org.scalatest.prop.TableDrivenPropertyChecks._

class Day02Test extends FunSuite {

  test("part 1") {
    val testPrograms = Table(
      ("initial", "expected"),
      (Array(1, 0, 0, 0, 99), Array(2, 0, 0, 0, 99)),
      (Array(2, 3, 0, 3, 99), Array(2, 3, 0, 6, 99)),
      (Array(2, 4, 4, 5, 99, 0), Array(2, 4, 4, 5, 99, 9801)),
      (Array(1, 1, 1, 4, 99, 5, 6, 0, 99), Array(30, 1, 1, 4, 2, 5, 6, 0, 99)),
    )

    forAll(testPrograms) { (initial: Array[Int], expected: Array[Int]) =>
      val completed = Day02.processOpcode(initial)
      assert(completed sameElements expected)
    }
  }

}
