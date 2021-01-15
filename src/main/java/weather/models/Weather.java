package weather.models;

public class Weather {

    private int id;
    private String city;
    private int temperature;

    public static Weather of(int id, String city, int temperature) {
        Weather weather = new Weather();
        weather.id = id;
        weather.city = city;
        weather.temperature = temperature;
        return weather;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public int getTemperature() {
        return temperature;
    }
}
