package pe.duckhoim.greatdict;

import java.util.ArrayList;
import java.util.Scanner;

public class FullGreatManProfile extends GreatManProfile {
    private ArrayList<String> fullInfo;

    public void readAchieve(Scanner sc) {
        String l = null;
        while(!(l = sc.nextLine()).isEmpty()) {
            fullInfo.add(l);
        }
    }

    public void print() {
        printProfile();
        for(String l:fullInfo) {
            System.out.println(l);
        }
    }
}
