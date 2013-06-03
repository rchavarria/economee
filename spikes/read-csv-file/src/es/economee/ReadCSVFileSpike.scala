package es.economee

import scala.io.Source

object ReadCSVFileSpike {

  def main(args:Array[String]):Unit = {
    val filePath = "test/example.csv"
    println("Reading CVS file: " + filePath)
    
    val lines = Source.fromFile(filePath).getLines
    for(line <- lines) {
      val fields = List.fromArray(line.split(";"))
      println(fields)
    }
  }
}