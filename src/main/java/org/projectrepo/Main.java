package org.projectrepo;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();
        System.out.print("Enter city name: ");
        String city = scanner.nextLine();
        try {
            String response = client.getWeather(city);
            WeatherData weatherData = new WeatherData(response);
            System.out.println("Current temperature in " + weatherData.getCity() + ": " + weatherData.getTemperature() + " °C");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}