import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseTransp {

    public static void main(String[] args) {
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

        int maxLength = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            if (maxLength < arrayList.get(i).length) {
                maxLength = arrayList.get(i).length;
            }
        }

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(j).length > i) {
                    if (arrayList.get(j)[i] % 2 != 0) {
                        System.out.print(arrayList.get(j)[i] + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}
