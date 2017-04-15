//Q:
trait List {
}

case object EmptyList extends List {
  override def toString = "."
}

case class NonEmptyList(firstElement:Int, allOtherElements:List) extends List {
  override def toString = s"$firstElement,$allOtherElements"
}

val l0 = EmptyList
val l1 = new NonEmptyList(1, l0)
val l2 = new NonEmptyList(2, l1)
val l3 = new NonEmptyList(3, l2)
val l4 = new NonEmptyList(4, l3)
val l5 = new NonEmptyList(5, l4)