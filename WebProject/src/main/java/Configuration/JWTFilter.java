package Configuration;

import Authority.JWTAuth;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.deploy.net.HttpRequest;

import javax.annotation.Priority;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.NotActiveException;
import java.util.Enumeration;

@WebFilter("/*")
@Priority(2000)
public class JWTFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest= (HttpServletRequest) servletRequest;
        String token=httpRequest.getHeader("Authorization");
        if(token==null){
            servletRequest.getRequestDispatcher("login").forward(servletRequest,servletResponse);
        }else {
            try {
                JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256(JWTAuth.secret)).build();
                DecodedJWT jwt=jwtVerifier.verify(token);
            }catch (JWTVerificationException exception){
                ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token is not valid.");
            }
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
