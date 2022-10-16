package topcoder.batchsystem

import org.scalatest.{DiagrammedAssertions, FunSpec}

class BatchSystemSpec extends FunSpec with DiagrammedAssertions {
  describe("BatchSystem") {
    it("q1") {
      val durations = Array(400, 100, 100, 100)
      val users = Array("Danny", "Stella", "Stella", "Mac")
      val ans = Array(3, 1, 2, 0)

      val result = BatchSystem.schedule(durations, users)
      assert(ans.deep == result.deep)
    }
  }
}
