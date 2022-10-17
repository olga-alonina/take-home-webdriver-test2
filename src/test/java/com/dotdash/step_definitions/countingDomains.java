package com.dotdash.step_definitions;

public class countingDomains {
    public static void calculateClicksByDomain1(String[] counts) {
        int calc = 0;
        String[] domains = {"com","google.com", "stackoverflow.com", "overflow.com", "yahoo.com", "mail.yahoo.com",
                "mobile.sports.yahoo.com", "sports.yahoo.com", "com.com", "org", "wikipedia.org", "en.wikipedia.org",
                "m.wikipedia.org", "mobile.sports", "sports", "uk", "co.uk", "google.co.uk"};
        for (String domain : domains) {
            calc = 0;
            for (String count : counts) {
                if (count.contains(domain)) {
                    String cutter = count.substring(0, count.indexOf(","));
                    String posDomain = count.substring(count.indexOf(",") + 1);
                    String temp = posDomain.replace(domain, "").trim();
                    if (temp.isEmpty() || temp.endsWith(".")) {
                        int cut = Integer.parseInt(cutter);
                        calc += cut;
                    }
                }
            }
            System.out.println(domain + ": " + calc);
        }
    }

    public static void calculateClicksByDomain(String[] counts, String domain) {
        int calc = 0;
        for (String count : counts) {
            if (count.contains(domain)) {
                String cutter = count.substring(0, count.indexOf(","));
                String posDomain = count.substring(count.indexOf(",") + 1);
                String temp = posDomain.replace(domain, "").trim();
                if (temp.isEmpty() || temp.endsWith(".")) {
                    int cut = Integer.parseInt(cutter);
                    calc += cut;
                }
            }
        }
        System.out.println(domain + " " + calc);
    }


    public static void main(String[] args) {
        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "5,com.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"
        };
//        calculateClicksByDomain(counts, "com");
//        calculateClicksByDomain(counts, "google.com");
//        calculateClicksByDomain(counts, "stackoverflow.com");
//        calculateClicksByDomain(counts, "overflow.com");
//        calculateClicksByDomain(counts, "yahoo.com");
//        calculateClicksByDomain(counts, "mail.yahoo.com");
//        calculateClicksByDomain(counts, "mobile.sports.yahoo.com");
//        calculateClicksByDomain(counts, "sports.yahoo.com");
//        calculateClicksByDomain(counts, "org");
//        calculateClicksByDomain(counts, "wikipedia.org");
//        calculateClicksByDomain(counts, "en.wikipedia.org");
//        calculateClicksByDomain(counts, "m.wikipedia.org");
//        calculateClicksByDomain(counts, "mobile.sports");
        calculateClicksByDomain1(counts);
    }
}