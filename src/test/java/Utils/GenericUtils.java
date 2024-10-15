package Utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

public class GenericUtils {
    //random String method
    public static String createRandomStringOne(int charCount) {
        StringBuilder sb = new StringBuilder();
        String charset = "abc123!@#";
        for (int i = 0; i < charCount; i++) {
            Random r = new Random();
            char x = charset.toCharArray()[r.nextInt(charset.length())]; //takes x as random char and append to sb
            sb.append(x);
        }
        System.out.println(sb);
        return sb.toString();
    }
    public static String createRandomStringTwo(int stringLength) {
        String randomString = RandomStringUtils.randomAlphanumeric(stringLength);
        System.out.println(randomString);
        return randomString;
    }

    public static String createRandomEmail(int stringLength) {
        String randomEmail = RandomStringUtils.randomAlphanumeric(stringLength) + "@yopmail.com";
        System.out.println(randomEmail);
        return randomEmail;
    }

    public static String createBaseUrl (String configFile) { //url from config
        String urlBase = "";
        try {
            Properties appProps = new Properties();
            appProps.load(Files.newInputStream(Path.of(configFile)));
            urlBase = appProps.getProperty("protocol") + "://" + appProps.getProperty("hostname");
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
        return urlBase;
    }

    public static String getBrowserFromConfig (String configFile) { //browser from config

        System.out.println(ConfigUtils.getGenericValue(configFile,"browser", "FIREFOX"));
        return ConfigUtils.getGenericValue(configFile,"browser", "FIREFOX");
    }

    public static Boolean getInsecureCertOptionsFromConfig (String configFile) {
        String value = ConfigUtils.getGenericValue(configFile,"acceptInsecureCerts", "false");
        System.out.println("Accept insecure certificates: " + value);
        return Boolean.parseBoolean(value);
    }

    public static Boolean isHeadlessEnabled(String configFile) {
        String value = ConfigUtils.getGenericValue(configFile,"headlessMode", "false");
        System.out.println("Headless mode: " + value);
        return Boolean.parseBoolean(value);
    }

    public static Boolean isProxyEnabled(String configFile) {
        System.out.println("Proxy enabled: " + Boolean.parseBoolean(ConfigUtils.getGenericValue(configFile, "proxyEnabled", "false")));
        return Boolean.parseBoolean(ConfigUtils.getGenericValue(configFile, "proxyEnabled", "false"));
    }

    public static boolean isDownloadDirectoryEnabled(String configFile) {
        System.out.println("Download directory enabled: " + Boolean.parseBoolean(ConfigUtils.getGenericValue(configFile, "downloadDirectoryEnabled", "false")));
        return Boolean.parseBoolean(ConfigUtils.getGenericValue(configFile, "downloadDirectoryEnabled", "false"));
    }

    public static Boolean startMaximized(String configFile) {
        System.out.println("Start maximized: " + Boolean.parseBoolean(ConfigUtils.getGenericValue(configFile, "startMaximized", "false")));
        return Boolean.parseBoolean(ConfigUtils.getGenericValue(configFile, "startMaximized", "false"));
    }

    public static void printCookies(WebDriver driver) {
        Set<Cookie> cookies = driver.manage().getCookies(); //Set<> because cookies are unique in a list
        System.out.println("Cookies found: " + cookies.size());

        for (Cookie c : cookies) {
            System.out.println("Cookie name: " + c.getName());
            System.out.println("--> value: " + c.getValue());
            System.out.println("--> domain: " + c. getDomain());
            System.out.println("--> path: " + c.getPath());
            System.out.println("--> expires: " + c.getExpiry());
            System.out.println("---------------------------------");
        }
    }
    public static String getDBHostname(String configFile){
        return ConfigUtils.getGenericValue(configFile, "dbHostname", "");
    }

    public static String getDBUser(String configFile){
        return ConfigUtils.getGenericValue(configFile, "dbUser", "");
    }

    public static String getDBPassword(String configFile){
        return ConfigUtils.getGenericValue(configFile, "dbPassword", "");
    }

    public static String getDBPort(String configFile){
        return ConfigUtils.getGenericValue(configFile, "dbPort", "3306");
    }

    public static String getDBSchema(String configFile){
        return ConfigUtils.getGenericValue(configFile, "dbSchema", "");
    }



}
