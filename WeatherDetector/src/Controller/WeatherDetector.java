package Controller;

import java.util.List;

import Moduler.DataModel;

public class WeatherDetector {

	public static void main(String[] args) {
		DataModel datamdl = new DataModel();
		WeatherApp wtrapp = new WeatherApp();
		
		
		 wtrapp.typePrint("Welcome to WeatherApp — simple demo version!", 20);
		while (true) {
			 wtrapp.showMenu();
			String choice = datamdl.getSc().nextLine().trim();
			if (choice.equals("1")) {
				System.out.print("Enter city name: ");
				String city = datamdl.getSc().nextLine().trim();
				if (city.isEmpty()) {
					System.out.println("City name required.");
					continue;
				}

				System.out.print("How many days (1-7)? ");
				int days = 0;
				try {
					days = Integer.parseInt(datamdl.getSc().nextLine().trim());
					if (days < 1)
						days = 1;
					if (days > 7)
						days = 7;
				} catch (Exception e) {
					days = 3;
				}

				 wtrapp.typePrint("\nGenerating forecast", 40);

				for (int i = 0; i < 3; i++) {
					System.out.print(".");
					try {
						Thread.sleep(350);
					} catch (Exception e) {
					}
				}
				System.out.println();

				List<DataModel> f =  wtrapp.generateForecast(city, days);
				wtrapp.showForecastWithTyping(city, f);

			} else if (choice.equals("2")) {
				String[] samples = { "Chennai", "Mumbai", "Delhi", "Bengaluru" };
				for (String c : samples) {
					 wtrapp.	typePrint("\n--- Demo: " + c + " ---", 25);
					List<DataModel> f =  wtrapp.generateForecast(c, 3);
					wtrapp.showForecastWithTyping(c, f);
					try {
						Thread.sleep(500);
						} catch (InterruptedException e) {
					}
				}
			} else if (choice.equals("3") || choice.equalsIgnoreCase("exit")) {
				 wtrapp .typePrint("Goodbye!", 20);
				break;
			} else {
				System.out.println("Invalid choice, try again.");
			}
		}
		datamdl.getSc().close();
	}
}