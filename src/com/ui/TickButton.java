package com.ui;

import java.awt.*;
import java.util.ArrayList;

public class TickButton extends UIElement {

    private ArrayList<String> values;
    private int index;
    private boolean TICKED;

    public TickButton(int x, int y) {
        super(x,y);
        values = new ArrayList<>();
        index = 0;
        TICKED = false;
    }

    public void addValue(String val) {
        values.add(val);
    }

    public String currentValue() {
        return values.get(index);
    }

    public int getIndex() {
        return index;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }

}
