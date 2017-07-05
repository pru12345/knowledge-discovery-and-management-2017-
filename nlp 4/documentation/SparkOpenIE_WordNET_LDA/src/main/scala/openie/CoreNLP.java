package openie;

import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;
import edu.stanford.nlp.util.Quadruple;

import java.util.Collection;

/**
 * Created by Mayanka on 27-Jun-16.
 */
public class CoreNLP {
    public static String returnTriplets(String sentence) {

 Sentence sen = new Sentence(sentence);
 String lemma="";
 Collection<Quadruple<String, String, String, Double>> l=sen.openie();//3 parts of sentense and score
        lemma+= l.toString();
        // Document doc = new Document(sentence);
        // for (Sentence sent : doc.sentences()) {  // Will iterate over two sentences
        //for (int i = 0; i < l.toArray().length ; i++) {
            //}
            //System.out.println(lemma);
       // }
        return lemma;
    }

}
