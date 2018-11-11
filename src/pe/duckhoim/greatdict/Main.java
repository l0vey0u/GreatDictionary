package pe.duckhoim.greatdict;


public class Main {

    public static void main(String[] args) {
        GreatManProfileController profileCont = new GreatManProfileController();
        ProfileSearchEngine searchEngine = new ProfileSearchEngine();
        searchEngine.setProfileController(profileCont);
        searchEngine.run();
    }
}
