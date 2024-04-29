package airbnb16.airbnb16.controller;

import airbnb16.airbnb16.entity.Favourite;
import airbnb16.airbnb16.entity.PropertyUser;
import airbnb16.airbnb16.service.FavoriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fav")
public class FavoriteController {
    private FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping
    public ResponseEntity<?> addToFav(@RequestBody Favourite favourite, @AuthenticationPrincipal PropertyUser user){
        favoriteService.addToFav(favourite,user);
        return new ResponseEntity<>("Property Added to your Favlist", HttpStatus.CREATED);
    }
}
