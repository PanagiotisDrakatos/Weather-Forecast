package com.plugin.awesomejava.UIApp;

import com.plugin.awesomejava.Forecast.FeedEntry;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.scene.control.Alert;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class MainWeatherFrame extends javax.swing.JFrame {

    private JLabel CurrentTempLabel;
    private JLabel DayLambel;
    private JLabel DescriptionLabel;
    private JLabel DetailedLabel;
    private JLabel FRIIconJLabel;
    private JLabel FRITempJLabel;
    private JLabel HumidityLabel;
    private JLabel LocationLabel;
    private JLabel MONIconJLabel;
    private JLabel MONTempJLabel;
    private JLabel MaxTempLabel;
    private JLabel MinTempLabel;
    private JLabel PressureJLabel;
    private JLabel RefreshIconLabel;
    private JLabel SATIconJLabel;
    private JLabel SATTempJLabel;
    private JLabel SUNIconJLabel;
    private JLabel SUNTempJLabel;
    private JLabel THUIconJLabel;
    private JLabel THUTempJLabel;
    private JLabel TUEIconJLabel;
    private JLabel TUETempJLabel;
    private JLabel WEDIconJLabel;
    private JLabel WEDTempJLabel;
    private JLabel WeatherDayIcon;
    private JLabel WindLabel;
    private JLabel jLabel1;
    private JLabel jLabel11;
    private JLabel jLabel13;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel29;
    private JLabel jLabel37;
    private JLabel jLabel38;
    private JLabel jLabel39;
    private JLabel jLabel4;
    private JLabel jLabel40;
    private JLabel jLabel41;
    private JLabel jLabel42;
    private JLabel jLabel45;
    private JLabel jLabel6;
    private JPanel jPanel2;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JSeparator jSeparator5;
    
    private int xMouse, yMouse;
    private static final int delay = 30000;
    private Timer timer = null;
    private DynamicJLabelList DynJLabelList;
    private final FeedEntry entry;

    public MainWeatherFrame(FeedEntry entry) {
        this.entry = entry;
        initComponents();
        InitTimer();
        Init();
        LocationLabel.setText(entry.getLocation() + "," + entry.getCountryCode());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
     private void initComponents() {

        jSeparator4 = new JSeparator();
        jPanel2 = new JPanel();
        jLabel4 = new JLabel();
        PressureJLabel = new JLabel();
        jSeparator5 = new JSeparator();
        jSeparator3 = new JSeparator();
        jLabel45 = new JLabel();
        WeatherDayIcon = new JLabel();
        jSeparator2 = new JSeparator();
        DayLambel = new JLabel();
        CurrentTempLabel = new JLabel();
        jSeparator1 = new JSeparator();
        jLabel42 = new JLabel();
        jLabel41 = new JLabel();
        jLabel40 = new JLabel();
        jLabel39 = new JLabel();
        jLabel38 = new JLabel();
        jLabel37 = new JLabel();
        MONTempJLabel = new JLabel();
        TUETempJLabel = new JLabel();
        WEDTempJLabel = new JLabel();
        THUTempJLabel = new JLabel();
        FRITempJLabel = new JLabel();
        SATTempJLabel = new JLabel();
        SUNTempJLabel = new JLabel();
        jLabel29 = new JLabel();
        MONIconJLabel = new JLabel();
        TUEIconJLabel = new JLabel();
        WEDIconJLabel = new JLabel();
        THUIconJLabel = new JLabel();
        SUNIconJLabel = new JLabel();
        SATIconJLabel = new JLabel();
        FRIIconJLabel = new JLabel();
        jLabel21 = new JLabel();
        jLabel20 = new JLabel();
        jLabel19 = new JLabel();
        jLabel18 = new JLabel();
        DescriptionLabel = new JLabel();
        jLabel16 = new JLabel();
        jLabel15 = new JLabel();
        MaxTempLabel = new JLabel();
        jLabel13 = new JLabel();
        MinTempLabel = new JLabel();
        jLabel11 = new JLabel();
        DetailedLabel = new JLabel();
        WindLabel = new JLabel();
        HumidityLabel = new JLabel();
        LocationLabel = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        RefreshIconLabel = new JLabel();
        jLabel6 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new AbsoluteLayout());

        jPanel2.setBackground(new Color(255, 255, 255));
        jPanel2.setLayout(new AbsoluteLayout());

        jLabel4.setIcon(new ImageIcon(getClass().getResource("/Atmospheric Pressure-44 (1).png"))); // NOI18N
        jPanel2.add(jLabel4, new AbsoluteConstraints(10, 150, -1, 40));

        PressureJLabel.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        PressureJLabel.setForeground(new Color(255, 255, 255));
        PressureJLabel.setText("Pressure: 23.67 inHG  ");
        jPanel2.add(PressureJLabel, new AbsoluteConstraints(70, 160, 220, -1));

        jSeparator5.setBackground(new Color(255, 255, 255));
        jSeparator5.setForeground(new Color(255, 255, 255));
        jSeparator5.setOrientation(SwingConstants.VERTICAL);
        jPanel2.add(jSeparator5, new AbsoluteConstraints(700, 150, 10, 120));

        jSeparator3.setBackground(new Color(255, 255, 255));
        jSeparator3.setForeground(new Color(255, 255, 255));
        jSeparator3.setOrientation(SwingConstants.VERTICAL);
        jPanel2.add(jSeparator3, new AbsoluteConstraints(300, 150, 10, 120));

        jLabel45.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        jLabel45.setForeground(new Color(255, 255, 255));
        jLabel45.setText("Weather Forecast in ");
        jPanel2.add(jLabel45, new AbsoluteConstraints(10, 80, -1, -1));

        WeatherDayIcon.setIcon(new ImageIcon(getClass().getResource("/Cloud_100px.png"))); // NOI18N
        jPanel2.add(WeatherDayIcon, new AbsoluteConstraints(450, 100, 110, -1));

        jSeparator2.setBackground(new Color(255, 255, 255));
        jSeparator2.setForeground(new Color(255, 255, 255));
        jPanel2.add(jSeparator2, new AbsoluteConstraints(790, 200, 110, 10));

        DayLambel.setFont(new Font("Segoe UI", 0, 12)); // NOI18N
        DayLambel.setForeground(new Color(255, 255, 255));
        DayLambel.setText("THURSDAY 9TH");
        jPanel2.add(DayLambel, new AbsoluteConstraints(40, 430, 90, -1));

        CurrentTempLabel.setFont(new Font("Segoe UI", 0, 56)); // NOI18N
        CurrentTempLabel.setForeground(new Color(255, 255, 255));
        CurrentTempLabel.setText("20 °C");
        jPanel2.add(CurrentTempLabel, new AbsoluteConstraints(40, 350, 140, 80));

        jSeparator1.setBackground(new Color(255, 255, 255));
        jSeparator1.setForeground(new Color(255, 255, 255));
        jSeparator1.setOrientation(SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1, new AbsoluteConstraints(190, 370, 10, 70));

        jLabel42.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel42.setForeground(new Color(255, 255, 255));
        jLabel42.setText("TUE");
        jPanel2.add(jLabel42, new AbsoluteConstraints(370, 350, -1, -1));

        jLabel41.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setForeground(new Color(255, 255, 255));
        jLabel41.setText("WED");
        jPanel2.add(jLabel41, new AbsoluteConstraints(480, 350, -1, -1));

        jLabel40.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setForeground(new Color(255, 255, 255));
        jLabel40.setText("THU");
        jPanel2.add(jLabel40, new AbsoluteConstraints(580, 350, -1, -1));

        jLabel39.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setForeground(new Color(255, 255, 255));
        jLabel39.setText("FRI");
        jPanel2.add(jLabel39, new AbsoluteConstraints(690, 350, 20, -1));

        jLabel38.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setForeground(new Color(255, 255, 255));
        jLabel38.setText("SAT");
        jPanel2.add(jLabel38, new AbsoluteConstraints(790, 350, -1, -1));

        jLabel37.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setForeground(new Color(255, 255, 255));
        jLabel37.setText("SUN");
        jPanel2.add(jLabel37, new AbsoluteConstraints(890, 350, 40, -1));

        MONTempJLabel.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        MONTempJLabel.setForeground(new Color(255, 255, 255));
        MONTempJLabel.setText("23°");
        jPanel2.add(MONTempJLabel, new AbsoluteConstraints(260, 440, 30, -1));

        TUETempJLabel.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        TUETempJLabel.setForeground(new Color(255, 255, 255));
        TUETempJLabel.setText("30°");
        jPanel2.add(TUETempJLabel, new AbsoluteConstraints(370, 440, 30, 20));

        WEDTempJLabel.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        WEDTempJLabel.setForeground(new Color(255, 255, 255));
        WEDTempJLabel.setText("19°");
        jPanel2.add(WEDTempJLabel, new AbsoluteConstraints(490, 440, 30, -1));

        THUTempJLabel.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        THUTempJLabel.setForeground(new Color(255, 255, 255));
        THUTempJLabel.setText("20°");
        jPanel2.add(THUTempJLabel, new AbsoluteConstraints(590, 440, 30, -1));

        FRITempJLabel.setForeground(new Color(255, 255, 255));
        FRITempJLabel.setText("25°");
        jPanel2.add(FRITempJLabel, new AbsoluteConstraints(690, 440, 30, -1));

        SATTempJLabel.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        SATTempJLabel.setForeground(new Color(255, 255, 255));
        SATTempJLabel.setText("25");
        jPanel2.add(SATTempJLabel, new AbsoluteConstraints(790, 440, -1, -1));

        SUNTempJLabel.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        SUNTempJLabel.setForeground(new Color(255, 255, 255));
        SUNTempJLabel.setText("22");
        jPanel2.add(SUNTempJLabel, new AbsoluteConstraints(900, 440, -1, -1));

        jLabel29.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new Color(255, 255, 255));
        jLabel29.setText("MON");
        jPanel2.add(jLabel29, new AbsoluteConstraints(250, 350, -1, -1));

        MONIconJLabel.setIcon(new ImageIcon(getClass().getResource("/Cloud_64px.png"))); // NOI18N
        jPanel2.add(MONIconJLabel, new AbsoluteConstraints(240, 370, -1, -1));

        TUEIconJLabel.setIcon(new ImageIcon(getClass().getResource("/Rain_64px_1.png"))); // NOI18N
        jPanel2.add(TUEIconJLabel, new AbsoluteConstraints(350, 370, -1, -1));

        WEDIconJLabel.setIcon(new ImageIcon(getClass().getResource("/Sun_64px_3.png"))); // NOI18N
        jPanel2.add(WEDIconJLabel, new AbsoluteConstraints(464, 370, 70, -1));

        THUIconJLabel.setIcon(new ImageIcon(getClass().getResource("/Cloud_64px.png"))); // NOI18N
        jPanel2.add(THUIconJLabel, new AbsoluteConstraints(570, 370, -1, -1));

        SUNIconJLabel.setIcon(new ImageIcon(getClass().getResource("/Rain_64px_1.png"))); // NOI18N
        jPanel2.add(SUNIconJLabel, new AbsoluteConstraints(880, 370, -1, -1));

        SATIconJLabel.setIcon(new ImageIcon(getClass().getResource("/Snow_64px.png"))); // NOI18N
        jPanel2.add(SATIconJLabel, new AbsoluteConstraints(770, 370, -1, 70));

        FRIIconJLabel.setIcon(new ImageIcon(getClass().getResource("/Sun_64px_3.png"))); // NOI18N
        jPanel2.add(FRIIconJLabel, new AbsoluteConstraints(670, 370, -1, -1));

        jLabel21.setIcon(new ImageIcon(getClass().getResource("/Marker_64px.png"))); // NOI18N
        jPanel2.add(jLabel21, new AbsoluteConstraints(120, 10, -1, 80));

        jLabel20.setFont(new Font("Segoe UI", 0, 48)); // NOI18N
        jLabel20.setForeground(new Color(255, 255, 255));
        jPanel2.add(jLabel20, new AbsoluteConstraints(720, 30, -1, -1));

        jLabel19.setIcon(new ImageIcon(getClass().getResource("/Wind Speed 98-102_44px.png"))); // NOI18N
        jPanel2.add(jLabel19, new AbsoluteConstraints(10, 240, -1, 30));

        jLabel18.setIcon(new ImageIcon(getClass().getResource("/Humidity_44px.png"))); // NOI18N
        jPanel2.add(jLabel18, new AbsoluteConstraints(10, 190, -1, 40));

        DescriptionLabel.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        DescriptionLabel.setForeground(new Color(255, 255, 255));
        DescriptionLabel.setText("Mostly Cloudy");
        jPanel2.add(DescriptionLabel, new AbsoluteConstraints(450, 210, 140, -1));

        jLabel16.setIcon(new ImageIcon(getClass().getResource("/Thermometer-44.png"))); // NOI18N
        jPanel2.add(jLabel16, new AbsoluteConstraints(870, 230, 40, 50));

        jLabel15.setIcon(new ImageIcon(getClass().getResource("/Thermometer-44.png"))); // NOI18N
        jPanel2.add(jLabel15, new AbsoluteConstraints(870, 140, 40, 50));

        MaxTempLabel.setFont(new Font("Dialog", 0, 34)); // NOI18N
        MaxTempLabel.setForeground(new Color(255, 255, 255));
        MaxTempLabel.setText("24 ℃");
        jPanel2.add(MaxTempLabel, new AbsoluteConstraints(780, 240, 100, -1));

        jLabel13.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new Color(255, 255, 255));
        jLabel13.setText("Max. Temp. ");
        jPanel2.add(jLabel13, new AbsoluteConstraints(780, 210, -1, -1));

        MinTempLabel.setFont(new Font("Dialog", 0, 34)); // NOI18N
        MinTempLabel.setForeground(new Color(255, 255, 255));
        MinTempLabel.setText("11 ℃");
        jPanel2.add(MinTempLabel, new AbsoluteConstraints(780, 150, 100, 40));

        jLabel11.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new Color(255, 255, 255));
        jLabel11.setText("Min. Temp. ");
        jPanel2.add(jLabel11, new AbsoluteConstraints(780, 120, -1, -1));

        DetailedLabel.setFont(new Font("Segoe UI", 0, 12)); // NOI18N
        DetailedLabel.setForeground(new Color(255, 255, 255));
        DetailedLabel.setText("Last Updated: Sat Apr 29 13:00:00 EEST 2017");
        jPanel2.add(DetailedLabel, new AbsoluteConstraints(390, 250, 240, -1));

        WindLabel.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        WindLabel.setForeground(new Color(255, 255, 255));
        WindLabel.setText("Wind Speed: 5m/s");
        jPanel2.add(WindLabel, new AbsoluteConstraints(70, 240, 240, 20));

        HumidityLabel.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        HumidityLabel.setForeground(new Color(255, 255, 255));
        HumidityLabel.setText("Humidity: 62%");
        jPanel2.add(HumidityLabel, new AbsoluteConstraints(70, 200, 210, 20));

        LocationLabel.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        LocationLabel.setForeground(new Color(255, 255, 255));
        LocationLabel.setText("Greece,Gr");
        jPanel2.add(LocationLabel, new AbsoluteConstraints(420, 50, 200, -1));
        LocationLabel.getAccessibleContext().setAccessibleName("");

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/Cancel_20px.png"))); // NOI18N
        jLabel1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                JLabel1MouseEntered(evt);
            }
        });
        jPanel2.add(jLabel1, new AbsoluteConstraints(970, 0, -1, -1));

        jLabel2.setIcon(new ImageIcon(getClass().getResource("/Minus_20px.png"))); // NOI18N
        jLabel2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                Jlabel2MouseEntered(evt);
            }
        });
        jPanel2.add(jLabel2, new AbsoluteConstraints(940, 0, -1, -1));

        RefreshIconLabel.setIcon(new ImageIcon(getClass().getResource("/Refresh_15px.png"))); // NOI18N
        RefreshIconLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                RefreshIconLabelMouseClicked(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                IconMouseEnteredJLabel(evt);
            }
        });
        jPanel2.add(RefreshIconLabel, new AbsoluteConstraints(630, 250, 20, -1));

        jLabel6.setIcon(new ImageIcon(getClass().getResource("/spots_background_light_blur_68629_1920x1080.jpg"))); // NOI18N
        jPanel2.add(jLabel6, new AbsoluteConstraints(0, 0, 990, 490));

        getContentPane().add(jPanel2, new AbsoluteConstraints(0, 0, 990, 480));

        pack();
    }
     
     
     private void formMouseDragged(MouseEvent evt) {                                  
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }                                 

    private void formMousePressed(MouseEvent evt) {                                  
        xMouse = evt.getX();
        yMouse = evt.getY();
    }                                 

    private void jLabel1MouseClicked(MouseEvent evt) {                                     
        System.exit(0);
    }                                    

    private void jLabel2MouseClicked(MouseEvent evt) {                                     
        setState(Frame.ICONIFIED);
    }                                    

    private void RefreshIconLabelMouseClicked(MouseEvent evt) {                                              
        timer.stop();
        final BackgroundWorker worker = new BackgroundWorker(entry, DynJLabelList, CurrentTempLabel, DayLambel, DescriptionLabel,
                DetailedLabel, HumidityLabel, PressureJLabel, MaxTempLabel, MinTempLabel, WindLabel, WeatherDayIcon, RefreshIconLabel);
        worker.execute();
        timer.restart();
    }                                             

    private void Jlabel2MouseEntered(MouseEvent evt) {                                     
        jLabel2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }                                    

    private void JLabel1MouseEntered(MouseEvent evt) {                                     
        jLabel1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }                                    

    private void IconMouseEnteredJLabel(MouseEvent evt) {                                        
        RefreshIconLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }                                       

    private void InitTimer() {
        timer = new Timer(delay, new ActionListener() {      // Timer 4 seconds
            public void actionPerformed(ActionEvent e) {
                UpdateTimerValue();
                repaint();
            }
        });
    }

    private void UpdateTimerValue() {
        final Calendar cal = Calendar.getInstance();
        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        final String timeValue = sdf.format(cal.getTime());
        if (cal.get(Calendar.AM_PM) == Calendar.PM) {
            jLabel20.setText(timeValue + " PM");
        } else {
            jLabel20.setText(timeValue + " AM");
        }
    }

    private void Init() {
        timer.start();
        UpdateTimerValue();

        DynJLabelList = new DynamicJLabelList();

        //add labels to Change the icon days of week
        DynJLabelList.AddDayOfWeekyIcons(SUNIconJLabel);
        DynJLabelList.AddDayOfWeekyIcons(MONIconJLabel);
        DynJLabelList.AddDayOfWeekyIcons(TUEIconJLabel);
        DynJLabelList.AddDayOfWeekyIcons(WEDIconJLabel);
        DynJLabelList.AddDayOfWeekyIcons(THUIconJLabel);
        DynJLabelList.AddDayOfWeekyIcons(FRIIconJLabel);
        DynJLabelList.AddDayOfWeekyIcons(SATIconJLabel);

        //add labels to Change the Temperature of the week
        DynJLabelList.AddDayOfWeekTemperature(SUNTempJLabel);
        DynJLabelList.AddDayOfWeekTemperature(MONTempJLabel);
        DynJLabelList.AddDayOfWeekTemperature(TUETempJLabel);
        DynJLabelList.AddDayOfWeekTemperature(WEDTempJLabel);
        DynJLabelList.AddDayOfWeekTemperature(THUTempJLabel);
        DynJLabelList.AddDayOfWeekTemperature(FRITempJLabel);
        DynJLabelList.AddDayOfWeekTemperature(SATTempJLabel);
    }

    public static void main(String args[]) {
        BlockUI check = new BlockUI();
        FeedEntry entry = check.IsStart();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (check.getVisibilityVar().get()) {
                    new MainWeatherFrame(entry);
                } else {
                    new JFxBuilder(new DialogObject(Alert.AlertType.ERROR, "Error Dialog", "Ooops, there was an error!",
                            "Internet not available, Cross check your internet connectivity and try again")).Invoke();
                }
            }
        });
    }
}
