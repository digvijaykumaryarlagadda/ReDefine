import java.io.File

/**
  * Created by mom on 6/30/2016.
  */
object scalamytest {
  def main(args: Array[String]) {

    for (file <- new File("output/researchArticlesTXT").listFiles) {
      print(file+"\n")
    }
  }
}
