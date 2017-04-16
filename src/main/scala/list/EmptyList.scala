package list

case object EmptyList extends List[Nothing] {
  override def toString = "."
  def length = 0
}