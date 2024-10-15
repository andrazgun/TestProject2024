package Tests.DataTests;

import Pages.DemoApp.LoginPage;
import Tests.ObjectModels.LoginModel;
import Utils.Tools;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class LoginDataTests extends BaseTest {

    //    JSON Data Provider
    @DataProvider(name = "jsonDp")
    public Iterator<Object[]> jsonDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>(); //list of objects
//      here is starting deserialization of json into LoginModel object
        ObjectMapper objectMapper = new ObjectMapper(); //mapping the json with ObjectMapper

        File f = new File("src\\test\\resources\\data\\testdata.json"); //loading the file
        LoginModel[] lms = objectMapper.readValue(f, LoginModel[].class); //mapping the file data as a list [] of LoginModel class

        for (LoginModel lm : lms)
            dp.add(new Object[]{lm}); //create an object that will add objects in data provider

        return dp.iterator();
    }
    @Test(dataProvider = "jsonDp")
    public void loginWithJsonTest(LoginModel lm) {
        printData(lm);
        loginActions(lm);
    }

    /*###############################3 Login with xml data #############################################*/
    private LoginModel unMarshallLoginModel(File f) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(LoginModel.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (LoginModel) jaxbUnmarshaller.unmarshal(f);
        } catch (JAXBException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    @DataProvider(name = "xmlDp")
    public Iterator<Object[]> xmlDpCollection() {
        File f = new File("src\\test\\resources\\data\\testdata.xml");
        Collection<Object[]> dp = new ArrayList<>();
        LoginModel lm = unMarshallLoginModel(f);
        dp.add(new Object[]{lm});
        return dp.iterator();
    }

    @Test(dataProvider = "xmlDp")
    public void loginWithXMLTest(LoginModel lm) {
        printData(lm);
        loginActions(lm);
    }


    //##################################read data from csv #####################################################
    @DataProvider(name = "CSVDataProvider")
    public Object[][] csvDataProvider() throws Exception {
        File csvFile = new File("src\\test\\resources\\data\\testdata.csv");

        Reader reader = Files.newBufferedReader(Paths.get(csvFile.getAbsolutePath()));
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> csvData = csvReader.readAll();
        Object[][] dp = new Object[csvData.size()][1];
        int usernamePoz = 0, passwordPoz = 1, userErrPoz = 2, passwordErrPoz = 3; //index for each string

        for (int i = 0; i < csvData.size(); i++) {
//          from csv we have: username,password,userErr,passwordErr
//            AllArgsConstructor used from LoginModel.java
            LoginModel lm = new LoginModel(csvData.get(i)[usernamePoz],
                    csvData.get(i)[passwordPoz], csvData.get(i)[userErrPoz],
                    csvData.get(i)[passwordErrPoz]);
//            equivalent code below using NoArgsConstructor
//            LoginModel lm = new LoginModel();
//            AccountModel ac = new AccountModel();
//            ac.setUsername(csvData.get(i)[usernamePoz]);
//            ac.setPassword(csvData.get(i)[passwordPoz]);
//            lm.setAccount(ac);
//            lm.setUserError(csvData.get(i)[userErrPoz]);
//            lm.setPasswordError(csvData.get(i)[passwordErrPoz]);

            dp[i] = new Object[]{lm};
        }
        return dp;
    }

    @Test(dataProvider = "CSVDataProvider")
    public void loginWithCSVTest(LoginModel lm) {
        printData(lm);
        loginActions(lm);
    }

    // ########################### read data from xlsx file #########################
    @DataProvider(name = "XLSXDataProvider")
    public Object[][] xlsxDataProvider() throws Exception {
        File xlsxFile = new File("src\\test\\resources\\data\\testdata.xlsx");
        int usernamePoz = 0, passwordPoz = 1, userErrPoz = 2, passwordErrPoz = 3;
        String[][] excelData = ExcelReader.readExcelFile(xlsxFile, "0", true, true);
        Object[][] dp = new Object[excelData.length][1];

        for (int i = 0; i < excelData.length; i++) {
//          from csv we have: username,password,userErr,passwordErr
            LoginModel lm = new LoginModel(excelData[i][usernamePoz],
                    excelData[i][passwordPoz], excelData[i][userErrPoz],
                    excelData[i][passwordErrPoz]);

            dp[i] = new Object[]{lm};
        }
        return dp;
    }

    @Test(dataProvider = "XLSXDataProvider")
    public void loginWithXLSXTest(LoginModel lm) {
        printData(lm);
        loginActions(lm);
    }
    // ###########################  read data from sql database ###########################
    @DataProvider(name = "SQLdp")
    public Iterator<Object[]> SQLDpCollection() {
        //        get DB connection settings
        System.out.println("Use dbHostname:" + dbHostname);
        System.out.println("Use dbUser:" + dbUser);
        System.out.println("Use dbPort:" + dbPort);
        System.out.println("Use dbPassword:" + dbPassword);
        System.out.println("Use dbSchema:" + dbSchema);

        Collection<Object[]> dp = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://" + dbHostname + ":" + dbPort
                    + "/" + dbSchema, dbUser, new String(base64.decode(dbPassword.getBytes()))); //create connection url to DB
            Statement statement = connection.createStatement(); //connect to DB
            ResultSet resultSet = statement.executeQuery("SELECT * FROM login_negative"); //query to DB
            while (resultSet.next()) {
                LoginModel lm = new LoginModel(getEscapedElement(resultSet, "username"),
                        getEscapedElement(resultSet, "password"),
                        getEscapedElement(resultSet, "usernameErr"),
                        getEscapedElement(resultSet, "passwordErr"));
                dp.add(new Object[]{lm});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dp.iterator();
    }

    private String getEscapedElement(ResultSet resultSet, String element) throws SQLException {
        return Tools.replaceElements(resultSet.getString(element), "''", "");
    }

    @Test(dataProvider = "SQLdp")
    public void loginWithDBTest(LoginModel lm) {
        printData(lm);
        loginActions(lm);
    }


    //    Utility methods
//methods used to show info related to login model
    private void printData(LoginModel lm) {
//        System.out.println("Access:username " + lm.getAccount().getUsername() +
//                        "/password: " + lm.getAccount().getPassword());
//        System.out.println("User error: " + lm.getUserError());
//        System.out.println("Password error: " + lm.getPasswordError());
        System.out.println(lm); //alternative way to print above data using LoginModel > toString() method
    }
    private void loginActions(LoginModel lm) {
        LoginPage loginPage = new LoginPage(driver);

//        open login page
        System.out.println("Open login page");
        driver.get(baseUrl + "practice-test-login/");

//        login
        loginPage.login(lm.getAccount().getUsername(), lm.getAccount().getPassword()); //getter from LoginModel and from AccountModel

        String expectedUsernameErr = lm.getUserError();
        String expectedPassErr = lm.getPasswordError();

        System.out.println("Verify expected errors present:\n expected userError:" + expectedUsernameErr);
        Assert.assertTrue(loginPage.checkErr(expectedUsernameErr, "userErr"));

        System.out.println("Expected Password Err:" + expectedPassErr);
        Assert.assertTrue(loginPage.checkErr(expectedPassErr, "passErr"));
    }


}
