import org.scalatest.prop.{GeneratorDrivenPropertyChecks, PropertyChecks}
import org.scalatest.{Matchers, WordSpec}
import org.scalacheck.{Gen, Shrink}
import org.scalatest.prop.TableDrivenPropertyChecks._



class BritishCurrencyTest extends WordSpec with Matchers with PropertyChecks with GeneratorDrivenPropertyChecks {

  val converter = new BritishCurrency

  val validCombinations =
    Table(
      ("amount", "coins"),  // First tuple defines column names
      (  1,   List("1p")), // Subsequent tuples define the data
      (  2,   List("2p")),
      (  3,   List("2p", "1p")),
      (  4,   List("2p", "2p")),
      (  5,   List("5p")),
      (  6,   List("5p", "1p")),
      (  7,   List("5p", "2p")),
      (  8,   List("5p", "2p", "1p")),
      (  9,   List("5p", "2p", "2p")),
      (  10,  List("10p")),
      (  12,  List("10p", "2p")),
      (  23,  List("20p", "2p", "1p")),
      (  34,  List("20p", "10p", "2p", "2p")),
      (  45,  List("20p", "20p", "5p")),
      (  56,  List("50p", "5p", "1p")),
      (  67,  List("50p", "10p", "5p", "2p")),
      (  78,  List("50p", "20p", "5p", "2p", "1p")),
      (  88,  List("50p", "20p", "10p", "5p", "2p", "1p")),
      (  188, List("£1", "50p", "20p", "10p", "5p", "2p", "1p")),
      (  388, List("£2", "£1", "50p", "20p", "10p", "5p", "2p", "1p")),
      (  588, List("£2", "£2", "£1", "50p", "20p", "10p", "5p", "2p", "1p")),
      (  598, List("£2", "£2", "£1", "50p", "20p", "20p", "5p", "2p", "1p"))
    )

  "Generating valid values" should {
    "return correct combinations of coin "in {
      forAll (validCombinations) { (amount:Int, coins:List[String]) =>
      converter.makeChange(amount) shouldBe coins
    }
  }
  }


  "makeChange" should {

    "return 1p when input is 1" in {
      converter.makeChange(1) shouldBe List("1p")
    }

    "return 2p2p when input is 4" in {
      converter.makeChange(4) shouldBe List("2p","2p")
    }

    "return 5p when input is 5" in {
      converter.makeChange(5) shouldBe List("5p")
    }

    "return 5p2p2p when input is 5" in {
      converter.makeChange(9) shouldBe List("5p","2p","2p")
    }

    "return 10p when input is 10" in {
      converter.makeChange(10) shouldBe List("10p")
    }

    "return 10p5p2p2p1p when input is 19" in {
      converter.makeChange(19) shouldBe List("10p","5p","2p","2p")
    }

    "return 50p20p10p5p2p1p when input is 88" in {
      converter.makeChange(88) shouldBe List("50p","20p","10p","5p","2p","1p")
    }

    "return £120p10p5p2p1p when input is 138" in {
      converter.makeChange(138) shouldBe List("£1","20p","10p","5p","2p","1p")
    }

    "return £2£150p20p20p5p2p1p when input is 398" in {
      converter.makeChange(398) shouldBe List("£2","£1","50p","20p","20p","5p","2p","1p")
    }
  }

  "makePossibleChangeWithAvailableCoins" should{

    "return 50p20p10p5p2p1p when input is 45" in {
      converter.makePossibleChangeWithAvailableCoins(45, List("£1","50p","20p","10p","2p","1p","1p","1p")) shouldBe List("20p","10p","2p","1p","1p","1p")
    }

    "return 50p20p10p5p2p1p when input is 80" in {
      converter.makePossibleChangeWithAvailableCoins(80, List("£1","50p","20p","20p","5p","2p","1p")) shouldBe List("50p","20p","5p","2p","1p")
    }

    "return 50p20p10p5p2p1p when input is 90" in {
      converter.makePossibleChangeWithAvailableCoins(90, List("£1","50p","20p","10p","5p","2p","1p")) shouldBe List("50p","20p","10p","5p","2p","1p")
    }
  }

  "addList" should{

    "return 1 when input is 1" in {
      converter.addList(List(1)) shouldBe 1
    }

    "return 3 when input is 1,2" in {
      converter.addList(List(1,2)) shouldBe 3
    }

    "return 3 when input is 1,1,2" in {
      converter.addList(List(1,1,2)) shouldBe 3
    }

    "return 15 when input is 1,2,3,4,4,5" in {
      converter.addList(List(1,2,3,4,4,5)) shouldBe 15
    }
  }

}