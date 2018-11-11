package pe.duckhoim.greatdict;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<GreatManProfile> greatManProfileList = new ArrayList<>();
    private static final String ProfileFileName = "great-inherit-enum.txt";
    private Scanner getFileStream(String fileName)
    {
        Scanner fileStream = null;

        try {
            File f = new File(fileName);
            fileStream = new Scanner(f);
        } catch(FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return fileStream;
    }
    public void loadGreatProfileData() {
        GreatManProfileFactory gmpf = new GreatManProfileFactory();
        Scanner dataStream = getFileStream(ProfileFileName);
        GreatManProfile greatManProfile;
        while(dataStream.hasNext())
        {
            greatManProfile = gmpf.createProfile(dataStream);
            greatManProfileList.add(greatManProfile);
        }
    }
    public void printList() {
        for(GreatManProfile gmp:greatManProfileList)
            gmp.print();
    }
    public static void main(String[] args) {
        Main greatDict = new Main();
	    greatDict.loadGreatProfileData();
	    greatDict.printList();
    }
}
