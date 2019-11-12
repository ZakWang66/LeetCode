import java.util.List;

/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 *
 * https://leetcode.com/problems/expression-add-operators/description/
 *
 * algorithms
 * Hard (33.40%)
 * Likes:    788
 * Dislikes: 111
 * Total Accepted:    75.4K
 * Total Submissions: 225.3K
 * Testcase Example:  '"123"\n6'
 *
 * Given a string that contains only digits 0-9 and a target value, return all
 * possibilities to add binary operators (not unary) +, -, or * between the
 * digits so they evaluate to the target value.
 * 
 * Example 1:
 * 
 * 
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"] 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 * 
 * Example 3:
 * 
 * 
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * 
 * Example 4:
 * 
 * 
 * Input: num = "00", target = 0
 * Output: ["0+0", "0-0", "0*0"]
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: num = "3456237490", target = 9191
 * Output: []
 * 
 * 
 */
class Solution {

    private class Calculation{
        int[] nums;
        char[] ops;
        String expression;

        public Calculation(String num, String box) {
            // format the expression
        }

        public int claculate() {

        }
    }

    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        StringBuilder currentBox = new StringBuilder();
        boxGenerator(int index, String num, int target, StringBuilder currentBox, List<String> res);
        return res;
    }
    private void boxGenerator(int index, String num, int target, StringBuilder currentBox, List<String> res) {
        // basecase
        if (index >= num.length() - 1) {
            Calculation calc = new Calculation(num, currentBox.toString());
            if (calc.claculate() == target) {
                res.add(calc.expression);
            }
            return;
        }
        for (int i = index; i < num.length() - 1; i++) {
            currentBox.append("+");
            boxGenerator(int index, String num, int target, StringBuilder currentBox, List<String> res);
            currentBox.deleteCharAt(num.length() - 1);

            currentBox.append("-");
            boxGenerator(int index, String num, int target, StringBuilder currentBox, List<String> res)
            currentBox.deleteCharAt(num.length() - 1);

            currentBox.append("*");
            boxGenerator(int index, String num, int target, StringBuilder currentBox, List<String> res)
            currentBox.deleteCharAt(num.length() - 1);

            currentBox.append(" ");
            boxGenerator(int index, String num, int target, StringBuilder currentBox, List<String> res)
            currentBox.deleteCharAt(num.length() - 1);
        }
    }



}

