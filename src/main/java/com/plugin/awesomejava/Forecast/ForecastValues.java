package com.plugin.awesomejava.Forecast;

import java.util.Date;
import javax.swing.ImageIcon;

public class ForecastValues {

    private String DateInformations;
    private String MaxTemperature;
    private String MinTemperature;

    private String Datetemperature;
    private Date DayofWeek;
    private ImageIcon MainWeatherIcon;
    private ImageIcon WeatherIcon;
    private boolean CurrentDay = false;

    private String Description;
    private String Humidity;
    private String Pressure;
    private String Clouds;
    private String Wind_Speed;

    public ForecastValues() {
    }

    public ForecastValues(String DateInformations, String DateTemperature, String Humidity,
            String Pressure, String Clouds, String Wind_Speed) {
        this.DateInformations = DateInformations;
        this.Datetemperature = DateTemperature;
        this.Humidity = Humidity;
        this.Pressure = Pressure;
        this.Clouds = Clouds;
        this.Wind_Speed = Wind_Speed;
    }

    public ForecastValues(String DateInformations, String Datetemperature, String MaxTemperature,
            String MinTemperature, String Humidity, String Pressure, String Clouds, String Wind_Speed) {
        this.DateInformations = DateInformations;
        this.Datetemperature = Datetemperature;
        this.MaxTemperature = MaxTemperature;
        this.MinTemperature = MinTemperature;
        this.Humidity = Humidity;
        this.Pressure = Pressure;
        this.Clouds = Clouds;
        this.Wind_Speed = Wind_Speed;
    }

    public ForecastValues(String DateInformations, String Datetemperature, String MaxTemperature, String MinTemperature,
            String Description, String Humidity, String Pressure, String Clouds, String Wind_Speed) {
        this.DateInformations = DateInformations;
        this.Datetemperature = Datetemperature;
        this.MaxTemperature = MaxTemperature;
        this.MinTemperature = MinTemperature;
        this.Description = Description;
        this.Humidity = Humidity;
        this.Pressure = Pressure;
        this.Clouds = Clouds;
        this.Wind_Speed = Wind_Speed;
    }

    public ForecastValues(String DateInformations, String MaxTemperature, String MinTemperature, String Datetemperature, Date DayofWeek,
            ImageIcon WeatherIcon, String Description, String Humidity, String Pressure, String Clouds, String Wind_Speed) {
        this.DateInformations = DateInformations;
        this.MaxTemperature = MaxTemperature;
        this.MinTemperature = MinTemperature;
        this.Datetemperature = Datetemperature;
        this.DayofWeek = DayofWeek;
        this.WeatherIcon = WeatherIcon;
        this.Description = Description;
        this.Humidity = Humidity;
        this.Pressure = Pressure;
        this.Clouds = Clouds;
        this.Wind_Speed = Wind_Speed;
    }

    public void setDateInformations(String DateInformations) {
        this.DateInformations = DateInformations;
    }

    public void setClouds(String Clouds) {
        this.Clouds = Clouds;
    }

    public void setPressure(String Pressure) {
        this.Pressure = Pressure;
    }

    public void setHumidity(String Humidity) {
        this.Humidity = Humidity;
    }

    public void setMinTemperature(String MinTemperature) {
        this.MinTemperature = MinTemperature;
    }

    public void setMaxTemperature(String MaxTemperature) {
        this.MaxTemperature = MaxTemperature;
    }

    public void setDateTemperature(String DateTemperature) {
        this.Datetemperature = DateTemperature;
    }

    public void setWind_Speed(String Wind_Speed) {
        this.Wind_Speed = Wind_Speed;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setCurrentDay(boolean CurrentDay) {
        this.CurrentDay = CurrentDay;
    }

    public void setWeatherIcon(ImageIcon WeatherIcon) {
        this.WeatherIcon = WeatherIcon;
    }

    public void setDayofWeek(Date DayofWeek) {
        this.DayofWeek = DayofWeek;
    }

    public void setMainWeatherIcon(ImageIcon MainWeatherIcon) {
        this.MainWeatherIcon = MainWeatherIcon;
    }

    public ImageIcon getMainWeatherIcon() {
        return MainWeatherIcon;
    }

    public String getWind_Speed() {
        return Wind_Speed;
    }

    public String getDateTemperature() {
        return Datetemperature;
    }

    public String getPressure() {
        return Pressure;
    }

    public String getHumidity() {
        return Humidity;
    }

    public String getClouds() {
        return Clouds;
    }

    public String getDateInformations() {
        return DateInformations;
    }

    public String getMaxTemperature() {
        return MaxTemperature;
    }

    public String getMinTemperature() {
        return MinTemperature;
    }

    public String getDescription() {
        return Description;
    }

    public Date getDayofWeek() {
        return DayofWeek;
    }

    public ImageIcon getWeatherIcon() {
        return WeatherIcon;
    }

    public boolean isCurrentDay() {
        return CurrentDay;
    }

    @Override
    public String toString() {
        return DateInformations + " ,"
                + Datetemperature + " ,"
                + MaxTemperature + " ,"
                + MinTemperature + " ,"
                + Description + " ,"
                + Humidity + " ,"
                + Pressure + " ,"
                + Clouds + " ,"
                + Wind_Speed + " ,";
    }

}
