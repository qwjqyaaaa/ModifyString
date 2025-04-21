package com.zhangziqi.processor;

import java.util.Optional;

/**
 * It defines the strategy for replacing groups of consecutive characters from a string.
 */
public class ReplacementStrategy implements StringProcessingStrategy {
    @Override
    public String handleConsecutiveChars(String input, int start, int end) {
        // Use Optional to handle the case where the input string might be null
        return Optional.ofNullable(input)
                .map(s -> {
                    // Check if the end index is out of bounds or the start index is not less than the end index
                    if (end > s.length() || start >= end) {
                        return s;
                    }
                    // Get the character at the start index
                    char matchedChar = s.charAt(start);
                    // If the character is 'a', replace it with a space; otherwise, use the previous letter in the alphabet
                    char replacement = matchedChar == 'a' ? ' ' : (char) (matchedChar - 1);
                    // Convert the replacement character to a string
                    // If the replacement character is a space, use an empty string; otherwise, use the character as a string
                    String replacementStr = replacement == ' ' ? "" : String.valueOf(replacement);
                    // Construct the new string
                    return s.substring(0, start) + replacementStr + s.substring(end);
                })
                .orElse("");
    }
}