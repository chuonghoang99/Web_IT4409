package Authority;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;

public class JWTAuth {
    final public static String secret="This is my key";
    final private static int deadline=30;
    //checked
    public static String generateJWT(String username,String role){
        String result;
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, deadline);
        Algorithm algorithm=Algorithm.HMAC256(secret);
        result= JWT.create().withClaim("username",username).withClaim("role",role).withExpiresAt(c.getTime()).sign(algorithm);
        return result;
    }

    public static DecodedJWT decodedJWT(String token){
        return JWT.decode(token);
    }

    public static void main(String[] args) {
        System.out.println(JWTAuth.generateJWT("phamphong","123456"));
    }
}
