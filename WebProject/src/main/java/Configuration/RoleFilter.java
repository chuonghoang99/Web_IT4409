package Configuration;

import Authority.JWTAuth;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.annotation.Priority;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/admin")
@Priority(5000)
public class RoleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest= (HttpServletRequest) servletRequest;
        String token=httpRequest.getHeader("Authorization");
        DecodedJWT decodedJWT= JWTAuth.decodedJWT(token);
        if(Integer.parseInt(String.valueOf(decodedJWT.getClaim("role").asString()))==1){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Accessing with admin role is confused");
        }

    }

    @Override
    public void destroy() {

    }
}
