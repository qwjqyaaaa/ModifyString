package com.zhangziqi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.zhangziqi.processor.AbstractStringProcessor;
import com.zhangziqi.processor.ConsecutiveCharProcessor;
import com.zhangziqi.processor.RemovalStrategy;
import com.zhangziqi.processor.ReplacementStrategy;
import com.zhangziqi.processor.StringProcessingStrategy;

class StringReplacementProcessorTest {

    // Create the processor using the template method pattern and the strategy pattern
    private final AbstractStringProcessor processor = new ConsecutiveCharProcessor(new ReplacementStrategy(), 3);

    /**
     * Tests the processor with a null input.
     */
    @Test
    void testNullInput() {
        assertNull(processor.process(null));
    }

    /**
     * Tests the processor with an empty input string.
     */
    @Test
    void testEmptyInput() {
        assertEquals("", processor.process(""));
    }

    /**
     * Tests the processor with an input string that contains a single group of consecutive characters to replace.
     */
    @Test
    void testSingleReplacement() {
        assertEquals("aa", processor.process("abbb"));
    }

    /**
     * Tests the processor with an input string that contains multiple groups of consecutive characters to replace.
     */
    @Test
    void testMultipleReplacements() {
        assertEquals("d", processor.process("abcccbad"));
    }

    /**
     * Tests the processor with an input string that requires multiple processing steps to replace all groups of consecutive characters.
     */
    @Test
    void testMultipleSteps() {
        assertEquals("aad", processor.process("aaabbbad"));
    }

    /**
     * Tests the processor with an input string that contains only 'a' characters.
     */
    @Test
    void testReplacementWithA() {
        assertEquals("", processor.process("aaa"));
    }
}
