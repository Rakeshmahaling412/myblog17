package airbnb16.airbnb16.service;

import airbnb16.airbnb16.entity.PropertyUser;
import airbnb16.airbnb16.payload.Login;
import airbnb16.airbnb16.payload.Signup;

public interface UserService {
    PropertyUser createUser(Signup signup);

    String loginUser(Login login);
}
