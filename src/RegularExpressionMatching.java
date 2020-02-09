import java.util.Arrays;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String pattern) {

        int n = s.length();
        int m = pattern.length();

        if (m == 0) {
            return (n == 0);
        }

        boolean[][] lookup = new boolean[n + 1][m + 1];

        lookup[0][0] = true;

        for (int j = 1; j <= m; j++) {
            if (pattern.charAt(j - 1) == '*') {
                lookup[0][j] = lookup[0][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pattern.charAt(j - 1) == '*') {
                    lookup[i][j] = lookup[i][j - 1] || lookup[i - 1][j];
                } else if (pattern.charAt(j - 1) == '.' || s.charAt(i - 1) == pattern.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1];
                } else {
                    lookup[i][j] = false;
                }
            }
        }

        return lookup[n][m];
    }

    public static void main (String [] args) {
        RegularExpressionMatching ins = new RegularExpressionMatching();

        System.out.println(ins.isMatch("aaaa", "aaa"));
    }
}
