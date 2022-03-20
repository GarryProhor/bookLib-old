package by.prohor.booklib.security;

import by.prohor.booklib.entity.User;
import by.prohor.booklib.security.model.JwtUser;
import by.prohor.booklib.security.model.JwtUserFactory;
import by.prohor.booklib.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    Logger log = LoggerFactory.getLogger(JwtUserDetailsService.class);
    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }
        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("In loadUserByUsername - user with username: {} successfuly loaded", username);
        return jwtUser;
    }
}
