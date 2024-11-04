import java.io.*;

public class TextAnalyzer {
    public static void main(String[] args) throws IOException {
        File file = new File("bulsu.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        StringBuilder textContent = new StringBuilder();
        int wordCount = 0;
        int sentenceCount = 0;

        String line;
        while ((line = reader.readLine()) != null) {
            textContent.append(line.toUpperCase()).append(" ");

            boolean inWord = false;
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                if (Character.isLetterOrDigit(ch)) {
                    if (!inWord) {
                        inWord = true;
                        wordCount++;
                    }
                } else {
                    inWord = false;
                    if (ch == '.' || ch == '!' || ch == '?') {
                        sentenceCount++;
                    }
                }
            }
        }

        System.out.println("Uppercase Text:\n" + textContent);
        System.out.println("Total Words: " + wordCount);
        System.out.println("Total Sentences: " + sentenceCount);
    }
}
