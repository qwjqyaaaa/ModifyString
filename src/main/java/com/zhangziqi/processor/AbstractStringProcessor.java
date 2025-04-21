package com.zhangziqi.processor;

/**
 * AbstractStringProcessor is an abstract template class that defines the skeleton of a string processing algorithm.
 */
public abstract class AbstractStringProcessor {
    /**
     * The strategy object used for handling consecutive characters.
     */
    protected final StringProcessingStrategy strategy;

    public AbstractStringProcessor(StringProcessingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Template method that defines the processing flow.
     */
    public final String process(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String result = input;
        String previous;

        // Process the string in steps until no further changes are made
        do {
            previous = result;
            result = processStep(result);
            if (!result.equals(previous)) {
                // Call the hook method after each processing step
                onStepProcessed(previous, result);
            }
        } while (!result.equals(previous));

        return result;
    }

    /**
     * Abstract method for the specific processing step.
     */
    protected abstract String processStep(String input);

    /**
     * Hook method called after each processing step.
     */
    protected void onStepProcessed(String before, String after) {
        System.out.println("-> " + after);
    }

    /**
     * Common method to find groups of consecutive characters in the input string.
     */
    protected int[] findConsecutiveChars(String input, int threshold) {
        char[] chars = input.toCharArray();

        for (int i = 0; i <= chars.length - threshold; i++) {
            // Check if the current position starts a group of consecutive characters
            if (isConsecutive(chars, i, threshold)) {
                // Calculate the initial end index of the consecutive group
                int end = i + threshold;
                while (end < chars.length && chars[end] == chars[i]) {
                    end++;
                }
                return new int[]{i, end};
            }
        }
        return null;
    }

    /**
     * Helper method to check if a group of characters starting at a given index is consecutive.
     *
     * @param chars The character array to check.
     * @param start The starting index of the group.
     * @param threshold The length of the group to check.
     * @return true if the group is consecutive, false otherwise.
     */
    private boolean isConsecutive(char[] chars, int start, int threshold) {
        for (int i = start + 1; i < start + threshold; i++) {
            if (chars[i] != chars[start]) {
                return false;
            }
        }
        return true;
    }
}