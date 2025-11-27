package Controller;

import java.time.LocalDate;

import Moduler.DataModel;

public class Forecast  extends DataModel{
	
	
	Forecast(LocalDate date, String condition, int minTempC, int maxTempC, int humidity, double windKph) {
        this.date = date;
        this.condition = condition; 
        this.minTempC = minTempC;
        this.maxTempC = maxTempC;
        this.humidity = humidity;
        this.windKph = windKph;
    }

}
