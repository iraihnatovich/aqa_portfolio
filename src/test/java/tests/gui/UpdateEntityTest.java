package tests.gui;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateEntityTest extends BaseTest {

    @Test
    public void uploadFileToCaseTest() {
        String fileForUpload = UpdateEntityTest.class.getClassLoader().getResource("TestTXTaqa.txt").getPath();

        Assert.assertTrue(
                dashboardPage.navigateAllCasesPage()
                        .openCase(setupCase)
                        .switchToAttachmentTab()
                        .chooseFileForAttachment(fileForUpload)
                        .isDocumentAttached()
        );
    }
}
