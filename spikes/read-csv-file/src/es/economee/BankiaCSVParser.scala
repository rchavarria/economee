package es.economee

import scala.io.Source
import scala.collection.mutable
import es.economee.data.Movement

class BankiaCSVParser(csvPath: String) {

  def parse(): List[Movement] = {
    println("Reading CVS file: " + csvPath)
    
    val rawLines = Source.fromFile(csvPath).getLines
    val infoLines = rawLines.drop(5) // skip first 4 lines
    val movementLines = infoLines.filter(_.length > 0)
    
    val movements = mutable.ListBuffer[Movement]()
    for(line <- movementLines) {
      val translatedLine = line.replace("\",\"", "\";\"")
      val fields = List.fromArray(translatedLine.split(";"))
      println("line contains " + fields.length + " fields {" + fields + "}")
      
      println("Movement date: " + getDate(fields));
      
      movements += new Movement(getConcept(fields), getDate(fields), getAmount(fields))
    }
    
    movements.toList
  }

  private def getConcept(fields: List[String]) = {
    fields(2).replace("\"", "")
  }
  
  private def getDate(fields: List[String]): String = {
    fields(1).replace("\"", "")
  }
  
  private def getAmount(fields: List[String]) = {
    fields(3).replace("\"", "")
  }
}