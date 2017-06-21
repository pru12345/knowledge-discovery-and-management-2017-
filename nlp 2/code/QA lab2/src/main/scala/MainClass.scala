import org.apache.spark.{SparkConf, SparkContext}
import java.util.List
import java.util.Map
import java.util.Properties
import java._
import java.util.Arrays
import java.util.Scanner
import java.io.File
import java.io.FileReader
import java.io.File._
import java.io.FileInputStream
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import org.apache.commons.io.FileUtils
import java.util.ArrayList
import scala.io.Source
import java.lang.String
import  java.util.HashMap



/**
 * Created by Mayanka on 23-Jul-15.
 */
object MainClass {
  val nextLine=null;

  def main(args: Array[String]) {

    val sparkConf = new SparkConf().setAppName("LEMMATIZE").setMaster("local[1]")
    val sc = new SparkContext(sparkConf)
    val C: StanfordLemmatizer = new StanfordLemmatizer
    val String = sc.textFile("data/input.txt")
    val b = String.toLocalIterator.mkString.split(" ").map(f=>(f,C.NER(f).toString))
      val per1= b.groupBy(_._2)
    //val per2= b.groupBy(_= "[organization]")

   //val String1 = String.toLocalIterator.mkString.(f=>f.split(" ")).map(f=>(f,C.NER(f)))

    //for (line <- per1) print(line)

    //per1.foreach(println)


    //val string2=b.map(f=>(f,C.NER(f.toString)))

    //val contents = scala.io.Source.fromFile("data/input.txt","windows-1252")


    val who1: util.List[String] = new util.ArrayList[String]
    val where1: util.List[String] = new util.ArrayList[String]
    val org1: util.List[String] = new util.ArrayList[String]
    val time1: util.List[String] = new util.ArrayList[String]
    val misc1: util.List[String] = new util.ArrayList[String]




    //for (line <- b) print(line)
    //val contents = scala.io.Source.fromFile("data/input.txt","windows-1252").mkString
    //contents.collect()
    // val f = Source.fromFile("data/input.txt","windows-1252").getLines.mkString
    //for (line <- f) print(line)
    //val StanfordLemmatizer: StanfordLemmatizer = new StanfordLemmatizer
    //val a = StanfordLemmatizer.NER(b)
    //System.out.print(a)





  }}
    //for ( x <- b )
      //{
        //println(x)
      //}


  //}
//}
