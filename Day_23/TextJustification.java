package Day_23;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;

        while (startIndex < words.length) {
            int lineStart = startIndex;
            int lineEnd = lineStart;
            int lineLength = 0;

            while (lineEnd < words.length) {
                int newLength = lineLength + words[lineEnd].length() + (lineEnd > lineStart ? 1 : 0);
                if (newLength <= maxWidth) {
                    lineLength = newLength;
                    lineEnd++;
                } else {
                    break;
                }
            }

            StringBuilder lineBuilder = new StringBuilder();
            int extraSpaces = maxWidth - lineLength + (lineEnd - lineStart - 1);
            int gaps = lineEnd - lineStart - 1;

            if (lineEnd == words.length || gaps == 0) {
                // Left-justified for the last line or if there's only one word in the line
                for (int i = lineStart; i < lineEnd; i++) {
                    lineBuilder.append(words[i]);
                    if (i < lineEnd - 1) {
                        lineBuilder.append(' ');
                    }
                }
                while (lineBuilder.length() < maxWidth) {
                    lineBuilder.append(' ');
                }
            } else {
                int spaces = extraSpaces / gaps;
                int extra = extraSpaces % gaps;
                for (int i = lineStart; i < lineEnd; i++) {
                    lineBuilder.append(words[i]);
                    if (i < lineEnd - 1) {
                        for (int j = 0; j < spaces; j++) {
                            lineBuilder.append(' ');
                        }
                        if (extra > 0) {
                            lineBuilder.append(' ');
                            extra--;
                        }
                    }
                }
            }
            result.add(lineBuilder.toString());
            startIndex = lineEnd;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
        int maxWidth = 16;
        List<String> justifiedText = fullJustify(words, maxWidth);
        for (String line : justifiedText) {
            System.out.println(line);
        }
    }
}
