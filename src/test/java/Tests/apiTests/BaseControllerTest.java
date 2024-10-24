package Tests.apiTests;

import Utils.ConstantUtils;
import Utils.GenericUtils;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseControllerTest {
    String usedConfig = ConstantUtils.CONFIG_API;
    String apiVersion, baseURL;

    @BeforeClass
    public void setUp(){
        apiVersion = GenericUtils.getapiVersion(usedConfig);
        baseURL = GenericUtils.createBaseUrl(usedConfig);
        System.out.println("Use next baseurl: " + baseURL);
        System.out.println("Use next apiVersion: " + apiVersion);

//       set up rest assured based hostname
        RestAssured.baseURI = baseURL + "/" + apiVersion;
    }
}
