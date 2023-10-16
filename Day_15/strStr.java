package Day_15;

public class strStr {

    public static int Strstr(String str1, String str2) {
        if (str1.contains(str2)) {
            return str1.indexOf(str2);
        }

        return -1;

    }

    public static int Strstr_I(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int m = haystack.length();
        int n = needle.length();

        if (m < n) {
            return -1;
        }

        for (int i = 0; i <= m - n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == n) {
                return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        String haystack = "Hello", needle = "ll";
        System.out.println("output: " + Strstr(haystack, needle));
        System.out.println("output: " + Strstr_I(haystack, needle));
    }
}
