package pe.duckhoim.greatdict;

import java.util.HashMap;

public class SearchEntity {
    private static GreatManProfileController profileCont;
    private static HashMap<String, GreatManProfile> cacheNameMap = null;

    public enum Category {
        Name("이름"), Job("직업"), Gender("성별"), Age("시대"), Achieve("업적");
        private String name;

        Category(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private Category category;
    private String kwd;

    private SearchEntity(Category category, String kwd) {
        this.category = category;
        this.kwd = kwd;
    }

    public Category getCategory() {
        return this.category;
    }

    public String getKwd() {
        return this.kwd;
    }

    public static void setProfileCont(GreatManProfileController profileCont) {
        SearchEntity.profileCont = profileCont;
    }

    public static SearchEntity parseKeyword(String kwd) {
        if (cacheNameMap == null)
            cacheNameMap = profileCont.getNameMap();
        for (String name : cacheNameMap.keySet()) {
            if (name.equals(kwd))
                return new SearchEntity(Category.Name, kwd);
        }
        if (kwd.equals("M") || kwd.equals("F")) {
            return new SearchEntity(Category.Gender, kwd);
        }
        for (Job job : Job.values()) {
            if (job.getJobName().equals(kwd))
                return new SearchEntity(Category.Job, kwd);
        }
        for (KrAge age : KrAge.values()) {
            if (age.getAgeName().equals(kwd))
                return new SearchEntity(Category.Age, kwd);
        }
        return new SearchEntity(Category.Achieve, kwd);
    }
}
