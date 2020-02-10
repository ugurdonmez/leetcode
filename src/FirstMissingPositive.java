public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        for (int i = 1; i < Integer.MAX_VALUE; i++) {

            boolean found = false;

            for (int j: nums) {
                if (j == i) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return i;
            }

        }

        return 0;
    }

}
