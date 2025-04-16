import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class Wspp {
    public static void main(String[] args) {
        Map<String, IntList> wordStat = new LinkedHashMap<>();
        File file = new File(args[0]);
        int index = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextWord()) {
                index++;
                String word = scanner.nextWord().toLowerCase();
                IntList list = wordStat.getOrDefault(word, new IntList());
                list.add(index);
                wordStat.put(word, list);
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
                writer.write(key);
                IntList array = wordStat.get(key);
                for (int i = 0; i < array.size(); i++) {
                    writer.write(" " + array.get(i));
                }
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}