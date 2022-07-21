package generics.fruits;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> boxList;

    public Box() {
        this.boxList = new ArrayList<>();
    }

    public Box(List<T> list) {
        this.boxList = new ArrayList<>(list);
    }

    public float getWeight() {
        float weight = 0;
        for (T t : boxList) {
            weight += t.weight;
        }
        return weight;
    }

    public boolean compare(Box<?> box) {
        return Math.abs(getWeight() - box.getWeight()) < 0.0001f;
    }

    public void add(T t) {
        boxList.add(t);
    }

    public void addAll(List<T> list) {
        this.boxList.addAll(list);
    }

    public void transferToBox(Box<T> box) {
        if (this == box) return;
        box.boxList.addAll(this.boxList);
        this.boxList.clear();
    }

    @Override
    public String toString() {
        return boxList.toString();
    }
}