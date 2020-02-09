public class StringtoInteger {

    public int myAtoi(String str) {

        if (str.length() == 0) {
            return 0;
        }

        if (str.length() == 1) {
            if (Character.isDigit(str.charAt(0))) {
                return str.charAt(0) - '0';
            } else {
                return 0;
            }
        }

        int index = 0;
        long val = 0;

        // remove training with spaces

        while(index < str.length() && str.charAt(index) == ' ' ) {
            index++;
        }

        boolean neg = false;

        if (index < str.length() && str.charAt(index) == '-') {
            neg = true;
            index++;

            if (index < str.length() && !Character.isDigit(str.charAt(index)) ){
                return 0;
            }
        }

        if (index < str.length() && str.charAt(index) == '+') {
            index++;

            if (index < str.length() && !Character.isDigit(str.charAt(index)) ){
                return 0;
            }
        }

        while (index < str.length()) {
            if (Character.isDigit(str.charAt(index))) {

                if (neg) {
                    val *= 10;

                    if (val > 0) {
                        val = val * -1;
                    }

                    val -= str.charAt(index) - '0';
                } else {
                    val *= 10;
                    val += str.charAt(index) - '0';
                }


                if (val > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (val < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                return (int) val;
            }

            index++;
        }

        return (int) val;
    }

    public static void main(String [] args) {
        StringtoInteger ins = new StringtoInteger();

        System.out.println(ins.myAtoi(""));
        System.out.println(ins.myAtoi("      42aaaaa"));
        System.out.println(ins.myAtoi("      42 word"));

        System.out.println(ins.myAtoi("-42 word"));
        System.out.println(ins.myAtoi("      -42 word"));
        System.out.println(ins.myAtoi("-91283472332"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

}
