package com.plugin.awesomejava.Forecast;

import com.plugin.awesomejava.Location.LocationInfo;
import java.util.ArrayList;
import net.aksingh.owmjapis.DailyForecast;
import net.aksingh.owmjapis.OpenWeatherMap;
import com.plugin.awesomejava.UIApp.DynJLabelObject;
import com.plugin.awesomejava.UIApp.DynamicJLabelList;
import java.util.HashMap;
import javax.swing.ImageIcon;

public class WeatherHttpRest {

    private static final String DEGREE = "\u00b0";

    private final FeedEntry entry;
    private final WeatherImp weather;
    private ForecastValues forecastValue;

    private HashMap<DynJLabelObject, ForecastValues> WeatherMaphm;
    
    private boolean isMetric;

    public WeatherHttpRest(FeedEntry entry, final DynamicJLabelList DynJLabelList, boolean isMetric) {
        this.entry = entry;
        this.weather = new WeatherImp(DynJLabelList);
        WeatherMaphm = new HashMap<DynJLabelObject, ForecastValues>();
        this.isMetric = isMetric;
    }

    public HashMap<DynJLabelObject, ForecastValues> HttpRestRequest() {

        final ArrayList<ForecastValues> list = new ArrayList<ForecastValues>();
        final OpenWeatherMap.Units units = (isMetric) ? OpenWeatherMap.Units.METRIC : OpenWeatherMap.Units.IMPERIAL;
        final OpenWeatherMap owm = new OpenWeatherMap(units, entry.getApiKey());

        final byte forecastDays = Byte.valueOf(String.valueOf(entry.getDays()));
        try {

            final DailyForecast forecast = owm.dailyForecastByCityName(entry.getLocation(), entry.getCountryCode(), forecastDays);

            System.out.println("Raw Response: " + forecast.getRawResponse());
            int numForecasts = forecast.getForecastCount();
            for (int i = 0; i < numForecasts; i++) {
                final DailyForecast.Forecast dayForecast = forecast.getForecastInstance(i);

                IntializeForecastValues(forecast.getForecastInstance(i),
                        dayForecast.getTemperatureInstance(),
                        dayForecast.getWeatherInstance(0));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            WeatherMaphm.clear();
        }
        return WeatherMaphm;//epistrofi listas
    }

    private void IntializeForecastValues(final DailyForecast.Forecast dayForecast,
            final DailyForecast.Forecast.Temperature temperature,
            final DailyForecast.Forecast.Weather weather) {
    	String temperatureUnit = (isMetric) ? "C" : "F";
    	String windSpeedUnit = (isMetric) ? "m/s" : "mph";
    	
        forecastValue = new ForecastValues();

        forecastValue.setDateInformations("Last Updated: " + String.valueOf(dayForecast.getDateTime()));

        forecastValue.setMinTemperature(TemperatureRoundSplit.SplitStringValue(temperature.getMinimumTemperature()) + DEGREE + temperatureUnit);
        forecastValue.setMaxTemperature(TemperatureRoundSplit.SplitStringValue(temperature.getMaximumTemperature()) + DEGREE + temperatureUnit);
        forecastValue.setDateTemperature(TemperatureRoundSplit.SplitStringValue(temperature.getDayTemperature()) + DEGREE + temperatureUnit);

        forecastValue.setHumidity("Humidity: " + String.valueOf(dayForecast.getHumidity()) + "%");
        forecastValue.setPressure("Pressure: " + String.valueOf(dayForecast.getPressure()) + " mbar ");
        forecastValue.setClouds(String.valueOf(dayForecast.getPercentageOfClouds()) + "%");
        forecastValue.setWind_Speed("Wind Speed : " + String.valueOf(dayForecast.getWindSpeed()) + windSpeedUnit);
        forecastValue.setDescription(weather.getWeatherDescription());
        forecastValue.setDayofWeek(dayForecast.getDateTime());

        this.weather.setForecastValue(forecastValue);
        final int day = this.weather.GetDayCode();

        if (day == LocationInfo.DayCode()) {
            forecastValue.setCurrentDay(true);
            forecastValue.setMainWeatherIcon(this.weather
                    .WeatherIcon(forecastValue.getDescription(), true));
        }

        ImageIcon WeatherIcon = this.weather.WeatherIcon(forecastValue.getDescription());
        forecastValue.setWeatherIcon(WeatherIcon);

        PutMapValues(this.weather.DayOfWeekWeather(day));

        System.out.println(weather.getWeatherDescription());
        System.out.println(forecastValue.toString());
    }

    private void PutMapValues(final DynJLabelObject labelObj) {
        WeatherMaphm.put(labelObj, forecastValue);
    }

}
