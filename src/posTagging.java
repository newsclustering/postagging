import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.StringReader;

import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

class posTagging{

  private static String Tag(String input) {

    /*
     * Choosing the model to tag the documents with. 
     */

    MaxentTagger tagger = new MaxentTagger("models/wsj-0-18-bidirectional-nodistsim.tagger");
    
    List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new StringReader(input));
    
    String retval = "";

    for (List<HasWord> sentence : sentences) 
    {
      ArrayList<TaggedWord> tSentence = tagger.tagSentence(sentence);
      retval = retval + Sentence.listToString(tSentence, false);
    }

    return retval;
  }  
}

/*
 * Compiling instructions. 
 *
  javac -cp stanford-postagger.jar posTagging.java TextIO.java
  java -cp ".:stanford-postagger.jar" posTagging
*/