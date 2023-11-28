import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyExecutorTest {

    @Test
    public void getFirstSentence_ValidInput_ReturnsFirstSentence() {
        StringBuilder text = new StringBuilder("This is a test sentence. And another one!");
        String expected = "This is a test sentence.";
        String result = MyExecutor.getFirstSentence(text);
        assertEquals(expected, result);
    }

    @Test
    public void getFirstSentence_EmptyText_ThrowsRuntimeException() {
        StringBuilder text = new StringBuilder("");
        RuntimeException exception = assertThrows(RuntimeException.class, () -> MyExecutor.getFirstSentence(text));


        String exceptionMessage = "Text is empty!";
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void getFirstSentence_NoEndDelimiter_ThrowsRuntimeException() {
        StringBuilder text = new StringBuilder("This is an incomplete sentence");
        RuntimeException exception = assertThrows(RuntimeException.class, () -> MyExecutor.getFirstSentence(text));


        String exceptionMessage = "End of the sentence not found! " +
                "Put a delimiter (.!?) that marks the end of a sentence";
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void findIndexOfEndOfFirstSentence_ValidInput_ReturnsIndexOfEndDelimiter() {
        StringBuilder text = new StringBuilder("One.");
        int expected = 3;
        int result = MyExecutor.findIndexOfEndOfFirstSentence(text);
        assertEquals(expected, result);
    }

    @Test
    public void findIndexOfEndOfFirstSentence_EmptyText_ReturnsMinusOne() {
        StringBuilder text = new StringBuilder("");
        int result = MyExecutor.findIndexOfEndOfFirstSentence(text);
        assertEquals(-1, result);
    }

    @Test
    public void findIndexOfEndOfFirstSentence_NoEndDelimiter_ReturnsMinusOne() {
        StringBuilder text = new StringBuilder("piu piu nothing here");
        int result = MyExecutor.findIndexOfEndOfFirstSentence(text);
        assertEquals(-1, result);
    }

    @Test
    public void findIndexOfEndOfFirstSentence_NullInput_ReturnsMinusOne() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> MyExecutor.findIndexOfEndOfFirstSentence(null));

        String exceptionMessage = "Argument for @NotNull parameter 'text' of MyExecutor.findIndexOfEndOfFirstSentence must not be null";
        assertEquals(exceptionMessage, exception.getMessage());
    }

    //getText
    @Test
    public void getTextWithoutFirstSentence_ValidInput_ReturnsTextWithoutFirstSentence() {
        StringBuilder text = new StringBuilder("This is a test sentence. And another one!");
        String expected = " And another one!";
        String result = MyExecutor.getTextWithoutFirstSentence(text);
        assertEquals(expected, result);
    }

    @Test
    public void getTextWithoutFirstSentence_EmptyText_ThrowsRuntimeException() {
        StringBuilder text = new StringBuilder("");
        RuntimeException exception = assertThrows(RuntimeException.class, () -> MyExecutor.getTextWithoutFirstSentence(text));

        String exceptionMessage = "Text is empty!";
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void getTextWithoutFirstSentence_NoEndDelimiter_ThrowsRuntimeException() {
        StringBuilder text = new StringBuilder("piu piu no delimiter");
        RuntimeException exception = assertThrows(RuntimeException.class, () -> MyExecutor.getTextWithoutFirstSentence(text));

        String exceptionMessage = "End of the first sentence not found! " +
                "Put a delimiter (.!?) that marks the end of a sentence";
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void getTextWithoutFirstSentence_NullInput_ThrowsRuntimeException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> MyExecutor.getTextWithoutFirstSentence(null));

        String exceptionMessage = "Argument for @NotNull parameter 'text' of MyExecutor.getTextWithoutFirstSentence must not be null";
        assertEquals(exceptionMessage, exception.getMessage());
    }

    //isWordInTheText
    @Test
    public void isWordInTheText_ValidInput_ReturnsTrue() {
        StringBuilder text = new StringBuilder("This is a test sentence.");
        String word = "test";
        boolean result = MyExecutor.isWordInTheText(word, text);
        assertTrue(result);
    }

    @Test
    public void isWordInTheText_ValidInput_ReturnsFalse() {
        StringBuilder text = new StringBuilder("This is a test sentence.");
        String word = "tEst";
        boolean result = MyExecutor.isWordInTheText(word, text);
        assertFalse(result);
    }

    @Test
    public void isWordInTheText_EmptyText_ThrowsRuntimeException() {
        StringBuilder text = new StringBuilder("");
        String word = "test";
        RuntimeException exception = assertThrows(RuntimeException.class, () -> MyExecutor.isWordInTheText(word, text));

        String exceptionMessage = "Text is empty!";
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void isWordInTheText_NullInput_ThrowsRuntimeException() {
        String word = "test";
        RuntimeException exception = assertThrows(RuntimeException.class, () -> MyExecutor.isWordInTheText(word, null));

        String exceptionMessage = "Cannot invoke \"java.lang.StringBuilder.isEmpty()\" because \"text\" is null";
        assertEquals(exceptionMessage, exception.getMessage());
    }


    @Test
    public void isWordInTheText_EmptyWord_ReturnsTrue() {
        StringBuilder text = new StringBuilder("This  is a test sentence.");
        String word = "";
        RuntimeException exception = assertThrows(RuntimeException.class, () -> MyExecutor.isWordInTheText(word, text));

        String exceptionMessage = "Word is empty!";
        assertEquals(exceptionMessage, exception.getMessage());
    }

    //exec
    @Test
    public void exec_ValidInput_ReturnsFirstNonRepeatingWord() {
        StringBuilder text = new StringBuilder("This is a doggy! And one more doggy!");
        StringBuilder result = MyExecutor.exec(text);
        assertEquals("This", result.toString());
    }

    @Test
    public void exec_AllWordsAreSame_ReturnsEmptyString() {
        StringBuilder text = new StringBuilder("Everything is the same? Everything is the same!");
        StringBuilder result = MyExecutor.exec(text);
        assertEquals("", result.toString());
    }

    @Test
    public void exec_EmptyText_ThrowException() {
        StringBuilder text = new StringBuilder("");
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> MyExecutor.exec(text));

        String exceptionMessage = "Text is empty!";
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void exec_SecondSentenceIsEmpty_ReturnsEmptyStringBuilder() {
        StringBuilder text = new StringBuilder(".");
        StringBuilder result = MyExecutor.exec(text);
        assertEquals("", result.toString());
    }
}
