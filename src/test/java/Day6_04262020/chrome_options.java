package Day6_04262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class chrome_options {

    public static void main (String[] args) throws InterruptedException {

//set the chrome path
        System.setProperty("webdriver.chrome.driver","source//resource//chromedriver83.exe");
//set some pre conditions using ChromeOptions
        ChromeOptions options= new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(4000);
        //I want to capture the title of that page
        //System.out.println("my title is" + driver.getTittle());
        //store your actutalTitle on a variable and then compare what you expected
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("MORTGAGE CALCULATOR & LOAN CALCULATOR")) {
            System.out.println("Title matches with expected");
        }else{
            System.out.println("Title doesnt match" + actualTitle);

        }//end of if else

        //now simply use fullscreen
        //driver.manage().window().fullscreen();
        //if same locator used more than once then store it as a WebElement variable to reuse it.
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
        //clear the field first
        pPrice.clear();
        //enter your new data

        pPrice.sendKeys("400000");
        //store your start month in Webelement variable and call it on your select command

        WebElement sMonth = driver.findElement(By.xpath("//*[@name='sm']"));
       //call my Select command and it only works when your dropdown locator is under select tag
       Select aMonthlist = new Select(sMonth);
       //select the drop down value vy visible text
        //sMonthlist.selectByValue("0");
        //sMonthlist.selectByIndex("1");
        aMonthlist.selectByVisibleText("Jul");
        //whenever drop down is not under tag then we must click on the dropdown and then
        //clcik on the value of the dropdown

        //let's verify some of the start year to make sure it's matching on the drop down
        String[] yearArray = new String[] {"2005","2015","2035"};
        for(int i =0;i < yearArray.length;i++){
            driver.findElement(By.xpath("//*[@name='sy']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[text()='"+yearArray[i]+"']")).click();
        }

        /* driver.findElement(By.xpath(*//*[@name='sy']")).click();
        Thread.sleep(1000)
        driver.findElement (By.Xpath(*//*[text()='2025']*)).click();*/


    }//end of main method
}//end of java class


