import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordStatInput {
    public static void main(String[] args) {
        Map<String, Integer> wordStat = new LinkedHashMap<>();

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(args[0]),
                                StandardCharsets.UTF_8
                        )
                )
        ) {
            char[] buffer = new char[1024];
            StringBuilder word = new StringBuilder();

            while (reader.ready()) {
                int l = reader.read(buffer);
                for (int i = 0; i < l; i++) {
                    char ch = buffer[i];
                    if (Character.isLetter(ch) || ch == '\'' || Character.getType(ch) == Character.DASH_PUNCTUATION) {
                        word.append(ch);
                    } else {
                        if (!word.isEmpty()) {
                            String key = word.toString();
                            key = key.toLowerCase();
                            wordStat.put(key, wordStat.getOrDefault(key, 0) + 1);
                            word.setLength(0);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        try (
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(args[1]),
                                StandardCharsets.UTF_8
                        )
                )
        ) {
            for (String key : wordStat.keySet()) {
                writer.write(key + " " + wordStat.get(key));
                writer.write("\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
