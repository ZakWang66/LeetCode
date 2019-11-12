public class P33_searchRotatedSortedArray {
    public static void main(String[] args) {
        System.out.print(search(new int[]{4,5,6,7,0,1,2}, 0));
    }
    public static int search(int[] nums, int target) {
        int rotatePoint = searchRotatePoint(nums);
        int r1 = binarySearch(nums, target, 0, rotatePoint);
        int r2 = binarySearch(nums, target, rotatePoint + 1, nums.length - 1);
        if (r1 != -1) {
            return r1;
        }
        else if (r2 != -1) {
            return r2;
        }
        else {
            return -1;
        }
    }
    private static int searchRotatePoint(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[low] < nums[mid]) {
                low = mid;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
    private static int binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            }
            else if (nums[mid] > target){
                high = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}