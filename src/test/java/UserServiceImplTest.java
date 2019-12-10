import UserService.SecurityService;
import UserService.User;
import UserService.UserDAO;
import UserService.UserServiceImpl;
import static org.mockito.Mockito.*;


import org.junit.Test;

public class UserServiceImplTest {
    @Test
    public void userShouldGetNewPassword() throws Exception {
        UserDAO userDao = mock(UserDAO.class);
        SecurityService securityService = mock(SecurityService.class);
        User user = mock(User.class);
        UserServiceImpl userServiceImpl = new UserServiceImpl(userDao,securityService);

        userServiceImpl.assignPassword(user);

        verify(user).getPassword();

    }
}
