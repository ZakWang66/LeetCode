public class P8_StringtoInteger {
    public static int myAtoi(String str) {
        final long INT_MAX = (long)Math.pow(2, 31) - 1;
        final long INT_MIN = -1 * (long)Math.pow(2, 31);
        
        if (str == null || str.length() == 0) return 0;
        int i = 0;
        boolean negative = false;
        while (str.charAt(i) == ' ') {
            i++;
            if (i >= str.length()) return 0;
        }
        if (str.charAt(i) == '-') {
            negative = true;
            i++;
            if (i >= str.length()) return 0;
        } 
        else if (str.charAt(i) == '+') {
            negative = false;
            i++;
            if (i >= str.length()) return 0;
        }
        if (str.charAt(i) < '0' || str.charAt(i) > '9') {
            return 0;
        }
        int result = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) <= '9' && str.charAt(i) >='0') {
                int digit = str.charAt(i) - '0';
                if (negative && (-result < INT_MIN/10 || (-result == INT_MIN/10 && digit > (-INT_MIN)%10))) {
                    return (int)INT_MIN;
                }
                if (!negative && (result > INT_MAX/10 || (result == INT_MAX/10 && digit > INT_MAX%10))) {
                    return (int)INT_MAX;
                }
                result *= 10;
                result += digit;
            }
            else break;
        }
        if (negative) result = -result;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483647"));
    }
}