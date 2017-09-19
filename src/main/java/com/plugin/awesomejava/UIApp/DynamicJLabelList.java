package com.plugin.awesomejava.UIApp;

import java.util.ArrayList;
import javax.swing.JLabel;

public class DynamicJLabelList {

    private ArrayList<JLabel> DayOfWeekTemperature;
    private ArrayList<JLabel> DayOfWeekyIcons;

    public DynamicJLabelList() {
        this.DayOfWeekTemperature = new ArrayList<JLabel>();
        this.DayOfWeekyIcons = new ArrayList<JLabel>();
    }

    public DynamicJLabelList(ArrayList<JLabel> DayOfWeekTemperature, ArrayList<JLabel> DayOfWeekyIcons) {
        this.DayOfWeekTemperature = DayOfWeekTemperature;
        this.DayOfWeekyIcons = DayOfWeekyIcons;
    }

    public DynamicJLabelList(ArrayList<JLabel> DayOfWeekyIcons) {
        this.DayOfWeekyIcons = DayOfWeekyIcons;
    }

    public void setDayOfWeekTemperature(ArrayList<JLabel> DayOfWeekTemperature) {
        this.DayOfWeekTemperature = DayOfWeekTemperature;
    }

    public void setDayOfWeekyIcons(ArrayList<JLabel> DayOfWeekyIcons) {
        this.DayOfWeekyIcons = DayOfWeekyIcons;
    }

    public void AddDayOfWeekTemperature(JLabel DynLabel) {
        this.DayOfWeekTemperature.add(DynLabel);
    }

    public void AddDayOfWeekyIcons(JLabel DynLabel) {
        this.DayOfWeekyIcons.add(DynLabel);
    }

    public ArrayList<JLabel> getDayOfWeekTemperature() {
        return DayOfWeekTemperature;
    }

    public ArrayList<JLabel> getDayOfWeekyIcons() {
        return DayOfWeekyIcons;
    }

}
