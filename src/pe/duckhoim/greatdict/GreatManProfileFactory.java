package pe.duckhoim.greatdict;

import java.util.Scanner;

public class GreatManProfileFactory {
    private Scanner sc;

    public GreatManProfileFactory(Scanner sc) {
        this.sc = sc;
    }

    public GreatManProfile createProfile() {
        GreatManProfile greatManProfile;
        if (sc.nextInt() == 2) {
            greatManProfile = new FullGreatManProfile();
        } else {
            greatManProfile = new SimpleGreatManProfile();
        }
        greatManProfile.readProfile(sc);

        greatManProfile.readAchieve(sc);
        return greatManProfile;
    }

    public GreatManProfile createProfile(String name) {
        GreatManProfile greatManProfile = new SimpleGreatManProfile();
        greatManProfile.setProfile(name, sc);
        System.out.print("업적 : ");
        greatManProfile.readAchieve(sc);
        return greatManProfile;
    }

    public void editProfile(GreatManProfile profile) {
        int sel;
        while (true) {
            System.out.println("수정할 카테고리 선택");
            System.out.println("(0) 이름 (1) 직업 (2) 성별 (3) 시대");
            System.out.println("(5) 더이상 수정할 내용 없음");
            System.out.print(">> ");
            sel = sc.nextInt();
            if (sel == 5) {
                sc.nextLine();
                break;
            }
            profile.edit(SearchEntity.Category.values()[sel], sc);
            profile.print();
            System.out.println();
        }
    }
}
