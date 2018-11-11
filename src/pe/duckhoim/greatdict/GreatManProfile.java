package pe.duckhoim.greatdict;

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

    public void setProfile(String name, Scanner sc) {
        this.name = name;
        System.out.print("성별 ( 남: M / 여 : F ) : ");
        this.gender = sc.nextLine();
        System.out.println("시대 선택");
        System.out.println("(0) 없음 (1) 고조선 (2) 삼국");
        System.out.println("(3) 남북국 (4) 고려 (5) 조선");
        System.out.println("(6) 식민지 (7) 대한민국 (8) 후삼국");
        System.out.print(">> ");
        this.age = KrAge.values()[sc.nextInt()].getAgeName();
        System.out.println("직업 선택");
        System.out.println("(0) 기타 (1) 왕 (2) 무인 (3) 정치가");
        System.out.println("(4) 예술가 (5) 의사 (6) 종교인");
        System.out.print(">> ");
        this.job = Job.values()[sc.nextInt()].getJobName();
        System.out.print("생년 사망년 >> ");
        this.bth = sc.nextInt();
        this.dth = sc.nextInt();
        sc.nextLine();

    }

    public void printProfile() {
        System.out.format("%s %s %s %s ", name, job, gender, age);
        if (bth < 0)
            System.out.print("BC" + (0 - bth));
        else
            System.out.print(bth);
        System.out.print(" ");
        if (dth < 0)
            System.out.print("BC" + (0 - dth));
        else
            System.out.print(dth);
        System.out.println(" ");
    }

    public void printProfile(SearchEntity searchEntity) {
        if (searchEntity.getCategory() == SearchEntity.Category.Name) {
            System.out.print("이 위인은 ");
        } else
            System.out.print(name + " ");

        if (searchEntity.getCategory() == SearchEntity.Category.Gender) {
            System.out.print("    ");
        } else {
            System.out.format("[%s] ", this.gender);
        }

        if (bth < 0)
            System.out.print("BC" + (0 - bth));
        else
            System.out.print(bth);
        System.out.print(" ~ ");
        if (dth < 0)
            System.out.print("BC" + (0 - dth));
        else
            System.out.print(dth);
        System.out.print(" ");

        if (searchEntity.getCategory() == SearchEntity.Category.Age) {
            System.out.print(this.job + " ");
        } else if (searchEntity.getCategory() == SearchEntity.Category.Job) {
            System.out.print(this.age + " ");
        } else {
            System.out.format("%s / %s ", this.age, this.job);
        }


    }

    public boolean is(SearchEntity searchEntity) {
        if (searchEntity.getCategory() == SearchEntity.Category.Name) {
            if (searchEntity.getKwd().equals(this.name))
                return true;
        }
        if (searchEntity.getCategory() == SearchEntity.Category.Gender) {
            if (searchEntity.getKwd().equals(this.gender))
                return true;
        }
        if (searchEntity.getCategory() == SearchEntity.Category.Job) {
            if (searchEntity.getKwd().equals(this.job))
                return true;
        }
        if (searchEntity.getCategory() == SearchEntity.Category.Age) {
            if (searchEntity.getKwd().equals(this.age))
                return true;
        }
        return false;
    }

    public void edit(SearchEntity.Category category, Scanner sc) {
        if (category == SearchEntity.Category.Name) {
            System.out.print("이름 수정 : ");
            this.name = sc.nextLine();
        } else if (category == SearchEntity.Category.Job) {
            System.out.println("직업 수정");
            System.out.println("(0) 기타 (1) 왕 (2) 무인 (3) 정치가");
            System.out.println("(4) 예술가 (5) 의사 (6) 종교인");
            System.out.print(">> ");
            this.job = Job.values()[sc.nextInt()].getJobName();
        } else if (category == SearchEntity.Category.Gender) {
            System.out.print("성별 ( 남: M / 여 : F ) : ");
            this.gender = sc.nextLine();
        } else if (category == SearchEntity.Category.Age) {
            System.out.println("시대 선택");
            System.out.println("(0) 없음 (1) 고조선 (2) 삼국");
            System.out.println("(3) 남북국 (4) 고려 (5) 조선");
            System.out.println("(6) 식민지 (7) 대한민국 (8) 후삼국");
            System.out.print(">> ");
            this.age = KrAge.values()[sc.nextInt()].getAgeName();
        }
    }

    public String getName() {
        return this.name;
    }

    public abstract void readAchieve(Scanner s);

    public abstract void print();

    public abstract void print(SearchEntity searchEntity);

    public abstract boolean contain(SearchEntity searchEntity);
}
