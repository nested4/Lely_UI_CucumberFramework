package com.lely.step_definitions;

import com.lely.pages.TechDocumentsPage;
import com.lely.utilities.BrowserUtils;
import com.lely.utilities.ConfigurationReader;
import com.lely.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Set;

public class TechDocs_StepDefinitions {
    TechDocumentsPage techDocumentsPage = new TechDocumentsPage();
    String filename="";
    List<String> filesBeforeDownload;
    @Given("user navigates to {string}")
    public void user_navigates_to(String string) {
        techDocumentsPage.navigateToTechDocsPage();
        techDocumentsPage.acceptCookies();
    }

    @When("user selects {string} from the dropdown")
    public void user_selects_from_the_dropdown(String documentName) {
        techDocumentsPage.selectDocFromDropdown(documentName);
    }

    @Then("user should be able to see the catalogs")
    public void user_should_be_able_to_see_the_catalogs() {

        Assert.assertTrue("Catalogs are not visible", techDocumentsPage.areCatalogsVisible());
    }

    @When("user views the document")
    public void user_views_the_document() {
        techDocumentsPage.viewThisDocumentButton.click();

    }

    @Then("the document should be opened in a new tab")
    public void the_document_should_be_opened_in_a_new_tab() {
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        Assert.assertEquals("Number of open tabs is not 2", 2, windowHandles.size());
    }

    @When("user return to the previous tab")
    public void user_return_to_the_previous_tab() {
        techDocumentsPage.switchToMainTab();
    }

    @When("user download the document")
    public void user_download_the_document() {
        filename= techDocumentsPage.getTheNameOfTheDocIntendedToDownload(techDocumentsPage.downloadDocumentButton);
        filesBeforeDownload= techDocumentsPage.getFileNamesInDownloadDirectory();
        // To check the file name, can be deleted
        System.out.println("filename = " + filename);
        // To check the file names in the users download folder,can be deleted
        System.out.println(filesBeforeDownload);
        techDocumentsPage.downloadDocumentButton.click();
    }

    @Then("the document should be downloaded")
    public void the_document_should_be_downloaded() {
        //Wait a litte for the document to be downloaded
        BrowserUtils.waitFor(5);
        Assert.assertTrue("File is not downloaded", techDocumentsPage.isFileDownloaded(filename,filesBeforeDownload));
    }
}
