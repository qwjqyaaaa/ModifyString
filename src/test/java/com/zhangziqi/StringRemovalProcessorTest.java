package com.zhangziqi;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.zhangziqi.processor.AbstractStringProcessor;
import com.zhangziqi.processor.ConsecutiveCharProcessor;
import com.zhangziqi.processor.RemovalStrategy;
import com.zhangziqi.processor.StringProcessingStrategy;

class StringRemovalProcessorTest {

    // Create the processor using the template method pattern and the strategy pattern
    private final AbstractStringProcessor processor = new ConsecutiveCharProcessor(new RemovalStrategy(), 3);

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
     * Tests the processor with an input string that contains a single group of consecutive characters to remove.
     */
    @Test
    void testSingleRemoval() {
        assertEquals("a", processor.process("abbb"));
    }

    /**
     * Tests the processor with an input string that contains multiple groups of consecutive characters to remove.
     */
    @Test
    void testMultipleRemovals() {
        assertEquals("d", processor.process("aabcccbbad"));
    }

    /**
     * Tests the processor with an input string that requires multiple processing steps to remove all groups of consecutive characters.
     */
    @Test
    void testMultipleSteps() {
        assertEquals("ad", processor.process("aaabbbad"));
    }
}