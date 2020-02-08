public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }

        int longest = 1;

        for (int i = 0; i < s.length(); i++) {
            boolean[] check = new boolean[260];
            check[s.charAt(i)] = true;

            for (int j = i+1; j < s.length(); j++) {
                if (check[s.charAt(j)]) {
                    if (j-i > longest) {
                        longest = j - i;
                    }
                    break;
                } else {
                    check[s.charAt(j)] = true;
                }

                if (j == s.length() -1) {
                    if (j-i >= longest) {
                        longest = j - i + 1;
                    }
                }
            }
        }

        return longest;
    }

    public static void main(String [] args) {

        LongestSubstringWithoutRepeatingCharacters ins = new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(ins.lengthOfLongestSubstring("ab"));
        System.out.println(ins.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(ins.lengthOfLongestSubstring("bbbbb"));
        System.out.println(ins.lengthOfLongestSubstring("pwwkew"));
        System.out.println(ins.lengthOfLongestSubstring(" "));
    }

}
