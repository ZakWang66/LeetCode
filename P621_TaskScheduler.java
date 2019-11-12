public class P621_TaskScheduler {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] map = new int[26];
            for (char k : tasks) {
                map[k - 'A']++;
            }
            Arrays.sort(map);
            int time = 0;
            while (map[25] > 0) {
                for (int i = 0; i <= n; i++) {
                    if (map[25] == 0) {
                        break;
                    }
                    if (i < 26 && map[25 - i] > 0) {
                        map[25 - i]--;
                    }
                    time++;
                }
                Arrays.sort(map);
            }
            return time;
        }
    }
}