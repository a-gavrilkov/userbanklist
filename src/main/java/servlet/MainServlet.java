package servlet;

import dao.AccountDao;
import dao.UserDao;
import dao.impl.AccountDaoImpl;
import dao.impl.UserDaoImpl;
import entity.User;
import service.AccountService;
import service.UserService;
import service.impl.AccountServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    private UserDao userDao = new UserDaoImpl();
    private AccountDao accountDao = new AccountDaoImpl();

    private UserService userService = new UserServiceImpl(userDao, accountDao);
    private AccountService accountService = new AccountServiceImpl(accountDao);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String method = req.getParameter("method");
        String richestVal = req.getParameter("richestVal");
        String sumVal = req.getParameter("sumVal");
        if (Objects.equals(method, "richest")) {
            try {
                User user = userService.getRichestUser();
                req.setAttribute("richest", String.format("%s %s", user.getName(), user.getSureName()));
            } catch (SQLException e) {
                e.printStackTrace(resp.getWriter());
                return;
            }
            req.setAttribute("sum", sumVal);
        } else if (Objects.equals(method,"sum")) {
            try {
                req.setAttribute("sum", accountService.getSumOfAllAccounts());
            } catch (SQLException e) {
                e.printStackTrace(resp.getWriter());
                return;
            }
            req.setAttribute("richest", richestVal);
        }
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
    }
}
