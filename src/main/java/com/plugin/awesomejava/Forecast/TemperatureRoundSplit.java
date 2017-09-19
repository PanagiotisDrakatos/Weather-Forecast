package com.plugin.awesomejava.Forecast;

public class TemperatureRoundSplit {

    public static String SplitStringValue(final Double DoubleInputValue) {
        String StringValue = String.valueOf(DoubleInputValue);
        if (StringValue.contains(".")) {
            StringValue = StringValue.substring(0, StringValue.lastIndexOf("."));
            return StringValue;
        } else {
            return StringValue;
        }

    }
    
    public static String SplitStringValue(final float DoubleInputValue) {
        String StringValue = String.valueOf(DoubleInputValue);
        if (StringValue.contains(".")) {
            StringValue = StringValue.substring(0, StringValue.lastIndexOf("."));
            return StringValue;
        } else {
            return StringValue;
        }

    }
}
