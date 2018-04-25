package io.innopolis.products;

import io.innopolis.products.models.User;
import io.innopolis.products.services.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    public UserServiceImpl userService;

    @Test
    public void loadUserbyUsername() {
        String username="Gizyaschwann";
        UserDetails user = userService.loadUserByUsername(username);
        assertEquals(username, user.getUsername());
    }
}
