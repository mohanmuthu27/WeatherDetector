package Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import Moduler.DataModel;


public class WeatherApp {

	public static void typePrint(String s, int msDelayPerChar) {
		for (char c : s.toCharArray()) {
			System.out.print(c);
			try {
				Thread.sleep(msDelayPerChar);
			} catch (InterruptedException e) {
				 }
		}
		System.out.println();
	}

	public static List<DataModel> generateForecast(String city, int days) {

	    List<String> conditions = Arrays.asList(
	        "Sunny", "Partly Cloudy", "Cloudy", "Light Rain",
	        "Heavy Rain", "Storm", "Windy", "Fog"
	    );
	    List<Forecast> list = new ArrayList<>();
	    try {
	        long seed = city.toLowerCase().chars().reduce(0, (a, b) -> a * 31 + b) ^ System.currentTimeMillis();
	        Random r = new Random(seed);

	        int base = 20 + (city.length() % 10);

	        LocalDate today = LocalDate.now();
	        for (int i = 0; i < days; i++) {
	            LocalDate d = today.plusDays(i);
	            int max = base + r.nextInt(8) - 2;
	            int min = max - (2 + r.nextInt(6));
	            String cond = conditions.get(r.nextInt(conditions.size()));
	            int hum = 40 + r.nextInt(61);
	            double wind = Math.round((5 + r.nextDouble() * 30) * 10.0) / 10.0;

	            
	            list.add(new Forecast(d, cond, min, max, hum, wind));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    List<DataModel> datalist = new ArrayList<>(list);
	    return datalist;
	}
	public static String padRight(String s, int width) {
		StringBuilder sb = new StringBuilder(s);
		try {
		if (s.length() >= width)
			return s;
		while (sb.length() < width)
			sb.append(' ');
		
		}catch(Exception e) {
			e.printStackTrace(); 
	}return sb.toString();}

	public void showMenu() {
		System.out.println("\n===== SIMPLE WEATHER FORECAST APP =====");
		System.out.println("1. Get forecast by city");
		System.out.println("2. Quick demo (sample cities)");
		System.out.println("3. Exit");
		System.out.print("Enter choice: ");
	}
	
	static void showForecastWithTyping(String city, List<DataModel> flist) {
	    try {
	        DateTimeFormatter df = DateTimeFormatter.ofPattern("EEE, MMM d yyyy");
	        typePrint("\nWeather forecast for " + city + ":", 25);
	        for (DataModel f : flist) {
	            String line = String.format(
	                "%s  | %s  | %d°C - %d°C  | Humidity: %d%%  | Wind: %.1f kph",
	                f.date.format(df),
	                padRight(f.condition, 13),
	                f.minTempC, f.maxTempC,
	                f.humidity,
	                f.windKph
	            );
	            typePrint(line, 8);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    try { Thread.sleep(200); } catch (InterruptedException e) {}
	}
   
}


