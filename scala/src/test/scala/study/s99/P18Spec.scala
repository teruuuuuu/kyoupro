package study.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P18Spec extends FunSpec with DiagrammedAssertions {
  describe("P18") {
    it("for index less than 0, split(n, s) throws Exception") {
      intercept[Throwable] {
        P18.slice(-1, 1,List.empty[Int])
      }
      intercept[Throwable] {
        P18.slice(-1, 1, List(1))
      }
      intercept[Throwable] {
        P18.slice(-1, 1, List(1, 2))
      }

      intercept[Throwable] {
        P18.slice(1, 0,List(1,2,3,4,5))
      }
    }
    it("for list has one element, encode(s) is List((1, s))") {
      assert(P18.slice(1, 1, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List())
    }
    it("otherwise") {
      assert(P18.slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('d, 'e, 'f, 'g))
      assert(P18.slice(1, 2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) == List('b))

    }
  }
}