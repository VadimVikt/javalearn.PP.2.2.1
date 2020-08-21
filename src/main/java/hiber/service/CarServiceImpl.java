package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Transactional
    @Override
    public void add(Car car) { carDao.add(car); }

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCars() { return carDao.getCars(); }

    @Transactional
    public User getUser(Car car) {
        Long carId = car.getId();
        System.out.println(carDao.getCars().get(Math.toIntExact(carId)).toString());
        return null;
    }
}
