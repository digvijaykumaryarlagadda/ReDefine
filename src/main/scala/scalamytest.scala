import java.io.{FileNotFoundException, _}
import java.nio.file.{Files, Paths, StandardOpenOption}

import scala.io.Source
import org.apache.commons.io.FilenameUtils
import org.apache.spark
import org.apache.spark.ml.feature.{HashingTF, IDF, StopWordsRemover, Tokenizer}
import org.apache.spark.sql.{DataFrame, Row, SaveMode, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ArrayBuffer
import scala.io.BufferedSource



object scalamytest {
  def main(args: Array[String]) {


    /* List all files in a directory
    for (file <- new File("output/researchArticlesTXT").listFiles) {
      print(file+"\n")
    }
    */



  }
}
