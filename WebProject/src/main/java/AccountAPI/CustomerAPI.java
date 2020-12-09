package AccountAPI;

import Controller.CustomerController;
import Model.Customer;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("customer")
public class CustomerAPI {
    @POST
    public Response addCustomer(@QueryParam("name_customer)") String name_customer,
                                @QueryParam("age") int age,
                                @QueryParam("id_admin") int id_admin){
        if(new CustomerController().addCustomer(new Customer(name_customer,age,id_admin))){
            return Response.ok("OK").build();
        }
        return Response.ok("Fail").build();
    }
}
