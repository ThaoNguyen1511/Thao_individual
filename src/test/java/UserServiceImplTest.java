import UserService.SecurityService;
import UserService.User;
import UserService.UserDAO;
import UserService.UserServiceImpl;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class UserServiceImplTest {
    //create DOCs
    private UserDAO userDao = mock(UserDAO.class);
    private SecurityService securityService = mock(SecurityService.class);
    private User user = mock(User.class);
    //Create SUT
    private UserServiceImpl userServiceImpl = new UserServiceImpl(userDao,securityService);
    @Test
    public void userShouldGetNewPassword() throws Exception {
        //act
        when(user.getPassword()).thenReturn("MyPassword");
        userServiceImpl.assignPassword(user);
        //assert
        verify(user).setPassword(any());
        verify(userDao).updateUser(user);

    }
}
