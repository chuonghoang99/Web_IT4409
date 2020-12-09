package AccountAPI;

import Controller.AccountController;
import Model.Account;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/signup")
public class SignUp {
    @POST
    public Response signUp(@QueryParam("username") String username,
                           @QueryParam("password") String password,
                           @QueryParam("role") int role){
        if(new AccountController().signUp(new Account(username,password,role))){
            return Response.ok("OK").build();
        }
        return Response.ok("Fail").build();
    }
}
