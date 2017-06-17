/**
 * Created by Mayanka on 23-Jul-15.
 */
object MainClass {

  def main(args: Array[String]) {
    val sentimentAnalyzer: SentimentAnalyzer = new SentimentAnalyzer

    val tweetWithSentiment: TweetWithSentiment = sentimentAnalyzer.findSentiment("")
    System.out.println(tweetWithSentiment)
  }
}
