import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Reverse {


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
                        line[size - 1] = lineScanner.nextInt();
                        size++;
                    } else {
                        line = Arrays.copyOf(line, line.length * 2);
                    }
                }
                line = Arrays.copyOf(line, size - 1);
                arrayList.add(line);
            }

            input.close();

            for (int i = arrayList.size() - 1; i >= 0; i--) {
                for (int j = arrayList.get(i).length - 1; j >= 0; j--) {
                    System.out.print(arrayList.get(i)[j]);
                    if (j != 0) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage() + " : Problems while reading a stream");
        }

    }
}
