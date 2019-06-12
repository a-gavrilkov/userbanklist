import dao.fakeImpl.AccountDaoFakeImpl;
import dao.fakeImpl.UserDaoFakeImpl;
import entity.Account;
import entity.User;
import exception.UserNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import service.UserService;
import service.impl.UserServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

    private static UserService userService;
    private static List<User> userList;
    private static List<Account> accountList;

    @BeforeClass
    public static void init() {
        userList = new ArrayList<>();
        accountList = new ArrayList<>();
        userService = new UserServiceImpl(new UserDaoFakeImpl(userList), new AccountDaoFakeImpl(accountList));
    }

    @Before
    public void prepare() {
        userList.clear();
        accountList.clear();
    }

    @Test
    public void richestUser() throws SQLException {
        User richest = new User(1L, "Daniel", "Ian");
        userList.add(richest);
        accountList.add(new Account(1L, 2735L, 1L));

        userList.add(new User(2L, "Amelia", "Kirby"));
        accountList.add(new Account(2L, 345L, 2L));

        userList.add(new User(2L, "Mia", "Naomi"));
        accountList.add(new Account(2L, 0L, 2L));

        Assert.assertEquals(richest, userService.getRichestUser());
    }

    @Test(expected = UserNotFoundException.class)
    public void richestWithEmptyStorage() throws SQLException {
        userService.getRichestUser();
    }
}
