package assertTesting;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Instant;

public class AssertionDemo {

    public static void main(String[]args){
        WebDriver driver = new ChromeDriver();
        String Url = "https://www.saucedemo.com/";
        driver.get(Url);
        driver.manage().window().maximize();

        //Login to sauceDemo via sendKeys
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        //select product and add to cart
        //bag
        WebElement expectedValue = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        Assert.assertNotNull("Sauce Labs Backpack not found", expectedValue);
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();

        //bike light
        WebElement actualValue = driver.findElement(By.xpath("//*[@id=\"item_0_title_link\"]/div"));
        Assert.assertNotNull("Sauce Labs Bike Light not found", actualValue);
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();

        //jacket
        WebElement givenValue = driver.findElement(By.xpath("//*[@id=\"item_5_title_link\"]"));
        Assert.assertNotNull("Sauce Labs Fleece Jacket not found", givenValue);
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();

        //remove from cart
        //bike light
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bike-light\"]")).click();

        //click on shopping cart button/icon
        WebElement cartItem = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]"));
        Assert.assertNotNull("Shopping Cart not found", cartItem);
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        //remove from my cart page
        //bag
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();

        //Click on checkout button
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

        //input the information
        driver.findElement(By.id("first-name")).sendKeys("Nikita");
        driver.findElement(By.name("lastName")).sendKeys("Pradhan");
        driver.findElement(By.name("postalCode")).sendKeys("42200");

        //checkout button
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();

        //finish button
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();

        //back to home button
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();

        //menu button
        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();

        //logout
        driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();



        driver.close();

    }
}


