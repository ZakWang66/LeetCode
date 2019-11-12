public class P31_nextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int swapPoint = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                swapPoint = i;
                break;
            }
        }
        if (swapPoint >= 0) {
            findAndSwap(nums, swapPoint);
        }
        sortLast(nums, swapPoint);
    }
    private void findAndSwap(int[] nums, int swapPoint) {
        for (int i = swapPoint + 1; i < nums.length; i++) {
            if (nums[i] <= nums[swapPoint]) {
                int tmp = nums[i - 1];
                nums[i - 1] = nums[swapPoint];
                nums[swapPoint] = tmp;
                return;
            }
        }
        int tmp = nums[nums.length - 1];
        nums[nums.length - 1] = nums[swapPoint];
        nums[swapPoint] = tmp;
    }
    private void sortLast(int[] nums, int swapPoint) {
        int low = swapPoint + 1;
        int high = nums.length - 1;
        while (low < high) {
            int tmp = nums[low];
            nums[low] = nums[high];
            nums[high] = tmp;
            low++;
            high--;
        }
    }
}