package com.lely.pages;

import com.lely.utilities.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TechDocumentsPage extends BasePage {


    @FindBy(css =".select2-selection__arrow" )
    public WebElement dropdownArrow;

    @FindBy(css = ".select2-search__field")
    public WebElement searchInputBox;

    @FindBy(xpath = "//*[@class=\"result-item-title\"]")
    public List<WebElement> resultItemTitles;

    @FindBy(xpath = "((//footer[@class=\"result-item-footer\"])[1]//a)[2]")
    public  WebElement viewThisDocumentButton;

    @FindBy(xpath = "((//footer[@class=\"result-item-footer\"])[1]//a)[1]")
    public  WebElement downloadDocumentButton;

    /**
     * This method enables you select from dropdown menu
     * @param documentName
     */
    public void selectDocFromDropdown(String documentName) {
        dropdownArrow.click();
        BrowserUtils.waitFor(1);
        searchInputBox.sendKeys(documentName+Keys.ENTER);
    }

    /**
     * This method verifies if the search results visible or not
     * @return
     */
    public boolean areCatalogsVisible() {
        BrowserUtils.scrollToElement(resultItemTitles.get(0));
        BrowserUtils.waitForVisibility(resultItemTitles.get(0),4);
        return resultItemTitles.size() > 0;
    }

    /**
     * This method returns the name of the file intended to download
     * @param downloadButtonOfTheDocIntendedToDownload
     * @return
     */
    public String getTheNameOfTheDocIntendedToDownload(WebElement downloadButtonOfTheDocIntendedToDownload){
        String href= downloadButtonOfTheDocIntendedToDownload.getAttribute("href");
        String fileName = href.substring(href.indexOf("name=") + 5,href.indexOf(".pdf")+4);
        return fileName;
    }


    /**
     * This method get the all file names from the users downloads folder
     * @return
     */
    public List<String> getFileNamesInDownloadDirectory(){
        // Get the user's home directory
        String userHome = System.getProperty("user.home");

        // Specify the path to the Downloads folder
        String folderPath = userHome +"\\" + "Downloads";

        // Create a list for all the file names in the folder
        List<String> fileNames = new ArrayList<>();

        // Create a File object for the folder
        File folder = new File(folderPath);

        // Get the list of files in the folder
        File[] files = folder.listFiles();

        // Check if the folder is empty
        if (files == null || files.length == 0) {
            System.out.println("The folder is empty.");
        } else {
            // Add the names of all the files to the list
            for (File file : files) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                }
            }
        }
        return fileNames;
    }

    /**
     * This method checks if the file with the fileName downloaded in the users download folder
     * Takes the fileName and the file names in the download folder as parameters
     * @param fileName
     * @param filesBeforeDownload
     * @return
     */
    public boolean isFileDownloaded(String fileName, List<String> filesBeforeDownload) {

        List<String> filesAfterDownload = getFileNamesInDownloadDirectory();
        System.out.println(filesAfterDownload);

        // Compare the file lists
        if (filesAfterDownload.size() > filesBeforeDownload.size()) {
            // New file(s) have been added to the download directory
            if(filesAfterDownload.contains(fileName)){
                return true;// File is downloaded
            }
        }
        return false;  // File is not downloaded
    }




}
