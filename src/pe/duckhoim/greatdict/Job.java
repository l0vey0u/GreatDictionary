package pe.duckhoim.greatdict;

public enum Job {
    ETC(0, "기타"),
    King(1, "왕"),
    Soldier(2, "무인"),
    Politician(3, "정치가"),
    Artist(4, "예술가"),
    Doctor(5, "의사"),
    Religious(6, "종교인");

    private int order;
    private String jobName;

    Job(int order, String jobName) {
        this.order = order;
        this.jobName = jobName;
    }

    public String getJobName() {
        return this.jobName;
    }
}
