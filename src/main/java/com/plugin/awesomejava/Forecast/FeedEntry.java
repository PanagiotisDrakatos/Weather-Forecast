package com.plugin.awesomejava.Forecast;


public class FeedEntry {

    private static final String ApiKey = "305be23140a9d5d08890247143be3227";
    private String Location;
    private String CountryCode;
    private int Days;
    
    public FeedEntry() {
    }

    public FeedEntry(String Location, String CountryCode, int Days) {
        this.Location = Location;
        this.CountryCode = CountryCode;
        this.Days = Days;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }

    public void setDays(int Days) {
        this.Days = Days;
    }

    public int getDays() {
        return Days;
    }

    public String getLocation() {
        return Location;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public String getApiKey() {
        return ApiKey;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
