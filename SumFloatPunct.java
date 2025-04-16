import static java.lang.Character.END_PUNCTUATION;
import static java.lang.Character.START_PUNCTUATION;

public class SumFloatPunct {

    public static void main(String[] args) {
        float sum = 0;
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args[i].length(); j++) {

                char character = args[i].charAt(j);
                int type = Character.getType(character);

                if (!Character.isWhitespace(character) && type != END_PUNCTUATION && type != START_PUNCTUATION) {
                    number.append(character);
                    if (j == args[i].length() - 1) {
                        sum += Float.parseFloat(number.toString());
                        number.setLength(0);
                    }
                } else {
                    if (number.length() > 0)
                        sum += Float.parseFloat(number.toString());
                    number.setLength(0);
                }
            }
        }
        System.out.println(sum);
    }
}