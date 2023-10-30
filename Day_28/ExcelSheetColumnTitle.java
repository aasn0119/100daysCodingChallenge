package Day_28;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        int columnNumber = 28;
        String columnTitle = convertToTitle(columnNumber);
        System.out.println("Column title: " + columnTitle);
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Adjust to 0-based index (A=0, B=1, ..., Z=25)
            char currentChar = (char) ('A' + (columnNumber % 26));
            result.insert(0, currentChar);
            columnNumber /= 26;
        }

        return result.toString();
    }
}
