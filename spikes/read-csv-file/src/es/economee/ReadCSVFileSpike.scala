package es.economee

import scala.io.Source

object ReadCSVFileSpike {

  def main(args:Array[String]):Unit = {
    val filePath = "test/bankia-example.csv"
    println("Reading CVS file: " + filePath)
    
    val rawLines = Source.fromFile(filePath).getLines
    val infoLines = rawLines.drop(5) // skip first 4 lines
    val movementLines = infoLines.filter(_.length > 0)
    
    for(line <- movementLines) {
      val translatedLine = line.replace("\",\"", "\";\"")
      val fields = List.fromArray(translatedLine.split(";"))
      println("line contains " + fields.length + " fields {" + fields + "}")
      
      println("Movement date: " + getDate(fields));
    }
  }
  
  private def getDate(fields:List[String]):String = {
    fields(1).replace("\"", "")
  }
}