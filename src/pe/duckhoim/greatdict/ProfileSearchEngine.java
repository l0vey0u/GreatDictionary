package pe.duckhoim.greatdict;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProfileSearchEngine {
    private static final String END_SIG = "end";
    private GreatManProfileController profileCont;
    private Scanner sc = new Scanner(System.in);
    ArrayList<GreatManProfile> cacheAllProfileList = null;

    private void print(SearchEntity searchEntity, List<GreatManProfile> searchRes) {
        if (!searchRes.isEmpty()) {
            System.out.format("[카테고리 : %s]%n", searchEntity.getCategory().getName());
            for (GreatManProfile profile : searchRes) {
                profile.print(searchEntity);
                System.out.println();
            }
        } else {
            System.out.println("Your search returned no matches.");
        }
    }

    public void run() {
        if (cacheAllProfileList == null)
            cacheAllProfileList = profileCont.getGreatManProfileList();

        String kwd;
        System.out.print("# ");
        while (!((kwd = sc.nextLine()).equals(END_SIG))) {

            SearchEntity.setProfileCont(profileCont);
            SearchEntity searchEntity = SearchEntity.parseKeyword(kwd);

            List<GreatManProfile> searchRes = cacheAllProfileList.stream()
                    .filter(gpf -> gpf.contain(searchEntity))
                    .collect(Collectors.toList());

            print(searchEntity, searchRes);

            System.out.print("# ");
        }
    }

    public void setProfileController(GreatManProfileController profileCont) {
        this.profileCont = profileCont;
    }
}
