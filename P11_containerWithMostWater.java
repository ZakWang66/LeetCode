public class P11_containerWithMostWater{
    public static void main(String[] args) {
       System.out.print(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public static int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                int tmp = Math.min(height[i], height[j]) * (j - i);
                if (tmp > area) {
                    area = tmp;
                }
            }
        }
        return area;
    }
}