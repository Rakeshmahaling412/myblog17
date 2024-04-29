package airbnb16.airbnb16.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {
    @PostMapping("/addCountry")
    public ResponseEntity<?> addCountry(){
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }
}
