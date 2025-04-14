package org.projectrepo;

import org.json.JSONObject;

public class WeatherData {
    private String city;
    private double temperature;

    public WeatherData(String json) {
        JSONObject jsonObject = new JSONObject(json);
        this.city = jsonObject.getString("name");
        this.temperature = jsonObject.getJSONObject("main").getDouble("temp");
    }

    public String getCity() {
        return city;
    }

    public double getTemperature() {
        return temperature - 273.15; // Convert from Kelvin to Celsius
    }
}
