import org.scalatest.{Matchers, WordSpec}


class RomanNumberConverterTest extends WordSpec with Matchers {

  val converter = new NumberConverter

  "romanNumberConverter" should {

    "return I when input is 1" in {
      converter.romanNumberConverter(1) shouldBe "I"
    }

    "return IV for 1 less than V" in {
      converter.romanNumberConverter(4) shouldBe "IV"
    }

    "return V when input is 5" in {
      converter.romanNumberConverter(5) shouldBe "V"
    }

    "return IX for 1 less than X" in {
      converter.romanNumberConverter(9) shouldBe "IX"
    }

    "return X when input is 10" in {
      converter.romanNumberConverter(10) shouldBe "X"
    }

    "return XL for 10 less than L" in {
      converter.romanNumberConverter(40) shouldBe "XL"
    }

    "return L when input is 50" in {
      converter.romanNumberConverter(50) shouldBe "L"
    }

    "return XC for 10 less than C" in {
      converter.romanNumberConverter(90) shouldBe "XC"
    }

    "return C when input is 100" in {
      converter.romanNumberConverter(100) shouldBe "C"
    }

    "return CD for 100 less than D" in {
      converter.romanNumberConverter(400) shouldBe "CD"
    }

    "return D when input is 500" in {
      converter.romanNumberConverter(500) shouldBe "D"
    }

    "return CM for 100 less than M" in {
      converter.romanNumberConverter(900) shouldBe "CM"
    }

    "return M when input is 1000" in {
      converter.romanNumberConverter(1000) shouldBe "M"
    }

    "return III when input is 3" in {
      converter.romanNumberConverter(3) shouldBe "III"
    }

    "return XXX when input is 30" in {
      converter.romanNumberConverter(30) shouldBe "XXX"
    }

    "return CCC when input is 300" in {
      converter.romanNumberConverter(300) shouldBe "CCC"
    }

    "return MMM when input is 3000" in {
      converter.romanNumberConverter(3000) shouldBe "MMM"
    }

    "not return IIII when input is 4" in {
      converter.romanNumberConverter(4) should not be ("IIII")
    }

    "not return XXXX when input is 40" in {
      converter.romanNumberConverter(40) should not be ("XXXX")
    }

    "not return CCCC when input is 400" in {
      converter.romanNumberConverter(400) should not be ("CCCC")
    }

    "return V one time only for any number having 5 in once place" in {
      converter.romanNumberConverter(5) shouldBe "V"
    }

    "return L one time only for any number having 5 in tens place" in {
      converter.romanNumberConverter(50) shouldBe "L"
    }

    "return D one time only for any number having 5 in hundreds place" in {
      converter.romanNumberConverter(500) shouldBe "D"
    }

    "return V, L and D one time only for any number having 5 in once, tens ands hundreds places" in {
      converter.romanNumberConverter(555) shouldBe "DLV"
    }

    "return XIV for 1 less than VX" in {
      converter.romanNumberConverter(14) shouldBe "XIV"
    }

    "return XIX for 1 less than XX" in {
      converter.romanNumberConverter(19) shouldBe "XIX"
    }

    "return CXL for 10 less than CD" in {
      converter.romanNumberConverter(140) shouldBe "CXL"
    }

    "return CXC for 10 less than CD" in {
      converter.romanNumberConverter(190) shouldBe "CXC"
    }


    "return MCD for 100 less than D" in {
      converter.romanNumberConverter(1400) shouldBe "MCD"
    }

    "return MCM for 100 less than M" in {
      converter.romanNumberConverter(1900) shouldBe "MCM"
    }

    "return LXXVIII when input is 78" in {
      converter.romanNumberConverter(78) shouldBe "LXXVIII"
    }

    "return MLXVI when input is 1066" in {
      converter.romanNumberConverter(1066) shouldBe "MLXVI"
    }

    "return MCMLXXXIX when input is 1989" in {
      converter.romanNumberConverter(1989) shouldBe "MCMLXXXIX"
    }


    "return CCCLXXXVIII when input is 388" in {
      converter.romanNumberConverter(388) shouldBe "CCCLXXXVIII"
    }
  }

}