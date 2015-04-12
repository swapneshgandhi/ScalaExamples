package scala.practice
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

class ReaderMY(val fileName: String) {

  val in = new BufferedReader(new FileReader(fileName))
  @throws(classOf[IOException])
  def read() = in.read()

}