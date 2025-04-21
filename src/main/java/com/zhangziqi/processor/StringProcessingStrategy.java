package com.zhangziqi.processor;

//@FunctionalInterface // JDK 8新增的函数式接口注解
public interface StringProcessingStrategy {
    /**
     * Handles the processing of a group of consecutive characters in the input string.
     *
     * @param input The original input string.
     * @param start The starting index of the group of consecutive characters to process.
     * @param end   The ending index (exclusive) of the group of consecutive characters to process.
     * @return A new string with the specified group of consecutive characters processed according to the strategy.
     */
    String handleConsecutiveChars(String input, int start, int end);
}
