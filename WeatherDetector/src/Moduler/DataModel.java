package Moduler;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class DataModel {

	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	public LocalDate date;
	public String condition;
	public int minTempC;
	public int maxTempC;
	public int humidity;
	public double windKph;

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getMinTempC() {
		return minTempC;
	}

	public void setMinTempC(int minTempC) {
		this.minTempC = minTempC;
	}

	public int getMaxTempC() {
		return maxTempC;
	}

	public void setMaxTempC(int maxTempC) {
		this.maxTempC = maxTempC;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public double getWindKph() {
		return windKph;
	}

	public void setWindKph(double windKph) {
		this.windKph = windKph;
	}

}