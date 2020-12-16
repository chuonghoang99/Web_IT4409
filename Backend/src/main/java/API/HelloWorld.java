package API;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileNotFoundException;

@Path("/helloworld")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces(MediaType.TEXT_HTML)
    public Response getClichedMessage() throws FileNotFoundException {
        // Return some cliched textual content
        return Response.ok("OK").build();
    }
}
