public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int max = 0;

        while (left < right) {
            max = Integer.max(max, Integer.min(height[left], height[right]) * (right - left));

            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

}
