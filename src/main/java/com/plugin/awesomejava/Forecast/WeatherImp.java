package com.plugin.awesomejava.Forecast;


import com.plugin.awesomejava.UIApp.DynJLabelObject;
import com.plugin.awesomejava.UIApp.DynamicJLabelList;
import java.util.Calendar;
import com.plugin.awesomejava.Location.Error;
import javax.swing.ImageIcon;

public class WeatherImp {

    private ForecastValues forecastValue;
    private final DynamicJLabelList DynJLabelList;
    private DynJLabelObject LabeslObj;

    public WeatherImp(final DynamicJLabelList DynJLabelList) {
        this.DynJLabelList = DynJLabelList;
    }

    public DynJLabelObject DayOfWeekWeather(final int day) {
        switch (day) {
            case DayOfWeekCodes.SUNDAY:
                LabeslObj = new DynJLabelObject(this.DynJLabelList.getDayOfWeekyIcons().get(0),
                        this.DynJLabelList.getDayOfWeekTemperature().get(0));
                break;
            case DayOfWeekCodes.MONDAY:
                LabeslObj = new DynJLabelObject(this.DynJLabelList.getDayOfWeekyIcons().get(1),
                        this.DynJLabelList.getDayOfWeekTemperature().get(1));
                break;
            case DayOfWeekCodes.TUESDAY:
                LabeslObj = new DynJLabelObject(this.DynJLabelList.getDayOfWeekyIcons().get(2),
                        this.DynJLabelList.getDayOfWeekTemperature().get(2));
                break;
            case DayOfWeekCodes.WEDNESDAY:
                LabeslObj = new DynJLabelObject(this.DynJLabelList.getDayOfWeekyIcons().get(3),
                        this.DynJLabelList.getDayOfWeekTemperature().get(3));
                break;
            case DayOfWeekCodes.THURSDAY:
                LabeslObj = new DynJLabelObject(this.DynJLabelList.getDayOfWeekyIcons().get(4),
                        this.DynJLabelList.getDayOfWeekTemperature().get(4));

                break;
            case DayOfWeekCodes.FRIDAY:
                LabeslObj = new DynJLabelObject(this.DynJLabelList.getDayOfWeekyIcons().get(5),
                        this.DynJLabelList.getDayOfWeekTemperature().get(5));
                break;
            case DayOfWeekCodes.SATURDAY:
                LabeslObj = new DynJLabelObject(this.DynJLabelList.getDayOfWeekyIcons().get(6),
                        this.DynJLabelList.getDayOfWeekTemperature().get(6));
                break;
            default:
                System.out.println(com.plugin.awesomejava.Location.Error.DATE_EROR.getDescription());
                break;
        }
        if (LabeslObj == null) {
            System.out.println(Error.NULL_OBJECT.getDescription());
        }
        return LabeslObj;
    }

    public int GetDayCode() {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(forecastValue.getDayofWeek());
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public ImageIcon WeatherIcon(final String dscription) {
        if (dscription.contains(WeatherDescription.Clouds)) {
            return new ImageIcon(getClass().getResource(WeatherDescription.CloudIcon64PX));
        } else if (dscription.contains(WeatherDescription.Rain)) {
            return new ImageIcon(getClass().getResource(WeatherDescription.RainIcon64PX));
        } else if (dscription.contains(WeatherDescription.Snow)) {
            return new ImageIcon(getClass().getResource(WeatherDescription.SnowIcon64PX));
        } else if (dscription.contains(WeatherDescription.Clear)) {
            return new ImageIcon(getClass().getResource(WeatherDescription.SunIcon64PX));
        } else {
            return null;
        }
    }

    public ImageIcon WeatherIcon(final String dscription, boolean flag) {
        if (dscription.contains(WeatherDescription.Clouds)) {
            return new ImageIcon(getClass().getResource(WeatherDescription.CloudIcon100PX));
        } else if (dscription.contains(WeatherDescription.Rain)) {
            return new ImageIcon(getClass().getResource(WeatherDescription.RainIcon100PX));
        } else if (dscription.contains(WeatherDescription.Snow)) {
            return new ImageIcon(getClass().getResource(WeatherDescription.SnowIcon100PX));
        } else if (dscription.contains(WeatherDescription.Clear)) {
            return new ImageIcon(getClass().getResource(WeatherDescription.SunIcon100PX));
        } else {
            return null;
        }
    }

    public ForecastValues getForecastValue() {
        return forecastValue;
    }

    public void setForecastValue(ForecastValues forecastValue) {
        this.forecastValue = forecastValue;
    }

}
