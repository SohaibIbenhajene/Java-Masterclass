package dev.sohaib;

import java.util.ArrayList;
import java.util.List;

public class Layer <T extends Mappable> {
    private List<T> elements;

    public Layer(T[] elements) {
        this.elements = new ArrayList<>(List.of(elements));
    }

    public void addElements(T... elements) {
        this.elements.addAll(List.of(elements));
    }

    public void renderLayer() {
        for (T t: elements) {
            t.render();
        }
    }
}
