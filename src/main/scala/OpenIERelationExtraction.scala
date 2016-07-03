/**
  * Created by mom on 7/2/2016.
  */
import edu.knowitall.openie.OpenIE
import edu.knowitall.openie.OpenIECli.{ColumnFormat, SimpleFormat}
import java.io.{PrintWriter, StringWriter}

import edu.knowitall.openie
import edu.knowitall.tool.parse.ClearParser
import edu.knowitall.tool.postag.ClearPostagger
import edu.knowitall.tool.srl.ClearSrl
import edu.knowitall.tool.tokenize.ClearTokenizer
import edu.stanford.nlp.naturalli.OpenIE

object OpenIERelationExtraction {
  def main(args: Array[String]) {

    val sentence = "U.S. President Obama gave a speech"
    val e = new openie.OpenIE()
    val instances = e.extract(sentence)
    var s = new StringBuilder()
    for (instance <- instances) {
      s.append("Instance: " + instance.toString() + "\n")
    }
    println(s.toString())



  }
}