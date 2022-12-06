package com.example.Newsternews.AcceptanceTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.core.Is.is;

@Slf4j
public class MainPageTest {

    @Test
    public void testTitle(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://newster-news.com/");
        Assert.assertThat(driver.getTitle(),is("Newster News"));
        driver.quit();
    }

    @Test
    public void testMoveLoginPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://newster-news.com/");
        Thread.sleep(1000);
        WebElement loginBtn = driver.findElement(By.id("loginBtnId"));
        loginBtn.click();
        String actualUrl = "http://newster-news.com/login";
        Assert.assertThat(driver.getCurrentUrl(),is(actualUrl));
        driver.quit();
    }

    @Test
    public void testMoveUserPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://newster-news.com/login");
        Thread.sleep(1000);
        WebElement idField = driver.findElement(By.cssSelector("input[id='idField']"));
        WebElement pwField = driver.findElement(By.cssSelector("input[id='pwField']"));
        idField.sendKeys("hk486@nau.edu");
        pwField.sendKeys("1234");
        WebElement loginbtn = driver.findElement(By.cssSelector("button[class='loginbtn']"));
        loginbtn.click();
        Thread.sleep(3000);
        String actualUrl = "http://newster-news.com/user/Hyunsoo%20Kim";
        Assert.assertThat(driver.getCurrentUrl(),is(actualUrl));
        driver.quit();
    }

    @Test
    public void testSignUpPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://newster-news.com/login");
        Thread.sleep(1000);
        WebElement signUpbtn = driver.findElement(By.tagName("button"));
        signUpbtn.click();
        String actualUrl = "http://newster-news.com/";
        Assert.assertThat(driver.getCurrentUrl(),is(actualUrl));
        driver.quit();
    }
}
