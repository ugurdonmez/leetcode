public class ReverseInteger {
    public int reverse(int x) {

        long val = 0;

        while (x != 0) {
            val *= 10;
            val += x % 10;

            if (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }


        return (int)val;
    }

    public static void main (String [] args) {
        ReverseInteger ins = new ReverseInteger();

        System.out.println(ins.reverse(123));
        System.out.println(ins.reverse(-123));
        System.out.println(ins.reverse(120));
        System.out.println(ins.reverse(-120));
    }
}
