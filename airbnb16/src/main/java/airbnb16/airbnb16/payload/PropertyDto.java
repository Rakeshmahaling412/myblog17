package airbnb16.airbnb16.payload;

import airbnb16.airbnb16.entity.Country;
import airbnb16.airbnb16.entity.Location;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PropertyDto {
    private String propertyName;

    private Integer bedrooms;

    private Integer bathrooms;

    private Integer guests;

    private Double nightlyPrice;

    private Country country;

    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Double getNightlyPrice() {
        return nightlyPrice;
    }

    public void setNightlyPrice(Double nightlyPrice) {
        this.nightlyPrice = nightlyPrice;
    }

    public Integer getGuests() {
        return guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

}
