package pe.duckhoim.greatdict;

import java.util.Scanner;

public class SimpleGreatManProfile extends GreatManProfile {
    private String briefInfo;
    public void readAchieve(Scanner sc) {
        this.briefInfo = sc.nextLine();
    }
    public void print()
    {
        printProfile();
        System.out.println(" "+briefInfo);
    }
}
