public class PalindromeNumber {
    public boolean isPalindrome(int x) {

        StringBuilder builder = new StringBuilder(String.valueOf(x));

        builder.reverse();

        return builder.toString().equals(String.valueOf(x));

    }
}
