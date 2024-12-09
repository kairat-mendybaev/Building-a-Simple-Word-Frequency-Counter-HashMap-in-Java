import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounterTest {
    private Map<String, Integer> wordCounts;

    @Before
    public void setUp() {
        wordCounts = new HashMap<>();
    }

    @Test
    public void testSingleWord() {
        WordFrequencyCounter.processInput("Hello", wordCounts);
        assertEquals((Integer) 1, wordCounts.get("hello"));
    }

    @Test
    public void testMultipleOccurrencesSingleWord() {
        WordFrequencyCounter.processInput("test test test", wordCounts);
        assertEquals((Integer) 3, wordCounts.get("test"));
    }

    @Test
    public void testMultipleDifferentWords() {
        WordFrequencyCounter.processInput("hello world", wordCounts);
        assertEquals((Integer) 1, wordCounts.get("hello"));
        assertEquals((Integer) 1, wordCounts.get("world"));
    }

    @Test
    public void testPunctuationRemoval() {
        WordFrequencyCounter.processInput("hello, world!", wordCounts);
        assertEquals((Integer) 1, wordCounts.get("hello"));
        assertEquals((Integer) 1, wordCounts.get("world"));
    }

    @Test
    public void testNormalizationCaseSensitivity() {
        WordFrequencyCounter.processInput("Hello HELLO HeLLo", wordCounts);
        assertEquals((Integer) 3, wordCounts.get("hello"));
    }

    @Test
    public void testEmptyAndNonAlphaNumeric() {
        WordFrequencyCounter.processInput("1234 1234 !! ??", wordCounts);
        assertEquals((Integer) 2, wordCounts.get("1234"));
        assertFalse(wordCounts.containsKey("!!"));
        assertFalse(wordCounts.containsKey("??"));
    }
}
