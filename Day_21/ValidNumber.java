package Day_21;

public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        // Trim the string to remove leading and trailing whitespaces
        s = s.trim();
        boolean seenDigits = false;
        boolean seenE = false;
        boolean seenDot = false;
        boolean seenSign = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigits = true;
            } else if (c == 'e' || c == 'E') {
                // 'e' or 'E' is allowed only once and must be preceded by digits
                if (seenE || !seenDigits) {
                    return false;
                }
                seenE = true;
                seenDigits = false;
                seenSign = false;
            } else if (c == '.') {
                // '.' is allowed only once and must not appear after 'e' or 'E'
                if (seenDot || seenE) {
                    return false;
                }
                seenDot = true;
            } else if (c == '+' || c == '-') {
                // '+' or '-' is allowed as a sign character if it's the first character or
                // follows 'e' or 'E'
                if (seenSign || (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) {
                    return false;
                }
                seenSign = true;
            } else {
                // Invalid character
                return false;
            }
        }

        // A valid number must have at least one digit
        return seenDigits;
    }

    public static void main(String[] args) {
        ValidNumber validator = new ValidNumber();
        String[] validNumbers = {
                "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"
        };
        String[] invalidNumbers = {
                "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"
        };

        for (String number : validNumbers) {
            boolean isValid = validator.isNumber(number);
            System.out.println(number + " is valid: " + isValid);
        }

        for (String number : invalidNumbers) {
            boolean isValid = validator.isNumber(number);
            System.out.println(number + " is valid: " + isValid);
        }
    }
}
