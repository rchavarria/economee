package es.economee

import scala.io.Source
import scala.collection.mutable
import es.economee.data.Movement
import java.text.SimpleDateFormat
import java.util.Date
import java.text.NumberFormat
import java.util.Locale

class BankiaCSVParser(csvPath: String) {
  
  val dateFormat = new SimpleDateFormat("dd/MM/yyyy")
  val numberFormat = NumberFormat.getNumberInstance(new Locale("ES", "es"))

  def parse(): List[Movement] = {
    //println("Reading CVS file: " + csvPath)
    
    val rawLines = Source.fromFile(csvPath).getLines
    val infoLines = rawLines.drop(5) // skip first 4 lines
    val movementLines = infoLines.filter(_.length > 0)
    
    val movements = mutable.ListBuffer[Movement]()
    for(line <- movementLines) {
      val translatedLine = line.replace("\",\"", "\";\"")
      val fields = List.fromArray(translatedLine.split(";"))
      movements += new Movement(getConcept(fields), getDate(fields), getAmount(fields))
    }
    
    movements.toList
  }

  private def getConcept(fields: List[String]) = {
    fields(2).replace("\"", "")
  }
  
  private def getDate(fields: List[String]): Date = {
    val strDate = fields(1).replace("\"", "")
    dateFormat.parse(strDate)
  }
  
  private def getAmount(fields: List[String]): Long = {
    val strAmount = fields(3).replace("\"", "")
    val numberAmount = numberFormat.parse(strAmount)
    
    // conver a number to Long or Double
    val amount = if (numberAmount.isInstanceOf[Long]) {
      numberAmount.asInstanceOf[Long] 
    }  else {
      numberAmount.asInstanceOf[Double]
    }
    
    // convert to miliEuros and cast to Long, to avoid inaccurate calculations of money
    //using Double type
    (amount * 1000).asInstanceOf[Long]
  }
}