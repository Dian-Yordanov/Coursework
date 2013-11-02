/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;
import weatherforecast.*;

/** Test harness for the weather class
 *
 * @author Andrew Coles
 */
public class WeatherForecastTestHarness {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LinkedList<WeatherLocationIDAndName> stations = FetchWeatherForecast.findWeatherStationsNearTo("Birmingham");
        
        for (WeatherLocationIDAndName station : stations) {            
            System.out.println(station);
        }
        
        WeatherLocationIDAndName firstMatch = stations.getFirst();
        
        List<ForecastForOneDay> forecast = FetchWeatherForecast.getWeatherForecast(firstMatch);
        
        for (ForecastForOneDay day : forecast) {            
            System.out.println("The weather on " + day.getDayOfWeek() + " will be " + day.getInformation("Conditions"));
            System.out.println("Min temp: " + day.getInformation("Min Temp"));
        }
        
        System.out.println(FetchWeatherForecast.getAcknowledgement());
    }
}
