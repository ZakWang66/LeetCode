import java.util.*;

public class P811 {

    public static void main(String[] args) {
        P811 p = new P811();
        System.out.println(p.subdomainVisits(new String[] {"9001 discuss.leetcode.com"}));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> visitCount = new HashMap<>();
        for (String s : cpdomains) {
            String[] splitRes = s.split(" ");
            int count = Integer.valueOf(splitRes[0]);
            String[] domains = splitRes[1].split("\\.");
            if (domains.length == 0) continue;
            String domain = "";
            for (int i = domains.length - 1; i >= 0; i--) {
                if (i == domains.length - 1) {
                    domain = domains[i];
                }
                else {
                    domain = domains[i] + "." + domain;
                }
                if (visitCount.containsKey(domain)) {
                    visitCount.put(domain, visitCount.get(domain) + count);
                }
                else {
                    visitCount.put(domain, count);
                }
                
            }
        }
        StringBuffer s;
        s
        List<String> res = new LinkedList<>();
        for (String domain : visitCount.keySet()) {
            res.add(visitCount.get(domain) + " " + domain);
        }
        return res;
    }
}