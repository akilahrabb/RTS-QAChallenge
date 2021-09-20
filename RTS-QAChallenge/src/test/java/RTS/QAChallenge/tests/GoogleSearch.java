package RTS.QAChallenge.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch{

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("RTS Labs" + Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3")).click();

        String expectedInTitle = "Custom Software Development";
        String actualTitle = driver.getTitle();

        if (actualTitle.startsWith(expectedInTitle)){
            System.out.println("Title verification PASSED!");
            System.out.println("We found the RTS Labs home page!");
        }else{
            System.err.println("Title verification FAILED!!!");
            System.out.println("expectedInTitle = " + expectedInTitle);
            System.out.println("actualTitle = " + actualTitle);
        }

        driver.close();

    }

}
