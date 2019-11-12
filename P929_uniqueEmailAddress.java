import java.util.HashSet;
import java.util.Set;

public class P929_uniqueEmailAddress {
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        Set<String> list = new HashSet<String>();
        for (String email : emails) {
            String[] temp = email.split("@");
            String localName = temp[0];
            String domainName = temp[1];
            temp = localName.split("\\.");
            if (temp.length > 0) {
                localName = "";
                for (String s : temp) {
                    localName += s;
                }
            }
            if (temp.length > 0) {
                temp = localName.split("\\+");
                localName = temp[0];
            }
            list.add(localName + domainName);
        }
        System.out.println(list.size());
    }
}