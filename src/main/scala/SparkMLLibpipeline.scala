import org.apache.spark.ml.feature.{HashingTF, IDF, StopWordsRemover, Tokenizer}
import org.apache.spark.sql.{SaveMode, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}
object SparkMLLibpipeline {
  def main(args: Array[String]) {
    System.setProperty("hadoop.home.dir", "C:\\winutils")
    val sparkConf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")

    val sc = new SparkContext(sparkConf)

    val spark = SparkSession
      .builder
      .appName("TfIdfExample")
      .master("local[*]")
      .getOrCreate()
//    sparkConf.set("spark.hadoop.validateOutputSpecs", "false")
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    import spark.implicits._
    val outputpath="output/TFIDFOut"
    val input = spark.read.text("output/TXTOut.txt").as[String]
    val sentenceData= input.toDF("sentence")
   /* val sentenceData = spark.createDataFrame(Seq(
      (0, input)
    )).toDF("label")
*/
    val tokenizer = new Tokenizer().setInputCol("sentence").setOutputCol("words")
    val wordsData = tokenizer.transform(sentenceData)
    val remover = new StopWordsRemover()
      .setInputCol("words")
      .setOutputCol("filteredWords")
    val processedWordData= remover.transform(wordsData)
    val hashingTF = new HashingTF()
      .setInputCol("filteredWords").setOutputCol("rawFeatures").setNumFeatures(20)
    val featurizedData = hashingTF.transform(processedWordData)
    val idf = new IDF().setInputCol("rawFeatures").setOutputCol("features")
    val idfModel = idf.fit(featurizedData)
    val rescaledData = idfModel.transform(featurizedData)
    //rescaledData.select("filteredWords","features", "sentence").take(10).foreach(println)
    //rescaledData.orderBy(desc("words")).take(10).foreach(println)
    rescaledData.printSchema()
    val r2=rescaledData.select("words","features")
    //rescaledData.sort($"features".desc).rdd.saveAsTextFile("topTFIDF")
    //val rescaledData2=rescaledData.rdd
    //rescaledData2.sortBy(we=>we,false)
    // val topWords = TopTFIDF.getTopTFIDFWords(sc, rescaledData.select("words").rdd)
    //rescaledData.createOrReplaceTempView("output1")

    val r3= rescaledData.toDF()
    //r3.write.parquet("output1.parquet")

    val parfile=sqlContext.read.parquet("output1.parquet")
    parfile.createOrReplaceTempView("output1")

    //val parquetfile=output1.registerTemptable("")
    //r3.write.mode(SaveMode.Overwrite).saveAsTable("output1")
    //r3.createOrReplaceTempView("output1")
    //SaveMode(org.apache.spark.sql.SaveMode.valueOf("Overwrite"))
    //r3.write.mode(SaveMode.Overwrite).save("output/TFIDFout")

    //val hadoopConf = new org.apache.hadoop.conf.Configuration()
    //val hdfs = org.apache.hadoop.fs.FileSystem.get(new java.net.URI("hdfs://localhost:9000"), hadoopConf)
    //try { hdfs.delete(new org.apache.hadoop.fs.Path("output/TFIDFOut"), true) } catch { case _ : Throwable => { } }
    val temp1=sqlContext.sql("select words, features  from output1")

    //rescaledData.rdd.saveAsTextFile("output/TFIDFOut");
    temp1.rdd.saveAsTextFile("queryout")
    temp1.show(10)
    spark.stop()
  }
}
