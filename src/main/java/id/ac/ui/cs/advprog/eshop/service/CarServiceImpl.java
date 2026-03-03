package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final BaseRepository<Car, String> repository;

    public CarServiceImpl(BaseRepository<Car, String> repository) {
        this.repository = repository;
    }

    @Override
    public Car create(Car car) {
        return repository.create(car);
    }

    @Override
    public List<Car> findAll() {
        return repository.findAll();
    }

    @Override
    public Car findById(String carID) {
        return repository.findById(carID);
    }

    @Override
    public Car update(String carID, Car car) {
        return repository.update(carID, car);
    }

    @Override
    public void deleteCarById(String carID) {
        repository.delete(carID);
    }
}