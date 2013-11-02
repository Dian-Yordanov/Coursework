import weatherforecast.FetchWeatherForecast;
import weatherforecast.ForecastForOneDay;
import weatherforecast.WeatherLocationIDAndName;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

/**
 * User: Nocturnal Cyan
 * Date: 12/02/13
 * Time: 21:02
 * Cynnect's class
 */
public  abstract class uiBuildingClass extends smClass {

        public static void keyListenerAdder(final JTextArea city, final JTextArea day1, final JTextArea day2, final JTextArea day3, final JList list, final JRadioButton rButton1, final JRadioButton rButton2, final DefaultListModel listModel)
        {
            city.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {
                    //To change body of implemented methods use File | Settings | File Templates.

                }

                @Override


                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER){

                        final LinkedList<WeatherLocationIDAndName> stations = FetchWeatherForecast.findWeatherStationsNearTo(city.getText());
                        for (int ii=0;ii<stations.size();ii++) {

                            listModel.addElement(stations.get(ii).getLocationName());



                            list.addMouseListener(new MouseListener() {
                                @Override
                                public void mouseClicked(MouseEvent e) {


                                    int i=3;
                                    int finalIi=list.getSelectedIndex();
                                    for ( ForecastForOneDay day : FetchWeatherForecast.getWeatherForecast(stations.get(finalIi))) {
                                        double tempCmax = Double.parseDouble(day.getInformation("Max Temp").replace("&#xB0;C","   ").subSequence(0,4).toString());
                                        double tempCmin = Double.parseDouble(day.getInformation("Min Temp").replace("&#xB0;C","   ").subSequence(0,4).toString());
                                        String minTempInC = (String) day.getInformation("Min Temp").replace("&#xB0;C"," C ").subSequence(0, 4);
                                        String maxTempInC = (String) day.getInformation("Max Temp").replace("&#xB0;C"," C ").subSequence(0, 4);
                                        String minTempInF =  day.getInformation("Min Temp")
                                                .replace("&#xB0;F)"," F ").substring(3).replace("&","").replace("#","").replace("x","").replace("B","")
                                                .substring(3).replace("0","").replace(";","").replace("C","").replaceFirst(" ","").replace("(","");
                                        String maxTempInF =  day.getInformation("Max Temp")
                                                .replace("&#xB0;F)"," F ").substring(3).replace("&","").replace("#","").replace("x","").replace("B","")
                                                .substring(3).replace("0","").replace(";","").replace("C","").replaceFirst(" ","").replace("(","");
                                        String infoToBeAddedToPrntingString = "\n" +  "with " + day.getInformation("Conditions") + ", Pressure: " + day.getInformation("Pressure") +
                                                "\n" + "Humidity: " + day.getInformation("Humidity") + " Visibility: " + day.getInformation("Visibility") +
                                                "\n" + "Wind direction: " + day.getInformation("Wind Direction")+ " Wind: " ;
                                        double killometreToMileConverter =  Double.parseDouble(day.getInformation("Wind Speed").replace("mph","") );
                                        double mileConverted = killometreToMileConverter * 1.61;
                                        double feelsLikeC = Math.round(13.12 + 0.6215 * tempCmin - 11.37*Math.pow(killometreToMileConverter,0.16) + 0.3965 * tempCmin * Math.pow(killometreToMileConverter,0.16));
                                        double feelsLikeF = Math.round((feelsLikeC * 1.8) + 32);

                                        String toBePrintedifC = "The weather on " + day.getDayOfWeek() + " will be: "+
                                                "\n" + "Min temp: " + minTempInC + " Max temp: " + maxTempInC + infoToBeAddedToPrntingString + killometreToMileConverter + "kph" +
                                                "\n" + "Feels like: " +  feelsLikeC;
                                        String toBePrintedifF = "The weather on " + day.getDayOfWeek() + " will be: "+
                                                "\n" + "Min temp: " + minTempInF + " Max temp: " + maxTempInF + infoToBeAddedToPrntingString + mileConverted + "mph" +
                                                "\n" + "Feels like: " +  feelsLikeF;


                                        if(rButton1.isSelected()){
                                            if(i==3){day1.setText(toBePrintedifC);
                                                if(tempCmin >0 && tempCmin<30){day1.setForeground(Color.BLACK);}
                                                if(tempCmin <=0){day1.setForeground(Color.BLUE);}
                                                if(tempCmax >=30){day1.setForeground(Color.RED);} }
                                            if(i==2)day2.setText(toBePrintedifC);
                                            {day2.setText(toBePrintedifC);
                                                if(tempCmin >0 && tempCmin<30){day2.setForeground(Color.BLACK);}
                                                if(tempCmin <=0){day2.setForeground(Color.BLUE);}
                                                if(tempCmax >=30){day2.setForeground(Color.RED);} }
                                            if(i==1)day3.setText(toBePrintedifC);
                                            {day3.setText(toBePrintedifC);
                                                if(tempCmin >0 && tempCmin<30){day3.setForeground(Color.BLACK);}
                                                if(tempCmin <=0){day3.setForeground(Color.BLUE);}
                                                if(tempCmax >=30){day3.setForeground(Color.RED);}  }
                                        }
                                        if(rButton2.isSelected()){
                                            if(i==3)day1.setText(toBePrintedifF);
                                            {day1.setText(toBePrintedifF);

                                                if(tempCmin >0 && tempCmin<30){day1.setForeground(Color.BLACK);}
                                                if(tempCmin <=0){day1.setForeground(Color.BLUE);}
                                                if(tempCmax >=30){day1.setForeground(Color.RED);} }

                                            if(i==2)day2.setText(toBePrintedifF);
                                            {day2.setText(toBePrintedifF);
                                                if(tempCmin >0 && tempCmin<30){day2.setForeground(Color.BLACK);}
                                                if(tempCmin <=0){day2.setForeground(Color.BLUE);}
                                                if(tempCmax >=30){day2.setForeground(Color.RED);} }
                                            if(i==1)day3.setText(toBePrintedifF);
                                            {day3.setText(toBePrintedifF);
                                                if(tempCmin >0 && tempCmin<30){day3.setForeground(Color.BLACK);}
                                                if(tempCmin <=0){day3.setForeground(Color.BLUE);}
                                                if(tempCmax >=30){day3.setForeground(Color.RED);} }
                                        }
                                        i--;

                                        //System.out.println(day.getInformation("Min Temp").replace("&#xB0;C","C ").subSequence(0,4));


                                    }


                                }


                                @Override
                                public void mousePressed(MouseEvent e) {
                                    //To change body of implemented methods use File | Settings | File Templates.
                                }

                                @Override
                                public void mouseReleased(MouseEvent e) {
                                    //To change body of implemented methods use File | Settings | File Templates.
                                }

                                @Override
                                public void mouseEntered(MouseEvent e) {
                                    //To change body of implemented methods use File | Settings | File Templates.
                                }

                                @Override
                                public void mouseExited(MouseEvent e) {
                                    //To change body of implemented methods use File | Settings | File Templates.
                                }
                            });





                        }}



                }

                @Override
                public void keyReleased(KeyEvent e) {
                    //To change body of implemented methods use File | Settings | File Templates.



                }
            });











        }
    }


