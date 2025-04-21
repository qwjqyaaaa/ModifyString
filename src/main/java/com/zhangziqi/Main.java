package com.zhangziqi;

import com.zhangziqi.Enum.StringProcessEnum;
import com.zhangziqi.processor.AbstractStringProcessor;
import com.zhangziqi.processor.ConsecutiveCharProcessor;
import com.zhangziqi.processor.RemovalStrategy;
import com.zhangziqi.processor.ReplacementStrategy;
import com.zhangziqi.processor.StringProcessingStrategy;

/**
 * The main method is the entry point of the application.
 * args[0]: "REMOVAL" or "REPLACEMENT",
 * args[0]: The string to be validated , args[1]: "aabcccbbad"
 */
public class Main {
    public static void main(String[] args) {
        //args = new String[]{"REMOVAL", "aabcccbbad"};  // or {"REPLACEMENT", "abcccbad"}

        //Validation the arguments
        if (args == null || args.length < 2) {
            System.out.println("insufficient arguments,please check the arguments.");
            return;
        }
        if (args[0] != null &&
                (!StringProcessEnum.REMOVAL.name().equals(args[0]) && !StringProcessEnum.REPLACEMENT.name().equals(args[0]))
        ) {
            System.out.println("First arguments error,please check the arguments.");
            return;
        }
        if (args[1] != null && !isAllEnglishLetters(args[1])) {
            System.out.println("Second arguments error,please check the arguments.");
            return;
        }

        String mode = args[0];
        String input = args[1];

        // Create the appropriate strategy based on the mode
        StringProcessingStrategy strategy =
                StringProcessEnum.REPLACEMENT.name().equalsIgnoreCase(mode) ?
                        new ReplacementStrategy() : new RemovalStrategy();

        // Create the processor using the template method pattern and the strategy pattern
        AbstractStringProcessor processor = new ConsecutiveCharProcessor(strategy, 3);

        System.out.println("Input: " + input);
        // Process the input string
        String result = processor.process(input);
        System.out.println("Final result: " + result);
    }

    /**
     * Checks if the given string contains only English letters.
     *
     * @param str The string to check.
     * @return true if the string contains only English letters, false otherwise.
     */
    public static boolean isAllEnglishLetters(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
