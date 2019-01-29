import java.util.Arrays;
public class P1_twoSum{
    public static void main(String[] args){
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
    }
    public static int[] twoSum(int[] nums, int target) {
        int low = 0;
        int top = nums.length - 1;
        Arrays.sort(nums);
        while (low < top){
            if (nums[top] + nums[low] > target){
                top--;
            }
            else if (nums[top] + nums[low] < target){
                low ++;
            }
            else{
                return new int[]{low, top};
            }
        }
        return new int[]{low, top};
    }
}