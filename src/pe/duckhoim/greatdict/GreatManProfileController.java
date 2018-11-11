package pe.duckhoim.greatdict;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GreatManProfileController {
    private ArrayList<GreatManProfile> greatManProfileList = new ArrayList<>();
    private HashMap<String, GreatManProfile> nameMap = new HashMap<>();
    private static final String ProfileFileName = "great-inherit-enum.txt";

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
        GreatManProfileFactory gmpf = new GreatManProfileFactory();
        Scanner dataStream = getFileStream(ProfileFileName);
        GreatManProfile greatManProfile;
        while (dataStream.hasNext()) {
            greatManProfile = gmpf.createProfile(dataStream);
            greatManProfileList.add(greatManProfile);
            nameMap.put(greatManProfile.getName(), greatManProfile);
        }
        dataStream.close();
    }

    public ArrayList<GreatManProfile> getGreatManProfileList() {
        return greatManProfileList;
    }

    public HashMap<String, GreatManProfile> getNameMap() {
        return nameMap;
    }
}
