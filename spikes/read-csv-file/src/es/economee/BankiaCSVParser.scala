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
    
    var movements: List[Movement] = List()
    for(line <- movementLines) {
      val translatedLine = line.replace("\",\"", "\";\"")
      val fields = List.fromArray(translatedLine.split(";"))
      println("line contains " + fields.length + " fields {" + fields + "}")
      
      println("Movement date: " + getDate(fields));
      
      var m = new Movement("bla bla")
      movements ::= m
    }
    
    return movements
  }
  
  private def getDate(fields: List[String]): String = {
    fields(1).replace("\"", "")
  }
}