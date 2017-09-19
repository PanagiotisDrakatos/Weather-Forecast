package com.plugin.awesomejava.UIApp;

import java.awt.*;
import java.io.Serializable;

public class AbsoluteConstraints implements Serializable {

    static final long serialVersionUID = 5261460716622152494L;
    public final int x;
    public final int y;
    private int width = -1;
    private int height = -1;

    public AbsoluteConstraints(Point pos) {
        this(pos.x, pos.y);
    }

    private AbsoluteConstraints(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public AbsoluteConstraints(Point pos, Dimension size) {
        this.x = pos.x;
        this.y = pos.y;
        if (size != null) {
            this.width = size.width;
            this.height = size.height;
        }
    }

    public AbsoluteConstraints(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String toString() {
        return super.toString() + " [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
    }

}