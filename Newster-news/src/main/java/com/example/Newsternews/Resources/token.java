package com.example.Newsternews.Resources;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class token {
    public static String createToken(String input) {
        try {
            MessageDigest type = MessageDigest.getInstance("SHA-1");

            byte[] message = type.digest(input.getBytes());

            BigInteger temp = new BigInteger(1, message);

            String hashToken = temp.toString(16);
            while (hashToken.length() < 32) {
                hashToken = "0" + hashToken;
            }
            return hashToken;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}