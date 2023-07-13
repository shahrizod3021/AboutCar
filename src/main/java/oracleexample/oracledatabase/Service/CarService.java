package oracleexample.oracledatabase.Service;

import lombok.RequiredArgsConstructor;
import oracleexample.oracledatabase.Entity.Car;
import oracleexample.oracledatabase.Entity.CarColors;
import oracleexample.oracledatabase.Entity.CarDescription;
import oracleexample.oracledatabase.Entity.CarType;
import oracleexample.oracledatabase.Payload.ApiResponse;
import oracleexample.oracledatabase.Payload.CarDto;
import oracleexample.oracledatabase.Payload.SelectDto;
import oracleexample.oracledatabase.Repository.*;
import org.apache.catalina.LifecycleState;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    private final CarColorRepository carColorRepository;

    private final CarDescriptionRepository carDescriptionRepository;
    private final   CarTypeRepository carTypeRepository;
    public Integer addCar(CarDto carDto){
        List<CarType>  carType = new ArrayList<>();
        List<CarDescription> carDescriptions = new ArrayList<>();
        List<CarColors> carColors = new ArrayList<>();
        for (SelectDto selectDto : carDto.getCarType()) {
            CarType getType = carTypeRepository.findById(selectDto.getValue()).orElseThrow(() -> new ResourceNotFoundException("getType"));
            carType.add(getType);
        }
        for (String s : carDto.getDescription()) {
            CarDescription carDescription = CarDescription.builder().description(s).build();
            CarDescription save = carDescriptionRepository.save(carDescription);
            carDescriptions.add(save);
        }
        for (String s : carDto.getColor()) {
            CarColors build = CarColors.builder().build();
            build.setName(s);
            CarColors save = carColorRepository.save(build);
            carColors.add(save);
        }
        Car car = Car.builder()
                .companyName(carDto.getCompanyName())
                .carColors(carColors)
                .carDescriptions(carDescriptions)
                .manufactureYear(carDto.getManYear())
                .model(carDto.getModel())
                .carTypes(carType)
                .carPrice(carDto.getPrice())
                .build();
        car.setName(carDto.getName());
        Car save = carRepository.save(car);
        return save.getId();
    }
}
