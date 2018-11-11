package pe.duckhoim.greatdict;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.function.Predicate;

public class GreatManProfileFactory {
    Predicate<Integer> hasDetailInfo = n -> n == 2;
    public GreatManProfile createProfile(Scanner sc) {
        GreatManProfile greatManProfile = null;
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