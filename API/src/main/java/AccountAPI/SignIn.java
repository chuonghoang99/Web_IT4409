package AccountAPI;

import Controller.AccountController;
import Model.Account;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("login")
public class SignIn {

    @POST
    public int signIn(@FormParam("username") String username,
                           @FormParam("password") String password){
        if(new AccountController().checkSignIn(new Account(username,password))){
            return 1;
        }
        return 0;
    }
}
