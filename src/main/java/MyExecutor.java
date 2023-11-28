import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
public class MyExecutor {
    public static StringBuilder exec(@NotNull StringBuilder text) {
        String[] wordsOfFirstSentence = getFirstSentence(text)
                .split("[ ,!;:?.]+");

        for(String word: wordsOfFirstSentence) {
            if(!isWordInTheText(word,
                    new StringBuilder(text.substring(findIndexOfEndOfFirstSentence(text))))) {
                //System.out.println(word);
                return new StringBuilder(word);
            }
        }
        return new StringBuilder("");
    };

    public static boolean isWordInTheText(@NotNull String word, StringBuilder text) {
        if(text.isEmpty()) {
            throw new RuntimeException("Text is empty!");
        }
        if(word.isEmpty()) {
            throw new RuntimeException("Word is empty!");
        }
        return text.indexOf(word) >= 0;
    };

    public static String getFirstSentence(@NotNull StringBuilder text) {
        if(text.isEmpty()) {
            throw new RuntimeException("Text is empty!");
        }
        int indexEnd = findIndexOfEndOfFirstSentence(text);
        if(indexEnd < 0) {
            throw new RuntimeException("End of the sentence not found! " +
                    "Put a delimiter (.!?) that marks the end of a sentence");
        }
        return text.substring(0, indexEnd+1);
    };

    public static String getTextWithoutFirstSentence(@NotNull StringBuilder text) {
        if(text.isEmpty()) {
            throw new RuntimeException("Text is empty!");
        }
        int indexEnd = findIndexOfEndOfFirstSentence(text);
        if(indexEnd < 0) {
            throw new RuntimeException("End of the first sentence not found! " +
                    "Put a delimiter (.!?) that marks the end of a sentence");
        }
        return text.substring(indexEnd+1);
    };

    public static int findIndexOfEndOfFirstSentence(@NotNull StringBuilder text) {
        if(text.isEmpty()) return -1;
        String[] delimeters = {".", "!", "?"};
        return Arrays
                .stream(delimeters)
                .map(text::indexOf)
                .filter(i -> i > -1)
                .min(Integer::compareTo).orElse(-1);
    };
 }
