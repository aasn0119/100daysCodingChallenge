package Day_22;

public class NumbersToWords {
    // Arrays for words representation
    private final String[] LESS_THAN_TWENTY = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };
    private final String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };
    private final String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

    // Convert a number to words
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int i = 0;
        String words = "";

        // Process the number in groups of three digits
        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    // Helper function to convert a three-digit number to words
    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_TWENTY[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return LESS_THAN_TWENTY[num / 100] + " Hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        NumbersToWords converter = new NumbersToWords();
        int[] numbers = { 123, 12345, 1234567, 1234567891 };

        for (int num : numbers) {
            String words = converter.numberToWords(num);
            System.out.println(num + " in words: " + words);
        }
    }
}
