import java.util.Arrays;
import java.util.stream.Collectors;

public class ZigZagConversion {


    public String convert(String s, int numRows) {

        if (numRows <= 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean dirDown = true;

        for(char c : s.toCharArray()) {
            rows[currentRow].append(c);

            if (dirDown) {
                currentRow++;

                if (currentRow == numRows) {
                    dirDown = false;
                    currentRow = numRows - 2;
                }
            } else {
                currentRow--;

                if (currentRow == -1) {
                    dirDown = true;
                    currentRow = 1;
                }
            }
        }

        return Arrays.stream(rows)
                .map(x -> x.toString())
                .collect(Collectors.joining());
    }

    public static void main (String [] args) {
        ZigZagConversion ins = new ZigZagConversion();

        System.out.println(ins.convert("ABABAB",2));
        // System.out.println(ins.convert("PAYPALISHIRING",3));
    }
}
