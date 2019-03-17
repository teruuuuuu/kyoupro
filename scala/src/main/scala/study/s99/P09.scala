package study.s99

object P09 {
  def pack[T](list: List[T]): List[List[T]] =
    list.foldRight(Nil: List[List[T]]) { (e, ls) =>
      ls match {
        case (x @ `e` :: _) :: xs => (e :: x) :: xs
//        case (x :: l) :: xs if x == e => (e :: x :: l) :: xs
        case _                    => List(e) :: ls
      }
    }
}