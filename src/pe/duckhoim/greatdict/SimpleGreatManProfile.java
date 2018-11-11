package pe.duckhoim.greatdict;

import java.util.Scanner;

public class SimpleGreatManProfile extends GreatManProfile {
    private String briefInfo;

    public void readAchieve(Scanner sc) {
        this.briefInfo = sc.nextLine();
    }

    public void print() {
        printProfile();
        System.out.println(" " + briefInfo);
    }

    public void print(SearchEntity searchEntity) {
        printProfile(searchEntity);
        if (searchEntity.getCategory() == SearchEntity.Category.Achieve)
            System.out.println(" " + briefInfo.replace(searchEntity.getKwd(), String.format("<<%s>>", searchEntity.getKwd())));
        else
            System.out.println(" " + briefInfo);
    }

    public boolean contain(SearchEntity searchEntity) {
        if (searchEntity.getCategory() == SearchEntity.Category.Achieve)
            return briefInfo.contains(searchEntity.getKwd());
        else
            return is(searchEntity);
    }
}
