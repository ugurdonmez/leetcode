public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder buf = new StringBuilder();

        for (int i = 0; ;i++) {
            if (strs[0].length() <= i) {
                break;
            }

            boolean found = true;
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i) {
                    found = false;
                    break;
                }

                if (strs[j].charAt(i) != c) {
                    found = false;
                    break;
                }
            }

            if (found) {
                buf.append(c);
            } else {
                break;
            }
        }

        return buf.toString();
    }

    public static void main(String [] args) {
        LongestCommonPrefix ins = new LongestCommonPrefix();

        String [] arr = {"flower","flow","flight"};

        System.out.println(ins.longestCommonPrefix(arr));
    }

}
