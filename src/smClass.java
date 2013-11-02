import com.sun.corba.se.impl.logging.ORBUtilSystemException;
import com.sun.javaws.ui.ApplicationIconGenerator;
import weatherforecast.FetchWeatherForecast;
import weatherforecast.ForecastForOneDay;
import weatherforecast.WeatherLocationIDAndName;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;


/**
 * User: Nocturnal Cyan
 * Date: 04/02/13
 * Time: 10:11
 * Cynnect's class
 */
public class smClass extends JFrame {



    public smClass()
    {
       // uiBuildingClass.getUi();
        uiBuilder();

    }


    public  void uiBuilder()
    {
        Image icon = Toolkit.getDefaultToolkit().getImage("AppIcon5.png");
        JPanel panel= new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        setSize(720, 480);
        setTitle("Three Day Weathe Forecast");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(icon);




        JLabel search = new JLabel("Search:");
        search.setBounds(50,50,100,30);
        search.setFont(new Font("Georgia", Font.ITALIC, 14));
        panel.add(search);

        JLabel supported = new JLabel("Supported by backstage.bbc.co.uk / Data from UK MET Office");
        supported.setBounds(130,400,400,30);
        supported.setFont(new Font("Georgia", Font.ITALIC, 14));
        panel.add(supported);

        JLabel wStations = new JLabel("Possible Weather Stations:");
        wStations.setBounds(50,100,200,30);
        wStations.setFont(new Font("Georgia", Font.ITALIC, 14));
        panel.add(wStations);

        final JTextArea city = new JTextArea();
        city.setBounds(102,58,200,18);
        city.setFont(new Font("Georgia", Font.PLAIN, 14));
        panel.add(city);

        final JTextArea day1 = new JTextArea();
        day1.setBounds(400,58,260,105);
        day1.setFont(new Font("Georgia", Font.PLAIN, 14));
        day1.setEditable(false);
        panel.add(day1);

        final JTextArea day2 = new JTextArea();
        day2.setBounds(400,178,260,105);
        day2.setFont(new Font("Georgia", Font.PLAIN, 14));
        day2.setEditable(false);
        panel.add(day2);

        final JTextArea day3 = new JTextArea();
        day3.setBounds(400,298,260,105);
        day3.setFont(new Font("Georgia", Font.PLAIN, 14));
        day3.setEditable(false);
        panel.add(day3);

        final DefaultListModel listModel = new DefaultListModel();

        final JList list = new JList(listModel);
        list.setBounds(50,125,300,200);


        JScrollPane pane = new JScrollPane();
        pane.setBounds(50,125,300,200);
        pane.getViewport().add(list);
        panel.add(pane);

        final JRadioButton rButton1 = new JRadioButton("Metric units");
        rButton1.setSelected(true);
        rButton1.setBounds(50,360,150,20);
        panel.add(rButton1);

        final JRadioButton rButton2 = new JRadioButton("Imperial units");
        rButton2.setBounds(50,340,150,20);
        panel.add(rButton2);

        ButtonGroup metricSystem = new ButtonGroup();
        metricSystem.add(rButton1);
        metricSystem.add(rButton2);

        uiBuildingClass.keyListenerAdder(city, day1,  day2,  day3,  list, rButton1, rButton2, listModel);

    }


}
