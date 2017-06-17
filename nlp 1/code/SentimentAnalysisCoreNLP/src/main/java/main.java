/**
 * Created by pru on 6/16/2017.
 */
public class main {
    public static void main (String [] args)
    {
        SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
        TweetWithSentiment tweetWithSentiment = sentimentAnalyzer.findSentiment("I like Big Data. Very excited about it");

        System.out.println(tweetWithSentiment);


    }
}
