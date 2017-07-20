package wordnet

import lda.CoreNLP
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import rita.RiWordNet
import spire.std.seq

/**
  * Created by Mayanka on 26-06-2017.
  */

object WordNetSpark {
  def main(args: Array[String]): Unit = {
  //  System.setProperty("hadoop.home.dir", "D:\\Mayanka Lenevo F Drive\\winutils")
    val conf = new SparkConf().setAppName("WordNetSpark").setMaster("local[*]").set("spark.driver.memory", "4g").set("spark.executor.memory", "4g")
    val sc = new SparkContext(conf)

    val stopWords = sc.textFile("data/stopwords.txt").collect()
    val stopWordsBroadCast = sc.broadcast(stopWords)

    System.out.println("Enter the question")
    val que = scala.io.StdIn.readLine()
    val lemmatised1 = CoreNLP.returnLemma(que)
    val splitString = lemmatised1.split(" ")

    val stopword1 = splitString.map(_.replaceAll("[^a-zA-Z]", " "))
      //Filter out the Stop Words
      .filter(ff => {
      if (stopWordsBroadCast.value.contains(ff.toLowerCase))
        false
      else
        true
    })
    val pos = stopword1.map(f => (f, CoreNLP.returnpos(f)))
    pos.foreach(println)

    val filtered = pos.filter(_._2.==("PERSON ")).map(f => f._1)
    println("-------------------------")
    filtered.foreach(println)
    println("-------------------------")


    println(stopword1.length)


    val data = sc.textFile("data/sentenceSample")
    val data1 = data.map(f => {
      val split = f.split(" ")
      val lemmatised = CoreNLP.returnLemma(f.toLowerCase).split(" ")

      val stopword = lemmatised
        //Filter out the Stop Words
        .filter(ff => {
        if (stopWordsBroadCast.value.contains(ff.toLowerCase))
          false
        else
          true
      })
      (f.toLowerCase,lemmatised.mkString(" "), stopword.mkString(""))
    })
    //println(filtered.take(1).mkString(" ")+"----------------------------------")

      val data2= data1.filter(ff=>if (ff._3.toLowerCase.contains(filtered.take(1).mkString(" ").toLowerCase()))
         true
       else
        false )

    print("---------------------data---------------------")

    data1.foreach(println)
    print("---------------------filtered---------------------")
    data2.foreach(println)

    print("---------------------triplets---------------------")

    val openie_term =data2.map(f=>CoreNLP.returnTriplets(f._1))

openie_term.take(2).foreach(println)



   // data1.take(1).foreach(println)
print("------------------------------------------")



  }
}