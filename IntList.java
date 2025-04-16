public class IntList implements Comparable<IntList> {
    private int[] array = {0};
    private int size = 1;

    public void add(int value) {
        if (size == array.length) {
            int[] newArray = new int[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[0]++;
        array[size++] = value;
    }

    public int get(int index) {
        return array[index];
    }

    public int size() {
        return size;
    }

    public String display() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size - 1; i++) {
            str.append(array[i]).append(" ");
        }
        str.append(array[size - 1]);
        return str.toString();
    }

    @Override
    public int compareTo(IntList o) {
        int result = 0;
        if (array[0] < o.array[0]) {
            result = -1;
        } else if (array[0] > o.array[0]) {
            result = 1;
        } else {
            if (array[1] < o.array[1]) {
                result = -1;
            } else if (array[1] > o.array[1]) {
                result = 1;
            } else {
                if (array[2] < o.array[2]) {
                    result = -1;
                } else if (array[2] > o.array[2]) {
                    result = 1;
                }
            }
        }
        return result;
    }
}
