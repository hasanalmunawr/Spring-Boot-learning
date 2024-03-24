package hasanalmunawrDev.springBootsecurity.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@NoArgsConstructor
public class JwtUtils {

    private static final SecretKey secretKey = Jwts.SIG.HS256.key().build();

    private static final String ISSUER = "coding_streams_auth_server";

    public static boolean validateToken(String jwtToken) {
        return parseToken(jwtToken).isPresent();
    }

    private static Optional<Claims> parseToken(String jwtToken) {
        var jwtParser = Jwts.parser()
                .verifyWith(secretKey)
                .build();

        try {
            return Optional.of(jwtParser.parseSignedClaims(jwtToken).getPayload());
        } catch (Exception e) {
            log.error("JWT Exception occured " + e);
        }
        return Optional.empty();
    }

    public static Optional<String> getUserNameFromToken(String jwtToken) {
        var claimsOptional = parseToken(jwtToken);

        return claimsOptional.map(Claims::getSubject);
    }

    public static String generateToken(String username) {
        var currentDate = new Date();
        Date date = new Date(currentDate.getTime() + 10000L);
        return Jwts.builder()
                .id(UUID.randomUUID().toString())
                .issuer(ISSUER)
                .subject(username)
                .signWith(secretKey)
                .issuedAt(currentDate)
                .expiration(date)
                .compact();
    }
}
