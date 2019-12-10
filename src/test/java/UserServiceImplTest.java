import UserService.Client;
import UserService.Message;
import UserService.UserServiceImpl;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class UserServiceImplTest {
    @Test
    public void userShouldGetNewPassword(){
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        Client client = mock(Client.class);
        Message message = mock(Message.class);
    }
}
