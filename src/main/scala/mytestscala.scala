import java.io.File

import scala.collection.mutable.ArrayBuffer

/**
  * Created by mom on 6/30/2016.

object mytestscala {

  def main(args: Array[String]): Unit = {

  getListOfSubDirectoriesJavaStyle("output")

  }


    def getListOfSubDirectoriesJavaStyle(directoryName: String): List[String] = {
    val directory = new File(directoryName)
    val files = directory.listFiles  // this is File[]
    val dirNames = ArrayBuffer[String]()
    for (file <- files) {
      if (file.isDirectory()) {
        dirNames += file.getName()
      }
    }
    //println(dirNames.toString)

  }
}
  */