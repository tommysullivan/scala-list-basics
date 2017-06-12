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

  "l1.addToEnd(2)" should "yield 1,2." in {
    l1.addToEnd(2).toString shouldEqual "1,2,."
  }

  "l0.addToEnd(1)" should "equal l1" in {
    l0.addToEnd(1) shouldEqual l1
  }

  "l3.addListToEnd(l2)" should "equal 3,2,1,2,1,." in {
    l3.addListToEnd(l2).toString shouldEqual "3,2,1,2,1,."
  }

  "l3.addListToBeginning(l2)" should "equal 2,1,3,2,1,." in {
    l3.addListToBeginning(l2).toString shouldEqual "2,1,3,2,1,."
  }

  "l3.map(x => x * x)" should "equal 9,4,1,." in {
    l3.map(x => x * x).toString shouldEqual "9,4,1,."
  }

  "l3.map(5 * _)" should "equal 15,10,5,." in {
    l3.map(5 * _).toString shouldEqual "15,10,5,."
  }

  "l5.filter(_ % 2 == 0)" should "equal 4,2,." in {
    l5.filter(_ % 2 == 0).toString shouldEqual "4,2,."
  }

  "l5.fold(_ + _, 0)" should "equal 15" in {
    l5.fold((a:Int,b:Int) => a + b, 0) shouldEqual 15
    l5.fold[Int](_ + _, 0) shouldEqual 15
  }

  "l5.fold(_ * _, 1)" should "equal 120" in {
    l5.fold((a:Int,b:Int) => a * b, 1) shouldEqual 120
    l5.fold[Int](_ * _, 1) shouldEqual 120
  }

}
