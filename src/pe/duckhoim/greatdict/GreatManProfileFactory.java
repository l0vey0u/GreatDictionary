package pe.duckhoim.greatdict;


import java.util.Scanner;
import java.util.function.Predicate;

public class GreatManProfileFactory {
    Predicate<Integer> hasDetailInfo = n -> n == 2;
    public GreatManProfile createProfile(Scanner sc) {
        GreatManProfile greatManProfile;
        if(hasDetailInfo.test(sc.nextInt())) {
            greatManProfile = new FullGreatManProfile();
        }
        else {
            greatManProfile = new SimpleGreatManProfile();
        }        greatManProfile.readProfile(sc);

        greatManProfile.readAchieve(sc);
        return greatManProfile;
    }
}
