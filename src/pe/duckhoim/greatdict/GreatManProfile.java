package pe.duckhoim.greatdict;

import java.util.EnumMap;
import java.util.Scanner;

public abstract class GreatManProfile {

    protected String name;
    protected String job;
    protected String gender;
    protected String age;
    protected int bth, dth;

    public void readProfile(Scanner sc) {
        this.name = sc.next();
        this.job = Job.values()[sc.nextInt()].getJobName();
        this.gender = sc.next();
        this.age = KrAge.values()[sc.nextInt()].getAgeName();
        this.bth = sc.nextInt();
        this.dth = sc.nextInt();
    }
    public void printProfile() {
            System.out.format("%s %s %s %s ", name, job, gender, age);
            if(bth < 0)
                System.out.print("BC"+(0-bth));
            else
                System.out.print(bth);
            System.out.print(" ");
            if(dth < 0)
                System.out.print("BC"+(0-dth));
            else
                System.out.print(dth);
            System.out.println(" ");
    }
    public abstract void readAchieve(Scanner s);
    public abstract void print();
}
