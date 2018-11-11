package pe.duckhoim.greatdict;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GreatManProfileController {
    private static final String END_SIG = "end";
    private ArrayList<GreatManProfile> greatManProfileList = new ArrayList<>();
    private HashMap<String, GreatManProfile> nameMap = new HashMap<>();
    private static final String ProfileFileName = "great-inherit-enum.txt";
    private GreatManProfileFactory gmpf;
    private Scanner sc = new Scanner(System.in);

    public GreatManProfileController() {
        this.loadGreatProfileData();
    }

    private Scanner getFileStream(String fileName) {
        Scanner fileStream;

        try {
            File f = new File(fileName);
            fileStream = new Scanner(f, "UTF8");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return fileStream;
    }

    private void loadGreatProfileData() {
        Scanner dataStream = getFileStream(ProfileFileName);
        gmpf = new GreatManProfileFactory(dataStream);
        GreatManProfile greatManProfile;
        while (dataStream.hasNext()) {
            greatManProfile = gmpf.createProfile();
            greatManProfileList.add(greatManProfile);
            nameMap.put(greatManProfile.getName(), greatManProfile);
        }
        dataStream.close();
    }

    public boolean alreadyExist(String name) {
        for (String key : nameMap.keySet()) {
            if (key.equals(name)) return true;
        }
        return false;
    }

    public void addProfile() {
        gmpf = new GreatManProfileFactory(sc);
        String name;
        GreatManProfile greatManProfile;
        System.out.print("추가할 위인 : ");
        while (!(name = sc.nextLine()).equals(END_SIG)) {
            if (alreadyExist(name)) {
                System.out.println("이미 존재하는 위인입니다. 수정페이지로 이동합니다.");
                gmpf.editProfile(nameMap.get(name));
            } else {
                greatManProfile = gmpf.createProfile(name);
                greatManProfile.print();
                System.out.println();
                System.out.print("저장하시겠습니까? ( Y / N ) >> ");
                if (sc.nextLine().equals("Y")) {
                    greatManProfileList.add(greatManProfile);
                    nameMap.put(greatManProfile.getName(), greatManProfile);
                }

            }
            System.out.print("추가할 위인 : ");
        }
        sc.close();
    }

    public ArrayList<GreatManProfile> getGreatManProfileList() {
        return greatManProfileList;
    }

    public HashMap<String, GreatManProfile> getNameMap() {
        return nameMap;
    }


}
