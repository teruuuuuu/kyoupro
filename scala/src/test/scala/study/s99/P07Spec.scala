package study.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P07Spec extends FunSpec with DiagrammedAssertions {
  describe("P07") {
    it("for empty list, flatten(s) is s") {
      assert(P07.flatten(List.empty[Int]) == List.empty[Int])
    }
    it("for list of empty list, flatten(List(List.empty)) is List.empty") {
      assert(P07.flatten(List(List.empty[Int])) == List.empty[Int])
    }
    it("otherwise") {
      assert(P07.flatten(List(List(1))) == List(1))
    }

    it("otherwise2") {
      assert(P07.flatten(List(List(1, List(2,3,4), List(5,6,List(7,8, List(9),10, List(11,List(12))))))) == List(1,2,3,4,5,6,7,8,9,10,11,12))
    }
  }
}