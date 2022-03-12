/*
I'm sure, you know Google's "Did you mean ...?", when you entered a search term and mistyped a word. In this kata we want to implement something similar.

You'll get an entered term (lowercase string) and an array of known words (also lowercase strings). Your task is to find out, which word from the dictionary is most similar to the entered one. The similarity is described by the minimum number of letters you have to add, remove or replace in order to get from the entered word to one of the dictionary. The lower the number of required changes, the higher the similarity between each two words.

Same words are obviously the most similar ones. A word that needs one letter to be changed is more similar to another word that needs 2 (or more) letters to be changed. E.g. the mistyped term berr is more similar to beer (1 letter to be replaced) than to barrel (3 letters to be changed in total).

Extend the dictionary in a way, that it is able to return you the most similar word from the list of known words.
 */
import java.util.HashMap;
import java.util.Map;


public class Dictionary {

    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    public String findMostSimilar(String to) {

        Map<String, Integer> frequency = new HashMap<>(); //частота
        for (String word : words) for (int i = 0; i < to.length(); i++) {
            int times = 0;
            for (int j = i + 1; j <= to.length(); j++) if (word.contains(to.substring(i, j))) times += 2;
            if (!frequency.containsKey(word) || frequency.get(word) < times) frequency.put(word, times);
        }
        String correct = "";
        int maxAbs = Integer.MIN_VALUE, currAbs = 0;
        for (String s : frequency.keySet()) {
            currAbs = frequency.get(s) - s.length() - Math.abs(s.length() - to.length());
            if (currAbs > maxAbs) {
                correct = s;
                maxAbs = currAbs;
            }
        }
        return correct;
    }
}