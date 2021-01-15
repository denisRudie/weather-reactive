package weather.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import weather.models.Weather;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WeatherService {

    private final Map<Integer, Weather> weathers = new ConcurrentHashMap<>();

    {
        weathers.put(1, Weather.of(1, "Msc", 20));
        weathers.put(2, Weather.of(2, "SPb", 15));
        weathers.put(3, Weather.of(3, "Bryansk", 15));
        weathers.put(4, Weather.of(4, "Smolensk", 15));
        weathers.put(5, Weather.of(5, "Kiev", 15));
        weathers.put(6, Weather.of(6, "Minsk", 15));
    }

    public Mono<Weather> findById(Integer id) {
        return Mono.justOrEmpty(weathers.get(id));
    }

    public Flux<Weather> all() {
        return Flux.fromIterable(weathers.values());
    }

    public Mono<Weather> findWithMaxTemp() {
        Weather weather = null;
        int maxTemp = Integer.MIN_VALUE;

        for (Weather w : weathers.values()) {
            if (w.getTemperature() > maxTemp) {
                weather = w;
                maxTemp = w.getTemperature();
            }
        }

        return Mono.justOrEmpty(weather);
    }

    public Flux<Weather> findWithTempMoreThanValue(int temperature) {
        return Flux.fromStream(
                weathers.values().stream()
                        .filter(w -> w.getTemperature() > temperature)
        );
    }
}
