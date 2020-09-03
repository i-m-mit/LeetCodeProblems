package StringProblems;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        String local;
        String domain;
        for (String email : emails) {
            local = email.split("@")[0];
            domain = email.split("@")[1];

            local = local.split("\\+")[0];
            local = local.replaceAll("\\.", "");
            set.add(local + "@" + domain);
        }

        return set.size();
    }

    public int numUniqueEmailsV1(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            uniqueEmails.add(normalizeEmail(email));
        }
        return uniqueEmails.size();
    }

    String normalizeEmail(String email) {
        StringBuilder sb = new StringBuilder();
        int atIndex = email.indexOf('@');
        for (int i = 0; i < atIndex; i++) {
            char currChar = email.charAt(i);
            if (currChar == '+')
                break;
            if (currChar != '.') {
                sb.append(currChar);
            }
        }
        return sb.append(email.substring(atIndex)).toString();
    }

    public static void main(String[] args) {
        UniqueEmailAddresses o = new UniqueEmailAddresses();

        System.out.println("Number of different mails: " + o.numUniqueEmailsV1(args));
    }
}