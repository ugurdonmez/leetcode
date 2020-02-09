public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int [][] mem = new int [s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            mem[i][i] = 1;
        }

        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                mem[i][i+1] = 1;

                start = i;
                maxLength = 2;
            }
        }



        for (int k = 3; k <= s.length(); k++) {
            for (int i = 0; i < s.length() - k + 1; i++) {
                int j = i + k - 1;

                if (mem[i+1][j-1]==1 && s.charAt(i) == s.charAt(j)) {
                    mem[i][j] = 1;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        return s.substring(start, start+maxLength);
    }

    public String longestPalindrome1(String s) {

        if (s.length() <= 1) {
            return s;
        }


        int [][] mem = new int [s.length()+1][s.length()+1];

        int longestSize = 0;
        String longestStr = "";

        int size = s.length();


        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < s.length()+1; j++) {
                if (s.charAt(i-1) == s.charAt(size-j)) {
                    mem[i][j] = mem[i-1][j-1]+1;
                    if (mem[i][j] > longestSize) {
                        longestSize = mem[i][j];
                        longestStr = s.substring(i-longestSize,i);
                    }
                } else {
                    mem[i][j] = Integer.max(mem[i-1][j-1], Integer.max(mem[i-1][j], mem[i][j-1]));
                }
            }
        }

        prt(mem);

        return longestStr;
    }

    public void prt (int [][] mem) {
        for (int[] aMem : mem) {
            for (int j = 0; j < mem[0].length; j++) {
                System.out.print(aMem[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main (String [] args) {
        LongestPalindromicSubstring ins = new LongestPalindromicSubstring();

        System.out.println(ins.longestPalindrome("babad"));
//        System.out.println(ins.longestPalindrome("babad"));
//        System.out.println(ins.longestPalindrome("b"));
//        System.out.println(ins.longestPalindrome("cbbd"));
//        System.out.println(ins.longestPalindrome(""));
    }
}
