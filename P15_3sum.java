import java.util.*;
public class P15_3sum{
    public static void main(String[] args){
        List<List<Integer>> result = threeSum(new int[]{1,-3,-2,4,5});
        for (int i = 0; i < result.size(); i++){
            System.out.println(result.get(i).toString());
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {

        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++){
                if (i != 0 && nums[i] == nums[i-1]) continue;
                int low = i + 1;
                int top = nums.length - 1;
                while (low < top){
                    if (nums[low] + nums[top] > -nums[i]){
                        top--;
                    }
                    else if (nums[low] + nums[top] < -nums[i]){
                        low++;
                    }
                    else{
                        List<Integer> solution = new ArrayList<Integer>();
                        solution.add(nums[i]);
                        solution.add(nums[low]);
                        solution.add(nums[top]);
                        while (low < top && nums[top] == nums[top-1]) top--;
                        while (low < top && nums[low] == nums[low+1]) low++;
                        result.add(solution);
                        top--;
                        low++;
                    }
                }
            }
            return result;
        }
        /** My old solution
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            int low = i + 1;
            int top = nums.length - 1;
            while (low < top){
                if (nums[low] + nums[top] > -nums[i]){
                    top--;
                }
                else if (nums[low] + nums[top] < -nums[i]){
                    low++;
                }
                else{
                    List<Integer> solution = new ArrayList<Integer>();
                    solution.add(nums[i]);
                    solution.add(nums[low]);
                    solution.add(nums[top]);
                    if (!result.contains(solution)){
                        result.add(solution);
                    }
                    top--;
                }
            }
        }
        return result;
        */
    }
    /** Sample solution
    public List<List<Integer>> threeSum(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> res = new LinkedList<>(); 
    for (int i = 0; i < num.length-2; i++) {
        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
                    while (lo < hi && num[lo] == num[lo+1]) lo++;
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
                    lo++; hi--;
                } else if (num[lo] + num[hi] < sum) lo++;
                else hi--;
           }
        }
    }
    return res;
     */
}