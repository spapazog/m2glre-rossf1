package ups.m2glre.rossf1.question.internal;

public class Unit {
    int multiplier;
    String unitName;

    public Unit(int multiplier, String unitName) {
        setMultiplier(multiplier);
        setUnitName(unitName);
    }

    public int getMultiplier() {
        return multiplier;
    }
    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
    public String getUnitName() {
        return unitName;
    }
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

}
