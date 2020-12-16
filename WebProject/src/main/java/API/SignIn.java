package API;

import Authority.JWTAuth;
import Controller.AccountController;
import Model.Account;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
@Path("/login")
public class SignIn {
    @POST
    public Response signIn(@QueryParam("username") String username,
                           @QueryParam("password") String password){
        int role=new AccountController().getRole(new Account(username,password));
        if(role==-1){
            return Response.status(401).entity("Error username or password").build();
        }
        String token=JWTAuth.generateJWT(username,String.valueOf(role));
        return Response.ok(token).build();
    }
}
