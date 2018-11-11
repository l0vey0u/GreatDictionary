package pe.duckhoim.greatdict;


import java.util.Scanner;
import java.util.function.Predicate;

public class GreatManProfileFactory {
    Predicate<Integer> hasDetailInfo = n -> n == 2;
    public GreatManProfile createProfile(Scanner sc) {
        GreatManProfile greatManProfile = null;
        if(hasDetailInfo.test(Integer.parseInt(sc.next()))) {
            greatManProfile = new FullGreatManProfile();
        }
        else {
            greatManProfile = new SimpleGreatManProfile();
        }        greatManProfile.readProfile(sc);

        greatManProfile.readAchieve(sc);
        return greatManProfile;
    }
}
