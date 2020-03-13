import org.scalatest.{Matchers, WordSpec}
import org.scalatest.prop.{GeneratorDrivenPropertyChecks, PropertyChecks}

class SeggezzaTestSpec extends WordSpec with Matchers with PropertyChecks with GeneratorDrivenPropertyChecks{

val test = new SeggezzaTest


  "birthday" should {
    "return 2" in {
      //  1 2 1 3 2
      //  3 2
      test.birthday(Array[Int](1,2,1,3,2), 3, 2 ) shouldBe 2
    }

    "return 1" in {
//      4
//      4 1
      test.birthday(Array[Int](4), 4, 1 ) shouldBe 1
    }

    "return 0" in {
//      1 1 1 1 1 1
//      3 2
      test.birthday(Array[Int](1,1,1,1,1,1), 3, 2 ) shouldBe 0
    }

    "return 4" in {
//      2 3 3 2 3 3
//      7 3
      test.birthday(Array[Int](2,3,3,2,3,3), 8, 3 ) shouldBe 4
    }
  }

  "separateNumbers" should {
    "YES 1" in {
//      1234
//      YES 1
      test.separateNumbers("1234") shouldBe "YES 1"
    }
    "YES 9" in {
//      91011
//      YES 9
      test.separateNumbers("91011") shouldBe "YES 9"
    }
    "YES 99" in {
//      99100
//      YES 99
      test.separateNumbers("99100") shouldBe "YES 99"
    }
    "NO 101103" in {
      //      101103
      test.separateNumbers("101103") shouldBe "NO"
    }
    "NO 010203" in {
      //      010203
      test.separateNumbers("010203") shouldBe "NO"
    }
    "NO 13" in {
      //      13
      test.separateNumbers("13") shouldBe "NO"
    }
    "NO 1" in {
      //      1
      test.separateNumbers("1") shouldBe "NO"
    }
    "YES 999" in {
      //      99910001001
      //      YES 999
      test.separateNumbers("99910001001") shouldBe "YES 999"
    }
    "YES 98" in {
      //      9899100
      //      YES 98
      test.separateNumbers("9899100") shouldBe "YES 98"
    }
    "YES 7891011" in {
      //      7891011
      //      YES 7
      test.separateNumbers("7891011") shouldBe "YES 7"
    }
    "NO 999100010001" in {
//      999100010001
      test.separateNumbers("999100010001") shouldBe "NO"
    }
  }


  "alternate" should {
    "abaacdabd 4" in {
      test.alternate("abaacdabd") shouldBe 4
    }

    "beabeefeab 5" in {
      test.alternate("beabeefeab") shouldBe 5
    }

    "asvkugfiugsalddlasguifgukvsa 0" in {
      test.alternate("asvkugfiugsalddlasguifgukvsa") shouldBe 0
    }

  }

  "missingNumbers" should {
    "l1" in {
      test.missingNumbers(Array(1,2,3,4,5), Array(1,2,3,3,4,5,5)) shouldBe Array(3,5)
    }

    "l2" in {
      test.missingNumbers(Array(203,204,205,206,207,208,203,204,205,206),
        Array(203,204,204,205,206,207,205,208,203,206,205,206,204)) shouldBe Array(204,205,206)
    }
  }
}
