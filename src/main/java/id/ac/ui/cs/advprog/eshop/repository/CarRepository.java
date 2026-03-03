package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CarRepository implements BaseRepository<Car, String> {

    private final List<Car> carData = new ArrayList<>();

    @Override
    public Car create(Car car) {
        if (car.getCarId() == null) {
            car.setCarId(UUID.randomUUID().toString());
        }
        carData.add(car);
        return car;
    }

    @Override
    public List<Car> findAll() {
        return carData;
    }

    @Override
    public Car findById(String id) {
        return carData.stream()
                .filter(c -> c.getCarId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Car update(String id, Car updatedCar) {
        Car existing = findById(id);
        if (existing != null) {
            existing.setCarName(updatedCar.getCarName());
            existing.setCarColor(updatedCar.getCarColor());
            existing.setCarQuantity(updatedCar.getCarQuantity());
        }
        return existing;
    }

    @Override
    public void delete(String id) {
        carData.removeIf(c -> c.getCarId().equals(id));
    }
}