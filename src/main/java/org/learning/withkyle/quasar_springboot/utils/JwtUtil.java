package org.learning.withkyle.quasar_springboot.utils;

import java.util.Date;

import javax.crypto.SecretKey;

import org.learning.withkyle.quasar_springboot.dto.LoginTrainerDTO;
import org.learning.withkyle.quasar_springboot.model.JwtClaim;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtUtil {
	@Value("${security.jwt.secret-key}")
	private String tokenSecretKey;

	@Value("${security.jwt.access-expiration-time}")
	private long tokenAccessExp;

	@Value("${security.jwt.refresh-expiration-time}")
	private long tokenRefreshExp;

	public SecretKey getSignedKey() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(tokenSecretKey));
	}

	// 15 minutes
	public String generateAccessToken(final LoginTrainerDTO loginTrainerDto) {
		JwtClaim claim = new JwtClaim();
		claim.setUserName(loginTrainerDto.userName);

		return Jwts.builder()
				.claim("data", claim)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + tokenAccessExp))
				.signWith(this.getSignedKey()).compact().toString();
	}

	//
	public String generateRefreshToken(final LoginTrainerDTO loginTrainerDto) {
		JwtClaim claim = new JwtClaim();
		claim.setUserName(loginTrainerDto.userName);

		return Jwts.builder()
				.claim("data", claim)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()))
				.signWith(this.getSignedKey())
				.compact();
	}

	public Claims extractAllClaims(String token) {
		return Jwts.parser()
				.verifyWith(this.getSignedKey())
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}

	public boolean verifyToken(String token) {
		return !extractAllClaims(token).getExpiration().before(new Date());
	}
}