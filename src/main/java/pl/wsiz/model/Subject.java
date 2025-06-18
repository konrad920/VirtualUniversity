package pl.wsiz.model;

public class Subject {
    private String name;
    private int ectsPoints;

    public Subject(String name, int ectsPoints) {
        this.name = name;
        this.ectsPoints = ectsPoints;
    }

    public Subject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEctsPoints() {
        return ectsPoints;
    }

    public void setEctsPoints(int ectsPoints) {
        this.ectsPoints = ectsPoints;
    }
}
