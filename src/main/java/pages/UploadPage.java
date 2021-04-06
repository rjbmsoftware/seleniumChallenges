package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadPage extends BasePage<UploadPage> {

    @FindBy(id = "file-upload")
    WebElement fileUploadInput;

    @FindBy(id = "file-submit")
    WebElement uploadFileButton;

    @FindBy(id = "uploaded-files")
    WebElement uploadedImageName;

    @FindBy(css = "div.example > h3")
    WebElement pageHeading;

    public UploadPage(WebDriver webDriver) {
        super(webDriver);
        super.setUrl(super.getUrl() + "upload");
    }

    public UploadPage setUploadImagePath(String path) {
        fileUploadInput.sendKeys(path);
        return this;
    }

    public UploadPage clickUploadFileButton() {
        uploadFileButton.click();
        return this;
    }

    public String getPageHeadingText() {
        return pageHeading.getText();
    }

    public String uploadedImageNameText() {
        return uploadedImageName.getText();
    }
}
