package data;

import org.testng.annotations.DataProvider;

public class CaseTitleDataProvider {
    @DataProvider(name = "correctDataForTestCaseName")
    public static Object[][] correctDataForCaseName() {
        return new Object[][]{
                {"t"},
                {"59"},
                {"Entering valid data in testcase title"},
                {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                        "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                        "laboris nisi utQ"}, //199 chars
                {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                        "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                        "laboris nisi ut a"}, //200 chars
                {"!$&'()*+-/:;<=>?@[]^_`{|}~ # 123"},
        };
    }

    @DataProvider(name = "incorrectDataForTestCaseName")
    public static Object[][] incorrectDataForCaseName() {
        return new Object[][]{
                {""},
                {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                        "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                        "laboris nisi ut al"}, //201 chars
                {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                        "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                        "laboris nisi ut ali"}, //202 chars
                {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                        "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                        "laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit"}
        };
    }
}
