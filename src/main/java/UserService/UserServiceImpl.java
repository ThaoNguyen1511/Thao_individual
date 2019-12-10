package UserService;

public class UserServiceImpl {
    private UserDAO userDAO;
    private SecurityService securityService;

    public void assignPassword(User user) throws Exception
    {

    }
    public UserServiceImpl(UserDAO dao, SecurityService security)
    {
        this.userDAO = dao;
        this.securityService = security;
    }
}
