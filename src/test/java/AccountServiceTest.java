import dao.fakeImpl.AccountDaoFakeImpl;
import dao.fakeImpl.UserDaoFakeImpl;
import entity.Account;
import entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import service.AccountService;
import service.UserService;
import service.impl.AccountServiceImpl;
import service.impl.UserServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceTest {

    private static AccountService accountService;
    private static List<User> userList;
    private static List<Account> accountList;

    @BeforeClass
    public static void init() {
        userList = new ArrayList<>();
        accountList = new ArrayList<>();
        accountService = new AccountServiceImpl(new AccountDaoFakeImpl(accountList));
    }

    @Before
    public void prepare() {
        accountList.clear();
    }

    @Test
    public void sum() throws SQLException {

        long sum = 0L;
        long val;

        val = 2735L;
        sum += val;
        userList.add(new User(1L, "Daniel", "Ian"));
        accountList.add(new Account(1L, val, 1L));

        val = 345L;
        sum += val;
        userList.add(new User(2L, "Amelia", "Kirby"));
        accountList.add(new Account(2L, val, 2L));

        val = 0L;
        sum += val;
        userList.add(new User(2L, "Mia", "Naomi"));
        accountList.add(new Account(2L, val, 2L));

        Assert.assertEquals(sum, accountService.getSumOfAllAccounts());
    }

    @Test
    public void sumEmpty() throws SQLException {
        Assert.assertEquals(0L, accountService.getSumOfAllAccounts());
    }
}
