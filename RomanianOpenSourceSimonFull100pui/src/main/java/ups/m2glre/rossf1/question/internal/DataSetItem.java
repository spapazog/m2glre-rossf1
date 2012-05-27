package ups.m2glre.rossf1.question.internal;

public class DataSetItem {
    private int number;
    private float value;

    public DataSetItem(int number, float value) {
        setNumber(number);
        setValue(value);
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }
}
