package in.ineuron.test;

import in.ineuron.utility.JWTUtil;
import io.jsonwebtoken.Claims;

public class JWTTestApp {

	public static void main(String[] args) throws Exception {

		String token = JWTUtil.generatToken("TRA_SCTN", "UPI-PIN", "7234");
		System.out.println(token);

		Claims claims = JWTUtil.getClaims("7234", token);
		System.out.println("Subject info :: " + claims.getSubject());
		System.out.println("Client id    :: " + claims.getId());
		System.out.println("Exprity date :: " + claims.getExpiration());
		System.out.println("IssuedDate time :: " + claims.getIssuedAt());

		System.out.println("IS Token valid      :: " + JWTUtil.isTokenValid("7234", token));
		System.out.println("SubjectInfo         :: " + JWTUtil.getSubject("7234", token));
		System.out.println("ExpiryDate and Time :: " + JWTUtil.getExpiryDate("7234", token));

	}

}
