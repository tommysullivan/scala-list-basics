package list

import org.scalatest._

class ListSpec extends FlatSpec with Matchers {
  def l0 = EmptyList
  def l1 = new NonEmptyList(1, l0)
  def l2 = new NonEmptyList(2, l1)
  def l3 = new NonEmptyList(3, l2)
  def l4 = new NonEmptyList(4, l3)
  def l5 = new NonEmptyList(5, l4)

  "construction" should "allow strings" in {
    val listOfTwoStrings = new NonEmptyList("A",new NonEmptyList("B",EmptyList))
    listOfTwoStrings.toString shouldEqual "A,B,."
  }

  def expectedL5StringRepresentation = "5,4,3,2,1,."
  "toString" should s"print $expectedL5StringRepresentation" in {
    l5.toString shouldEqual expectedL5StringRepresentation
  }

  "length" should "be 5" in {
    l5.length shouldEqual 5
  }

  "l4.addToBeginning(5)" should "yield l5" in {
    l4.addToBeginning(5) shouldEqual l5
  }

  "l0.addToBeginning(1)" should "equal l1" in {
    l0.addToBeginning(1) shouldEqual l1
  }
}
