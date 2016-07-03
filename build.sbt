name := "ReDefine"

version := "1.0"

scalaVersion := "2.11.8"


libraryDependencies ++= Seq(
  "edu.stanford.nlp" % "stanford-corenlp" % "3.6.0",
  "edu.stanford.nlp" % "stanford-corenlp" % "3.6.0" classifier "models",
  "edu.stanford.nlp" % "stanford-parser" % "3.6.0",
  "com.google.protobuf" % "protobuf-java" % "2.6.1",
//  "org.apache.spark"  % "spark-core_2.10" % "1.1.0",
//  "org.apache.spark"  % "spark-mllib_2.10" % "1.1.0",
  "org.apache.spark" % "spark-core_2.11" % "2.0.0-preview",
  "org.apache.spark" % "spark-mllib_2.11" % "2.0.0-preview",
  "org.apache.spark" % "spark-sql_2.11" % "2.0.0-preview",
  "org.apache.pdfbox" % "pdfbox" % "1.8.2",
  "org.apache.pdfbox" % "xmpbox" % "1.8.0",
  "edu.washington.cs.knowitall.openie" % "openie_2.10" % "4.1"


)