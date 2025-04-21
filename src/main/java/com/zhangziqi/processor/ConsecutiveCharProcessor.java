package com.zhangziqi.processor;

/**
 * ConsecutiveCharProcessor is a concrete processor that implements the abstract methods of AbstractStringProcessor.
 * It processes strings by finding and handling groups of consecutive characters that meet a specified threshold.
 */
public class ConsecutiveCharProcessor extends AbstractStringProcessor {
    /**
     * The threshold for consecutive characters.
     */
    private final int threshold;

    /**
     * Constructs a ConsecutiveCharProcessor with the given strategy and threshold.
     * @param strategy The processing strategy to use
     * @param threshold The threshold for consecutive characters.
     */
    public ConsecutiveCharProcessor(StringProcessingStrategy strategy, int threshold) {
        super(strategy);
        this.threshold = threshold;
    }

    /**
     * Processes the input string step by step.
     * @param input
     * @return
     */
    @Override
    protected String processStep(String input) {
        // Find the indices of the first group of consecutive characters that meets the threshold.
        int[] indices = findConsecutiveChars(input, threshold);
        if (indices != null) {
            // If such a group is found, handle it using the specified strategy
            return strategy.handleConsecutiveChars(input, indices[0], indices[1]);
        }
        return input;
    }
}