package es.economee

import scala.collection.Seq
import org.scalatest.FunSuite
import scala.collection.immutable.Map
import scala.reflect.Manifest
import scala.runtime.BoxedUnit
import java.lang.reflect.Method
import org.scalatest.matchers.ShouldMatchers

class BankiaCSVParserTest extends FunSuite with ShouldMatchers {

  val parser = new BankiaCSVParser("test/bankia-example.csv")
  
  test("This is my first test") {
    "foo" should be("foo")
  }
  
  test("parser must parse movement concept") {
    val movements = parser.parse
    movements.size should be(27)
  }
}