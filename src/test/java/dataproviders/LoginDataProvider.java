package dataproviders;

import org.testng.annotations.DataProvider;
import utils.TestDataReader;

public class LoginDataProvider {

    @DataProvider(name = "loginNegativeData")
    public static Object[][] getNegativeLoginData() {
        return new Object[][] {
                {
                        TestDataReader.getData("login.scenario1.username"),
                        TestDataReader.getData("login.scenario1.password"),
                        TestDataReader.getData("login.scenario1.error")
                },
                {
                        TestDataReader.getData("login.scenario2.username"),
                        TestDataReader.getData("login.scenario2.password"),
                        TestDataReader.getData("login.scenario2.error")
                },
                {
                        TestDataReader.getData("login.scenario3.username"),
                        TestDataReader.getData("login.scenario3.password"),
                        TestDataReader.getData("login.scenario3.error")
                },
                {
                        TestDataReader.getData("login.scenario4.username"),
                        TestDataReader.getData("login.scenario4.password"),
                        TestDataReader.getData("login.scenario4.error")
                }
        };
    }
}