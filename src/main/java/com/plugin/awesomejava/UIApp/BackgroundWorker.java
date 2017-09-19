package com.plugin.awesomejava.UIApp;

import com.plugin.awesomejava.Forecast.FeedEntry;
import com.plugin.awesomejava.Forecast.ForecastValues;
import com.plugin.awesomejava.Forecast.WeatherHttpRest;
import com.plugin.awesomejava.Location.Error;
import com.plugin.awesomejava.Location.LocationInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javafx.scene.control.Alert;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class BackgroundWorker extends SwingWorker<String, Void> {

    private final FeedEntry entrys;
    private Error ErrorCode;
    private final DynamicJLabelList DynJLabelList;

    private final JLabel CurrentTempLabel;
    private final JLabel DayLambel;
    private final JLabel DescriptionLabel;
    private final JLabel DetailedLabel;
    private final JLabel HumidityLabel;
    private final JLabel PressureJLabel;
    private final JLabel MaxTempLabel;
    private final JLabel MinTempLabel;
    private final JLabel WindLabel;
    private final JLabel WeatherDayIcon;
    private final JLabel RefreshIconLabel;

    public BackgroundWorker(FeedEntry entrys, JLabel CurrentTempLabel, JLabel DayLambel, JLabel DescriptionLabel, JLabel DetailedLabel,
            JLabel HumidityLabel, JLabel MaxTempLabel, JLabel MinTempLabel, JLabel WindLabel) {
        this.entrys = entrys;
        this.CurrentTempLabel = CurrentTempLabel;
        this.DayLambel = DayLambel;
        this.DescriptionLabel = DescriptionLabel;
        this.DetailedLabel = DetailedLabel;
        this.HumidityLabel = HumidityLabel;
        this.MaxTempLabel = MaxTempLabel;
        this.MinTempLabel = MinTempLabel;
        this.WindLabel = WindLabel;
        this.PressureJLabel = null;
        this.DynJLabelList = null;
        this.WeatherDayIcon = null;
        this.RefreshIconLabel = null;
    }

    public BackgroundWorker(FeedEntry entrys, DynamicJLabelList DynJLabelList, JLabel CurrentTempLabel, JLabel DayLambel,
            JLabel DescriptionLabel, JLabel DetailedLabel, JLabel HumidityLabel, JLabel PressureJLabel, JLabel MaxTempLabel,
            JLabel MinTempLabel, JLabel WindLabel, JLabel WeatherDayIcon, JLabel RefreshIconLabel) {
        this.entrys = entrys;
        this.DynJLabelList = DynJLabelList;
        this.CurrentTempLabel = CurrentTempLabel;
        this.DayLambel = DayLambel;
        this.DescriptionLabel = DescriptionLabel;
        this.DetailedLabel = DetailedLabel;
        this.HumidityLabel = HumidityLabel;
        this.PressureJLabel = PressureJLabel;
        this.MaxTempLabel = MaxTempLabel;
        this.MinTempLabel = MinTempLabel;
        this.WindLabel = WindLabel;
        this.WeatherDayIcon = WeatherDayIcon;
        this.RefreshIconLabel = RefreshIconLabel;
    }

    @Override
    protected String doInBackground() throws Exception {
        this.RefreshIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ring.gif")));

        final WeatherHttpRest doRequest = new WeatherHttpRest(entrys, DynJLabelList);

        final HashMap<DynJLabelObject, ForecastValues> ForecastMap = doRequest.HttpRestRequest();
        if (ForecastMap.isEmpty()) {
            ErrorCode = Error.LISTVALUES;
            return "";
        }
        UpdateStatus(ForecastMap);
        return "";
    }

    private void SetForecastValuesForCurrentDay(final ForecastValues ForecastValue) {
        this.CurrentTempLabel.setText(ForecastValue.getDateTemperature());
        this.DayLambel.setText(LocationInfo.DayName());
        this.DescriptionLabel.setText(ForecastValue.getDescription());
        this.DetailedLabel.setText(ForecastValue.getDateInformations());
        this.HumidityLabel.setText(ForecastValue.getHumidity());
        this.PressureJLabel.setText(ForecastValue.getPressure());
        this.WeatherDayIcon.setIcon(ForecastValue.getMainWeatherIcon());
        this.MaxTempLabel.setText(ForecastValue.getMaxTemperature());
        this.MinTempLabel.setText(ForecastValue.getMinTemperature());
        this.WindLabel.setText(ForecastValue.getWind_Speed());
    }

    private void UpdateStatus(final HashMap<DynJLabelObject, ForecastValues> ForecastMap) {

        Set set = ForecastMap.entrySet();
        Iterator iterator2 = set.iterator();
        while (iterator2.hasNext()) {
            final Map.Entry MapEntry = (Map.Entry) iterator2.next();
            final ForecastValues ForecastValue = (ForecastValues) MapEntry.getValue();
            final DynJLabelObject DynLabel = (DynJLabelObject) MapEntry.getKey();

            if (ForecastValue.isCurrentDay()) {
                SetForecastValuesForCurrentDay(ForecastValue);
            }
            DynLabel.getTemperatureJLabel().setText(ForecastValue.getDateTemperature());
            if (ForecastValue.getWeatherIcon() != null) {
                DynLabel.getIconJLabel().setIcon(ForecastValue.getWeatherIcon());
            }
        }
    }

    @Override
    protected void done() {
        if (ErrorCode == Error.LISTVALUES) {
            new JFxBuilder(new DialogObject(Alert.AlertType.ERROR, "Error Dialog", "Ooops, there was an error!",
                    "Something goes wrong. Please check your internet connection first or try again later")).Invoke();
        }
        this.RefreshIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Refresh_15px.png")));
    }
}
