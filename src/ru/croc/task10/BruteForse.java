package ru.croc.task10;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

public class BruteForse implements Callable {
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private final long start;
    private final String hashPass;
    private final long end = (long) Math.pow(26, 7);

    private final int step;

    private static final int ALPHABET = 26;
    private static final int LENGTH_PASSWORD = 7;

    public BruteForse(String hashPass, long start, int step) {
        this.start = start;
        this.step = step;
        this.hashPass = hashPass;
    }

    private String createPassword (Long n) {
        int[] helpMassive = new int[LENGTH_PASSWORD];
        for (int i = 0 ; i < LENGTH_PASSWORD; i++){
            helpMassive[i] = (int) (n % ALPHABET) ;
            n = n / ALPHABET;
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0 ; i < LENGTH_PASSWORD; i++){
            password.append((char) ('a' + helpMassive[i]));
        }
        return password.toString();
    }

    private static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(password.getBytes());
        byte[] bytes = digest.digest();
        return toHexString(bytes);
    }

    private static String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
            hex.append(HEX_DIGITS[b & 0x0f]);
        }
        return hex.toString();
    }

    @Override
    public String call(){
        for (long i = start; i < end; i+= step){
            if(hashPassword(createPassword(i)).equals(hashPass)) return createPassword(i);
        }
        return null;
    }
}
