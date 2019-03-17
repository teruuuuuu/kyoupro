package study.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P20Spec extends FunSpec with DiagrammedAssertions {
  describe("P20") {
    it("otherwise") {
      assert(P20.removeAt(1, List('a, 'b, 'c, 'd)) == (List('a, 'c, 'd),'b))
    }
  }
}