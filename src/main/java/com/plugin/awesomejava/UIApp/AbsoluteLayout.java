package com.plugin.awesomejava.UIApp;

import java.awt.*;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;


public class AbsoluteLayout
        implements LayoutManager2, Serializable {

    static final long serialVersionUID = -1919857869177070440L;


    @Override
    public void addLayoutComponent(String name, Component comp) {
        throw new IllegalArgumentException();
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        constraints.remove(comp);
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        int maxWidth = 0;
        int maxHeight = 0;
        for (Enumeration e = constraints.keys(); e.hasMoreElements(); ) {
            Component comp = (Component) e.nextElement();
            AbsoluteConstraints ac = (AbsoluteConstraints) constraints.get(comp);
            Dimension size = comp.getPreferredSize();

            int width = ac.getWidth();
            if (width == -1) {
                width = size.width;
            }
            int height = ac.getHeight();
            if (height == -1) {
                height = size.height;
            }

            if (ac.x + width > maxWidth) {
                maxWidth = ac.x + width;
            }
            if (ac.y + height > maxHeight) {
                maxHeight = ac.y + height;
            }
        }
        return new Dimension(maxWidth, maxHeight);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        int maxWidth = 0;
        int maxHeight = 0;
        for (Enumeration e = constraints.keys(); e.hasMoreElements(); ) {
            Component comp = (Component) e.nextElement();
            AbsoluteConstraints ac = (AbsoluteConstraints) constraints.get(comp);

            Dimension size = comp.getMinimumSize();

            int width = ac.getWidth();
            if (width == -1) {
                width = size.width;
            }
            int height = ac.getHeight();
            if (height == -1) {
                height = size.height;
            }

            if (ac.x + width > maxWidth) {
                maxWidth = ac.x + width;
            }
            if (ac.y + height > maxHeight) {
                maxHeight = ac.y + height;
            }
        }
        return new Dimension(maxWidth, maxHeight);
    }


    @Override
    public void layoutContainer(Container parent) {
        for (Enumeration e = constraints.keys(); e.hasMoreElements(); ) {
            Component comp = (Component) e.nextElement();
            AbsoluteConstraints ac = (AbsoluteConstraints) constraints.get(comp);
            Dimension size = comp.getPreferredSize();
            int width = ac.getWidth();
            if (width == -1) {
                width = size.width;
            }
            int height = ac.getHeight();
            if (height == -1) {
                height = size.height;
            }

            comp.setBounds(ac.x, ac.y, width, height);
        }
    }


    @Override
    public void addLayoutComponent(Component comp, Object constr) {
        if (!(constr instanceof AbsoluteConstraints)) {
            throw new IllegalArgumentException();
        }
        constraints.put(comp, constr);
    }


    @Override
    public Dimension maximumLayoutSize(Container target) {
        return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }


    @Override
    public float getLayoutAlignmentX(Container target) {
        return 0;
    }


    @Override
    public float getLayoutAlignmentY(Container target) {
        return 0;
    }


    @Override
    public void invalidateLayout(Container target) {
    }

    private final Hashtable constraints = new Hashtable();
}
