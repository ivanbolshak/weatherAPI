package weatherService;
//package weatherService;

import org.bitpipeline.lib.owm.OwmClient;
import org.bitpipeline.lib.owm.WeatherData;
import org.bitpipeline.lib.owm.WeatherStatusResponse;
import org.json.JSONException;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Ivan on 25.04.2016.
 */
public class weatherByDay {

    public static void main(String[] args) throws IOException, JSONException {
//        String city = "Dnipropetrovsk";
        String country = "UA";
        String city;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter city of Ukraine:\n(Example: Kiev, Dnipropetrovsk, Lviv...)");
        city = scan.nextLine();




        OwmClient owm = new OwmClient();
        WeatherStatusResponse currentWeather = owm.currentWeatherAtCity(city, country);
        if (currentWeather.hasWeatherStatus()) {
            WeatherData weather = currentWeather.getWeatherStatus().get(0);
//            WeatherData weather = currentWeather.getWeatherStatus().get(0);
//            if (weather.getPrecipitation() == Integer.MIN_VALUE) {
//                WeatherData.WeatherCondition weatherCondition = weather.getWeatherConditions().get(0);
//                String description = weatherCondition.getDescription();
//                if (description.contains("rain") || description.contains("shower"))
//                    System.out.println("No rain measures in " + city+ " but reports of " + description);
//                else
//                    System.out.println("No rain measures in "+ city+": " + description);
//            } else
//                System.out.println("It's raining in " + city+" " + weather.getPrecipitation() + " mm/h");

//            ----------------
            float celsiy =  273.15f;
            System.out.println("WindSpeed in city: " +city+" = "+weather.getWindSpeed());
            System.out.println("Current Temp in city: " +city+" = "+(weather.getTemp()-celsiy));
            System.out.println("TempMax() in city: " +city+" = "+(weather.getMain().getTempMax()-celsiy));
            System.out.println("TempMin() in city: " +city+" = "+(weather.getMain().getTempMin()-celsiy));
            System.out.println("Rain in city: " +city+" = "+weather.getWeatherConditions().get(0).getDescription().contains(city));

        }
    }
}

//    No rain measures in Tokyo but reports of shower rain



