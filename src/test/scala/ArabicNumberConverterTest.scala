import org.scalatest.{Matchers, WordSpec}


class ArabicNumberConverterTest extends WordSpec with Matchers {

  val converter = new NumberConverter

  "arabicNumberConverter" should {

    "return 1 when input is I" in {
      converter.arabicNumberConverter("I") shouldBe 1
    }

    "return 5 when input is V" in {
      converter.arabicNumberConverter("V") shouldBe 5
    }
    "return 10 when input is X" in {
      converter.arabicNumberConverter("X") shouldBe 10
    }

    "return 50 when input is L" in {
      converter.arabicNumberConverter("L") shouldBe 50
    }

    "return 100 when input is C" in {
      converter.arabicNumberConverter("C") shouldBe 100
    }

    "return 500 when input is D" in {
      converter.arabicNumberConverter("D") shouldBe 500
    }
    "return 1000 when input is M" in {
      converter.arabicNumberConverter("M") shouldBe 1000
    }

    "return 4 when input is IV" in {
      converter.arabicNumberConverter("IV") shouldBe 4
    }

    "return 9 for 1 less than 10" in {
      converter.arabicNumberConverter("IX") shouldBe 9
    }

    "return 40 for 10 less than 50" in {
      converter.arabicNumberConverter("XL") shouldBe 40
    }

    "return 90 for 10 less than 100" in {
      converter.arabicNumberConverter("XC") shouldBe 90
    }

    "return 400 for 100 less than 500" in {
      converter.arabicNumberConverter("CD") shouldBe 400
    }

    "return 900 for 100 less than 500" in {
      converter.arabicNumberConverter("CM") shouldBe 900
    }

    "return 3 when input is III" in {
      converter.arabicNumberConverter("III") shouldBe 3
    }

    "return 30 when input is XX" in {
      converter.arabicNumberConverter("XXX") shouldBe 30
    }

    "return 300 when input is CCC" in {
      converter.arabicNumberConverter("CCC") shouldBe 300
    }

    "return 3000 when input is MMM" in {
      converter.arabicNumberConverter("MMM") shouldBe 3000
    }

    "return 555 when input is DLV" in {
      converter.arabicNumberConverter("DLV") shouldBe 555
    }

    "return 14 when input is XIV" in {
      converter.arabicNumberConverter("XIV") shouldBe 14
    }

    "return 19  when input is XIV" in {
      converter.arabicNumberConverter("XIX") shouldBe 19
    }

    "return 140 when input is CXL" in {
      converter.arabicNumberConverter("CXL") shouldBe 140
    }

    "return 190 when input is XIV" in {
      converter.arabicNumberConverter("CXC") shouldBe 190
    }


    "return 1400 when input is MCD" in {
      converter.arabicNumberConverter("MCD") shouldBe 1400
    }

    "return 1900 when input is MCM" in {
      converter.arabicNumberConverter("MCM") shouldBe 1900
    }

    "return 78 when input is LXXVIII" in {
      converter.arabicNumberConverter("LXXVIII") shouldBe 78
    }

    "return 1066 when input is MLXVI" in {
      converter.arabicNumberConverter("MLXVI") shouldBe 1066
    }

    "return  1989 when input is 1989" in {
      converter.arabicNumberConverter("MCMLXXXIX") shouldBe 1989
    }


    "return 388 when input is CCCLXXXVIII" in {
      converter.arabicNumberConverter("CCCLXXXVIII") shouldBe 388
    }
  }

}
