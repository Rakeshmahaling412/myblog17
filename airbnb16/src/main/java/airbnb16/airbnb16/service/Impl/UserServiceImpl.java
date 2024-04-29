package airbnb16.airbnb16.service.Impl;

import airbnb16.airbnb16.entity.PropertyUser;
import airbnb16.airbnb16.execption.ResourceNotFound;
import airbnb16.airbnb16.payload.Login;
import airbnb16.airbnb16.payload.Signup;
import airbnb16.airbnb16.repository.PropertyUserRepository;
import airbnb16.airbnb16.service.JWTService;
import airbnb16.airbnb16.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private PropertyUserRepository propertyUserRepository;
    private JWTService jwtService;

    public UserServiceImpl(PropertyUserRepository propertyUserRepository, JWTService jwtService) {
        this.propertyUserRepository = propertyUserRepository;
        this.jwtService = jwtService;
    }

    @Override
    public PropertyUser createUser(Signup signup) {
        if(propertyUserRepository.existsByEmail(signup.getEmail())){
            throw new ResourceNotFound("Email id is already exits");
        } else if (propertyUserRepository.existsByUsername(signup.getUsername())) {
            throw new ResourceNotFound("Username is already exits");

        }
        PropertyUser user = new PropertyUser();
        user.setFirstName(signup.getFirstName());
        user.setLastName(signup.getLastName());
        user.setEmail(signup.getEmail());
        user.setPassword(BCrypt.hashpw(signup.getPassword(),BCrypt.gensalt(10)));
        user.setUserRole(signup.getUserRole());
        user.setUserRole(signup.getUserRole());
        user.setUsername(signup.getUsername());
        PropertyUser save = propertyUserRepository.save(user);
        return save;
    }

    @Override
    public String loginUser(Login login) {
        Optional<PropertyUser> byUsername = propertyUserRepository.findByUsername(login.getUsername());
        PropertyUser user = byUsername.orElseThrow(() -> new UsernameNotFoundException("Username is not found"));
        if(user!=null){
            if(BCrypt.checkpw(login.getPassword(),user.getPassword())){
                return jwtService.getToken(user);


            }else{
                throw new ResourceNotFound("Password is invalid");
            }
        }
        return null;
    }
}
