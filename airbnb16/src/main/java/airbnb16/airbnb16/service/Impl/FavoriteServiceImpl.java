package airbnb16.airbnb16.service.Impl;

import airbnb16.airbnb16.entity.Favourite;
import airbnb16.airbnb16.entity.PropertyUser;
import airbnb16.airbnb16.repository.FavouriteRepository;
import airbnb16.airbnb16.service.FavoriteService;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    private FavouriteRepository favouriteRepository;

    public FavoriteServiceImpl(FavouriteRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
    }

    @Override
    public void addToFav(Favourite favourite, PropertyUser user) {
        favourite.setPropertyUser(user);
        favouriteRepository.save(favourite);

    }
}
