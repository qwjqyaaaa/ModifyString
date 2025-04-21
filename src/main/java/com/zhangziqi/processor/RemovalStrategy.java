package com.zhangziqi.processor;

import java.util.Optional;

/**
 * It defines the strategy for removing groups of consecutive characters from a string.
 */
public class RemovalStrategy implements StringProcessingStrategy {
    @Override
    public String handleConsecutiveChars(String input, int start, int end) {
        // Use Optional to handle the case where the input string might be null
        return Optional.ofNullable(input)
                .map(s -> s.substring(0, start) + s.substring(end))
                .orElse("");
    }

}