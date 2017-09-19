package com.plugin.awesomejava.UIApp;

import javax.swing.JLabel;

public class DynJLabelObject {

    private JLabel IconJLabel;
    private JLabel TemperatureJLabel;

    public DynJLabelObject() {
    }

    public DynJLabelObject(JLabel IconJLabel, JLabel TemperatureJLabel) {
        this.IconJLabel = IconJLabel;
        this.TemperatureJLabel = TemperatureJLabel;
    }

    public void setIconJLabel(JLabel IconJLabel) {
        this.IconJLabel = IconJLabel;
    }

    public void setTemperatureJLabel(JLabel TemperatureJLabel) {
        this.TemperatureJLabel = TemperatureJLabel;
    }

    public JLabel getIconJLabel() {
        return IconJLabel;
    }

    public JLabel getTemperatureJLabel() {
        return TemperatureJLabel;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
