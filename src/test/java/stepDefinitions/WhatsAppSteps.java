package stepDefinitions;
import Elements.WhatsappElements;
import common.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

import java.time.Duration;

import static common.CommonMethods.*;

public class WhatsAppSteps {
//    public WebDriver driver=CommonMethods.launch();

    @Given("I open WhatsApp web")
    public void i_open_WhatsApp_web() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "D:\\Intallij\\WhatsApp\\chromedriver.exe");
//        driver = new ChromeDriver();
        CommonMethods.launch();
//        driver.get("https://web.whatsapp.com/");
//        driver.manage().window().maximize();
//        driver.get(CommonMethods.Hos);
//        System.out.println(appURL);
//        driver.manage().window().maximize();

//        clickElement("//div[text()='WhatsApp Web']");
//        System.out.println("Clicked trial");
//        Thread.sleep(30000);
        // You may need to implement logic to wait for the user to scan the QR code to log in.
    }


    
    @When("I select contact {string}")
    public void i_select_contact(String contactName) throws InterruptedException {
        clickElement(WhatsappElements.contact_search);
        enterText(WhatsappElements.enter_contact_name, contactName);
        driver.findElement(By.xpath(WhatsappElements.enter_contact_name)).sendKeys(Keys.BACK_SPACE);
        clickElement("//span[@title='"+contactName+"']");
        }
        // You may need to implement logic to wait for search results and select the desired contact.

    @And("I send message {string}")
    public void i_send_message(String message) throws InterruptedException {
        for(int i=1;i<=4;i++){
            enterText(WhatsappElements.type_msg, message);
            clickElement(WhatsappElements.send_btn);
        }
    }



    @Then("Message {string} is sent successfully")
    public void message_is_sent_successfully(String message) {
        // You may add assertions or verifications here to confirm the message was sent successfully.
    }

    @And("I close the browser")
    public void i_close_the_browser() {
        driver.quit();
    }

    @And("I send warn message {string}")
    public void iSendMessage(String message) throws InterruptedException {
        Thread.sleep(10000);
        enterText(WhatsappElements.type_msg, message);
        clickElement(WhatsappElements.send_btn);
        Thread.sleep(5000);
    }

//    @And("I send warn message:")
//    public void iSendWarnMessage(String multi_msg) throws InterruptedException {
//        enterText(WhatsappElements.type_msg, multi_msg);
//        clickElement(WhatsappElements.send_btn);
//        Thread.sleep(3000);
//    }
}
