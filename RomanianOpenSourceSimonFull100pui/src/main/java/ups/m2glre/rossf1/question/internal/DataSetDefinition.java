package ups.m2glre.rossf1.question.internal;

import java.util.ArrayList;
import java.util.List;


public class DataSetDefinition {
    private String status;
    private String name;
    private String type; // change to enum
    private String distribution;
    private float minimum;
    private float maximum;
    private int decimals;
    private int itemCount = 0;
    private List<DataSetItem> items = new ArrayList<DataSetItem>();

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDistribution() {
        return distribution;
    }
    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }
    public float getMinimum() {
        return minimum;
    }
    public void setMinimum(float minimum) {
        this.minimum = minimum;
    }
    public float getMaximum() {
        return maximum;
    }
    public void setMaximum(float maximum) {
        this.maximum = maximum;
    }
    public int getDecimals() {
        return decimals;
    }
    public void setDecimals(int decimals) {
        this.decimals = decimals;
    }
    public int getItemCount() {
        return itemCount;
    }
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
    public List<DataSetItem> getItems() {
        return items;
    }
    public void addItem(DataSetItem item) {
        itemCount++;
        items.add(item);
    }
    public void setItem(List<DataSetItem> items) {
        setItemCount(items.size());
        this.items = items;
    }
}
