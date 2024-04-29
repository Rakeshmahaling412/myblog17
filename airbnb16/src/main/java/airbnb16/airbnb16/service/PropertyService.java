package airbnb16.airbnb16.service;

import airbnb16.airbnb16.entity.Property;
import airbnb16.airbnb16.payload.PropertyDto;

import java.util.List;

public interface PropertyService {
    List<Property> findProperty(String locationName);

    Property createPropert(PropertyDto propertyDto);
}
