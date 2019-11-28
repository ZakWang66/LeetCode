import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */

// @lc code=start
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, List<String>> routes = new HashMap<>();
        for (List<String> ticket : tickets) {
            String departure = ticket.get(0);
            String destination = ticket.get(1);
            if (!routes.containsKey(departure)) routes.put(departure, new LinkedList<>());
            routes.get(departure).add(destination);
        }
        for (List<String> dests : routes.values()) {
            Collections.sort(dests);
        }

        int stopCount = tickets.size() + 1;
        List<String> res = new LinkedList<>();
        res.add("JFK");
        dfs("JFK", stopCount, res, routes);
        return res;
    }

    private boolean dfs(String currentStop, int stopCount, List<String> res, Map<String, List<String>> routes) {
        if (res.size() == stopCount) {
            return true;
        }
        List<String> availableRoutes = routes.get(currentStop);
        if (availableRoutes == null || availableRoutes.isEmpty()) {
            return false;
        }

        for (int i = 0; i < availableRoutes.size(); i++) {
            String destination = availableRoutes.get(i);
            availableRoutes.remove(i);
            res.add(destination);
            if (dfs(destination, stopCount, res, routes)) {
                return true;
            }
            availableRoutes.add(i, destination);
            res.remove(res.size()-1);
        }
        return false;
    }
}
// @lc code=end

