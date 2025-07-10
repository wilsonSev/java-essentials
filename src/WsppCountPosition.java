import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WsppCountPosition {
    public static void main(String[] args) {
        Map<String, IntList> wordStat = new HashMap<>();
        File file = new File(args[0]);
        int lineIndex = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                lineIndex++;
                int index = 0;
                while (lineScanner.hasNextWord()) {
                    index++;
                    String word = lineScanner.nextWord().toLowerCase();
                    IntList list = wordStat.getOrDefault(word, new IntList());
                    list.add(lineIndex);
                    list.add(index);
                    wordStat.put(word, list);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        List<Map.Entry<String, IntList>> entryList = new ArrayList<>(wordStat.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8))) {
            for (Map.Entry<String, IntList> entry : entryList) {
                String key = entry.getKey();
                IntList array = entry.getValue();

                writer.write(key);
                System.out.print(key);
                writer.write(" " + array.get(0) / 2);
                System.out.print(" " + array.get(0) / 2);

                for (int i = 1; i < array.size(); i += 2) {
                    writer.write(" " + array.get(i) + ":" + array.get(i + 1));
                    System.out.print(" " + array.get(i) + ":" + array.get(i + 1));
                }

                writer.write(System.lineSeparator());
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
