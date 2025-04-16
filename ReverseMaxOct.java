import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ReverseMaxOct {

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            ArrayList<int[]> arrayList = new ArrayList<int[]>();

            while (input.hasNextLine()) {
                Scanner lineScanner = new Scanner(input.nextLine());
                int[] line = new int[1];
                int size = 1;
                while (lineScanner.hasNext()) {
                    if (size <= line.length) {
                        line[size - 1] = (int) Long.parseLong(lineScanner.next(), 8);
                        size++;
                    } else {
                        line = Arrays.copyOf(line, line.length * 2);
                    }
                }
                line = Arrays.copyOf(line, size - 1);
                arrayList.add(line);
            }

            input.close();

            int maxLength = arrayList.get(0).length;
            for (int i = 1; i < arrayList.size(); i++) {
                if (arrayList.get(i).length > maxLength) {
                    maxLength = arrayList.get(i).length;
                }
            }

            int[] maxFromLines = new int[arrayList.size()];
            int[] maxFromColumns = new int[maxLength];

            for (int i = 0; i < arrayList.size(); i++) {
                maxFromLines[i] = Integer.MIN_VALUE;
            }

            for (int i = 0; i < maxLength; i++) {
                maxFromColumns[i] = Integer.MIN_VALUE;
            }

            for (int i = 0; i < arrayList.size(); i++) {
                int[] line = arrayList.get(i);
                if (line.length == 0) {
                    continue;
                }
                for (int j = 0; j < line.length; j++) {
                    if (line[j] > maxFromLines[i]) {
                        maxFromLines[i] = line[j];
                    }

                    if (line[j] > maxFromColumns[j]) {
                        maxFromColumns[j] = line[j];
                    }
                }
            }

            for (int i = 0; i < arrayList.size(); i++) {
                for (int j = 0; j < arrayList.get(i).length; j++) {
                    System.out.print(Integer.toOctalString(Math.max(maxFromLines[i], maxFromColumns[j])) + " ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.err.println(e.getMessage() + " : Problems while reading a stream");
        }

    }
}