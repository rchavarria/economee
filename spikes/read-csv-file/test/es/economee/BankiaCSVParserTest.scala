package es.economee

import scala.collection.Seq
import org.scalatest.FunSuite
import scala.collection.immutable.Map
import scala.reflect.Manifest
import scala.runtime.BoxedUnit
import java.lang.reflect.Method
import org.scalatest.matchers.ShouldMatchers
import java.util.Date
import java.util.Locale
import java.text.NumberFormat
import java.text.SimpleDateFormat

class BankiaCSVParserTest extends FunSuite with ShouldMatchers {

  val parser = new BankiaCSVParser("test/bankia-example.csv")
  
  test("parser must parse all movements of the file") {
    val movements = parser.parse
    movements.size should be(27)
  }
  
  test("first parsed movement concept should be: 'EXPENDURIA DE TABA'") {
    val movements = parser.parse
    movements(0).concept should be("EXPENDURIA DE TABA")
  }
  
  test("first parsed movement date should be: '30/05/2013'") {
    val expectedDate = new SimpleDateFormat("dd/MM/yyyy").parse("30/05/2013")
    val movements = parser.parse
    movements(0).date should be(expectedDate)
  }
  
  test("first parsed movement amount should be: '-110,60' but expressed in miliEuros") {
    val expectedAmount = -110600
    
    val movements = parser.parse
    movements(0).amount should be(expectedAmount)
  }
  
}