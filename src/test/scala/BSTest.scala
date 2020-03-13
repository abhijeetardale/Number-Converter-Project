import org.scalatest.prop.{GeneratorDrivenPropertyChecks, PropertyChecks}
import org.scalatest.{Matchers, WordSpec}


class BSTest extends WordSpec with Matchers with PropertyChecks with GeneratorDrivenPropertyChecks {

  val converter = new BS

  "getTestCases" should{

    "return 17 for given input" in {
      converter.getTestCases(1, 2, 5, List(9,8,7,1,5,6)) shouldBe List.empty
    }/*

    "return 3 when input is 1,2" in {
      converter.addList(List(1,2)) shouldBe 3
    }

    "return 3 when input is 1,1,2" in {
      converter.addList(List(1,1,2)) shouldBe 3
    }

    "return 15 when input is 1,2,3,4,4,5" in {
      converter.addList(List(1,2,3,4,4,5)) shouldBe 15
    }*/
  }

}