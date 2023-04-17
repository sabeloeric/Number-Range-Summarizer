package numberrangesummarizer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberRangeSummarizerImplementationTest {
    private final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImplementation();

    @org.junit.jupiter.api.Test
    void testCollectEmptyString() {
        // Test collecting numbers from an empty input string.
        Collection<Integer> numbers = summarizer.collect("");
        assertEquals(Collections.emptyList(), numbers);
    }

    @org.junit.jupiter.api.Test
    void testSummarizeSingleNumberCollection() {
        // Test summarizing a collection with a single number.
        String summary = summarizer.summarizeCollection(Collections.singletonList(1));
        assertEquals("1", summary);
    }

    @org.junit.jupiter.api.Test
    void testCollectMultiNumberString() {
        // Test collecting multiple numbers from an input string.
        Collection<Integer> numbers = summarizer.collect("1,2,3,5,8");
        assertEquals(Arrays.asList(1, 2, 3, 5, 8), numbers);
    }

    @org.junit.jupiter.api.Test
    void testSummarizeDisorderedCollection() {
        // Test summarizing a collection of disordered numbers.
        String summary = summarizer.summarizeCollection(Arrays.asList(10, 1, 2, 11, 12));
        assertEquals("1-2, 10-12", summary);
    }

    @org.junit.jupiter.api.Test
    void testSummarizeConsecutiveNumbersCollection() {
        // Test summarizing a collection of consecutive numbers.
        String summary = summarizer.summarizeCollection(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals("1-5", summary);
    }

    @org.junit.jupiter.api.Test
    void testSummarizeNonConsecutiveNumbersCollection() {
        // Test summarizing a collection of non-consecutive numbers.
        String summary = summarizer.summarizeCollection(Arrays.asList(1, 2, 4, 6, 7));
        assertEquals("1-2, 4, 6-7", summary);
    }

    @Test
    void testSummarizeNegativeNumbersCollection() {
        // Test summarizing a collection of negative numbers.
        String summary = summarizer.summarizeCollection(Arrays.asList(-3, -2, 0, 1, 2));
        assertEquals("-3--2, 0-2", summary);
    }


}