import org.scalatest.{Matchers, WordSpec}
import org.scalatest.prop.{GeneratorDrivenPropertyChecks, PropertyChecks}

class StringProcessTest extends WordSpec with Matchers with PropertyChecks with GeneratorDrivenPropertyChecks{

  val test = new StringProcess

  "calling getSumOfInt" should {

    "rerun the correct value for" in {
      test.getSumOfInts("ab1231da") shouldBe 7
    }

    "rerun same number if its containg 1 digit" in {
      test.getSumOfInts("1") shouldBe 1
    }

    "rerun 0 if its empty str" in {
      test.getSumOfInts("") shouldBe 0
    }

  }

  "Calling file" in {
    test.getFile shouldBe List.empty
  }
}
