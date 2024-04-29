package airbnb16.airbnb16.service;

import airbnb16.airbnb16.entity.Favourite;
import airbnb16.airbnb16.entity.PropertyUser;

public interface FavoriteService {
    void addToFav(Favourite favourite, PropertyUser user);
}
