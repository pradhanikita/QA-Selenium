import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemo {
    public static void main(String[]args){
        WebDriver driver = new ChromeDriver();
        String Url = "https://www.saucedemo.com/";
        driver.get(Url);
        driver.manage().window().maximize();

        //Login to sauceDemo via sendkeys
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        //Login to Sauce Demo via system variables
        String username = System.getenv("SAUCE_DEMO_USERNAME");
        System.out.println(username);
        String password = System.getenv("SAUCE_DEMO_PASSWORD");
        System.out.println(password);
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();


        driver.close();

    }
}
