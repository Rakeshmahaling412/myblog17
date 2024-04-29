package airbnb16.airbnb16.service.Impl;

import airbnb16.airbnb16.entity.Country;
import airbnb16.airbnb16.entity.Location;
import airbnb16.airbnb16.entity.Property;
import airbnb16.airbnb16.payload.PropertyDto;
import airbnb16.airbnb16.repository.CountryRepository;
import airbnb16.airbnb16.repository.LocationRepository;
import airbnb16.airbnb16.repository.PropertyRepository;
import airbnb16.airbnb16.service.PropertyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    private PropertyRepository propertyRepository;
    private CountryRepository countryRepository;
    private LocationRepository locationRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository, CountryRepository countryRepository, LocationRepository locationRepository) {
        this.propertyRepository = propertyRepository;
        this.countryRepository = countryRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Property>findProperty(String locationName) {

        List<Property> propertyByLocation = propertyRepository.findPropertyByLocation(locationName);

        return propertyByLocation;
    }

    @Override
    public Property createPropert(PropertyDto propertyDto) {
        // Map PropertyDto to Property entity
        Property property = new Property();
        property.setPropertyName(propertyDto.getPropertyName());
        property.setBathrooms(propertyDto.getBathrooms());

        // Check if the provided Country exists in the database
        Country country = countryRepository.findByCountryName(propertyDto.getCountry().getCountryName());
        if (country == null) {
            // If Country doesn't exist, create a new one
            country = new Country();
            country.setCountryName(propertyDto.getCountry().getCountryName());
            // Save the new Country entity
            country = countryRepository.save(country);
        }
        property.setCountry(country);

        // Check if the provided Location exists in the database
        Location location = locationRepository.findByLocationName(propertyDto.getLocation().getLocationName());
        if (location == null) {
            // If Location doesn't exist, create a new one
            location = new Location();
            location.setLocationName(propertyDto.getLocation().getLocationName());
            // Save the new Location entity
            location = locationRepository.save(location);
        }
        property.setLocation(location);

        property.setBedrooms(propertyDto.getBedrooms());
        property.setNightlyPrice(propertyDto.getNightlyPrice());
        property.setGuests(propertyDto.getGuests());

        // Save the Property entity
        Property savedProperty = propertyRepository.save(property);

        // Map the saved Property entity back to PropertyDto and return it
      return savedProperty;
    }




}
