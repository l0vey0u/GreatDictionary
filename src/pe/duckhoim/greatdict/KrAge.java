package pe.duckhoim.greatdict;

public enum KrAge {
    // 후삼국 하나가 만든 혼란
    NoNameAge(0, "이름 없음"),
    GoJoseon(1,"고조선"),
    ThreeKingdoms(2, "삼국"),
    NorthAndSouthStates(3, "남북국"),
    Goryeo(4, "고려"),
    Joseon(5, "조선"),
    Colonial(6, "식민지"),
    SouthKorea(7, "대한민국"),
    LaterThreeKingdoms(8, "후삼국");

    private int order;
    private String ageName;

    KrAge (int order, String ageName) {
        this.order = order;
        this.ageName = ageName;
    }

    public String getAgeName()
    {
        return this.ageName;
    }

}
