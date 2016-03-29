package dcu;

/**
 * Created by Sean on 08/03/2016.
 */
import dcu.DAO.UserDAO;
import dcu.datamodel.User;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("UserService")
public class UserService {

    UserDAO userDao = new UserDAO();

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getUsers(){
        return userDao.getAllUsers();
    }
}