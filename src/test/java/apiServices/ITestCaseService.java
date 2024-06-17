package apiServices;

import models.TestCase;

public interface ITestCaseService {
    TestCase getSingleCase(int caseID);

    TestCase addCase(TestCase testCase);

    int getCaseByInvalidId(int caseID);
}
