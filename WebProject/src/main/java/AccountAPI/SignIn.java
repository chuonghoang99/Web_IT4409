package AccountAPI;

import Controller.AccountController;
import Model.Account;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/login")
public class SignIn {
    @POST
    public Response signIn(@QueryParam("username") String username,
                           @QueryParam("password") String password){
        return Response.ok(String.valueOf(new AccountController().getRole(new Account(username,password)))).build();
    }
}
