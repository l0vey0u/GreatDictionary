package pe.duckhoim.greatdict;

import java.util.ArrayList;
import java.util.Scanner;

public class FullGreatManProfile extends GreatManProfile {
    private ArrayList<String> fullInfo = new ArrayList<>();

    public void readAchieve(Scanner sc) {
        String l;
        sc.nextLine();
        while (!(l = sc.nextLine()).isEmpty()) {
            fullInfo.add(l);
        }
    }

    public void print() {
        printProfile();
        for (String l : fullInfo) {
            System.out.println(l);
        }
    }

    public void print(SearchEntity searchEntity) {
        printProfile(searchEntity);
        System.out.println();
        for (String l : fullInfo) {
            if (searchEntity.getCategory() == SearchEntity.Category.Achieve)
                System.out.println(l.replace(searchEntity.getKwd(), String.format("<<%s>>", searchEntity.getKwd())));
            else
                System.out.println(l);
        }
    }

    public boolean contain(SearchEntity searchEntity) {
        if (searchEntity.getCategory() == SearchEntity.Category.Achieve) {
            String kwd = searchEntity.getKwd();
            for (String l : fullInfo) {
                if (l.contains(kwd))
                    return true;
            }
        } else {
            return is(searchEntity);
        }
        return false;
    }
}
