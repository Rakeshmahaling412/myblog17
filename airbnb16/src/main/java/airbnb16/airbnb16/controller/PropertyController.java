package airbnb16.airbnb16.controller;

import airbnb16.airbnb16.entity.Property;
import airbnb16.airbnb16.payload.PropertyDto;
import airbnb16.airbnb16.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {
    private PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }
    @GetMapping("{locationName}")
    public ResponseEntity<List<Property>> findProperty(@PathVariable String locationName){
        List<Property> property = propertyService.findProperty(locationName);
        return new ResponseEntity<>(property, HttpStatus.OK);

    }
    @PostMapping("/addProperty")
    public ResponseEntity<?> addProperty(@RequestBody PropertyDto propertyDto){
        Property property = propertyService.createPropert(propertyDto);
        return new ResponseEntity<>(property,HttpStatus.CREATED);
    }

}
