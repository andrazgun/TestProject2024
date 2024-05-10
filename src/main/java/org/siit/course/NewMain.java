package org.siit.course;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class NewMain {

    public static String getRandomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public static void main(String[] args) {

        System.out.println(RandomStringUtils.randomAlphanumeric(17).toUpperCase());
        System.out.println("---------------");
        System.out.println(RandomStringUtils.randomAlphanumeric(17));


        System.out.println(getRandomString());
    }
}
