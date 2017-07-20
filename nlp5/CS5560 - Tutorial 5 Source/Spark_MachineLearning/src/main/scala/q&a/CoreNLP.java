package wordnet;

import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;
import edu.stanford.nlp.util.Quadruple;

import java.util.Collection;
import java.util.List;

/**
 * Created by Mayanka on 27-Jun-16.
 */
public class CoreNLP {
    public static String returnLemma(String sentence) {

        Document doc = new Document(sentence);
        String lemma="";
        for (Sentence sent : doc.sentences()) {  // Will iterate over two sentences

            List<String> l=sent.lemmas();
            for (int i = 0; i < l.size() ; i++) {
                lemma+= l.get(i) +" ";
            }
         // System.out.println(lemma);
        }

        return lemma;
    }

    public static String returnpos ( String sentence) {

        Document doc = new Document(sentence);
        String lemma="";
        for (Sentence sent : doc.sentences()) {  // Will iterate over two sentences

            List<String> l=sent.nerTags();
            for (int i = 0; i < l.size() ; i++) {
                lemma+= l.get(i) + " ";
            }
             System.out.println("lemma-------------------- "+lemma);
        }

        return lemma;
    }













    public static String returnTriplets(String sentence) {

        //Sentence sen = new Sentence(sentence);
        String lemma="";
        Document doc = new Document(sentence);
        for (Sentence sent : doc.sentences()) {  // Will iterate over two sentences
            //for (int i = 0; i < l.toArray().length ; i++) {
            Collection<Quadruple<String, String, String, Double>> l = sent.openie();//3 parts of sentense and score
            lemma += l.toString();
        }
        return lemma;

        //}
        //System.out.println(lemma);
        // }

    }


}
