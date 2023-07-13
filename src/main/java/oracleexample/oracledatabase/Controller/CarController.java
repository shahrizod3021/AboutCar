package oracleexample.oracledatabase.Controller;

import lombok.RequiredArgsConstructor;
import oracleexample.oracledatabase.Payload.ApiResponse;
import oracleexample.oracledatabase.Payload.CarDto;
import oracleexample.oracledatabase.Repository.CarRepository;
import oracleexample.oracledatabase.Service.CarService;
import oracleexample.oracledatabase.Entity.Car;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
public class CarController {

    private final CarRepository carRepository;

    private final CarService carService;

    @GetMapping
    public HttpEntity<?> getCars(){
        List<Car> all = carRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping
    public HttpEntity<?> addCar (@RequestBody CarDto carDto){
        Integer integer = carService.addCar(carDto);
        return ResponseEntity.ok(integer);
    }

}
