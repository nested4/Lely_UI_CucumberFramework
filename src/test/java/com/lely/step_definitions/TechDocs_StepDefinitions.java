package com.lely.step_definitions;

import com.lely.pages.TechDocumentsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class TechDocs_StepDefinitions {
    TechDocumentsPage techDocumentsPage = new TechDocumentsPage();

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
//        techDocumentsPage.viewThisDocumentButton.click();

    }

    @Then("the document should be opened in a new tab")
    public void the_document_should_be_opened_in_a_new_tab() {

    }

    @When("user return to the previous tab")
    public void user_return_to_the_previous_tab() {

    }

    @When("user download the document")
    public void user_download_the_document() {

    }

    @Then("the document should be downloaded")
    public void the_document_should_be_downloaded() {

    }
}
