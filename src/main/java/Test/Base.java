package Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	private static final String BrowserSetup = null;
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chrome-win64\\chrome.exe");
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver = new ChromeDriver();
		
		// Go To URL
		driver.get("http://123.200.20.20:5302/");
		
		// maximize Web Page
		driver.manage().window().maximize();
		
		//driver.set_window_size(1024, 768)
		
		// Click the first job id
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='14/2023']")).click();	
		// Switch back to the original window/tab
		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
		 for (String handle : windowHandles) {
	            
			 //Switch to the new window/tab
	           driver.switchTo().window(handle);
	        }
		 
		//Click View icon
		 Thread.sleep(2000); 
         driver.findElement(By.xpath("//i[@class='bx bx-show']")).click();
        
         //Click Apply Online Button
         Thread.sleep(2000); 
         driver.findElement(By.xpath("//a[@class='btn btn-success btn-sm float-right']")).click();
        
         //Click Continue without Login
         Thread.sleep(2000);
         driver.findElement(By.linkText("Continue without Login")).click();
         
        ////////////////////////////////////Start Basic Information/////////////////////////////////////////////////
         
         // Set NID
         Thread.sleep(2000);
         driver.findElement(By.id("national_id")).sendKeys("8231771135");
        
         //Upload NATIONAL ID ATTACHMENT
         Thread.sleep(3000);
         driver.findElement(By.id("national_id_attachment")).sendKeys("C:\\Users\\Ekramul\\Desktop\\Ekramul Nid.JPG");
         Thread.sleep(5000);
         
         // click on the calendar
         driver.findElement(By.xpath("//input[@id='date_of_birth']")).click();
         WebDriverWait wait =new  WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("datetimepicker-input")));
         String aMonth = driver.findElement(By.xpath("//th[@title='Select Month']")).getText();
         
         //Set Selected year
         while(!(aMonth.equals("AUGUST 1995"))){
        	 
        	 driver.findElement(By.xpath("//span[@title='Previous Month']")).click();
        	 aMonth = driver.findElement(By.xpath("//th[@title='Select Month']")).getText();
        	
         }
         
         driver.findElement(By.xpath("//td[normalize-space()='23']")).click();
        
       //Click Verify NID Button
         Thread.sleep(2000);
         driver.findElement(By.xpath("//button[@id='nid_verification']")).click();
         
         //Set Father name
         Thread.sleep(7000);
         driver.findElement(By.xpath("//input[@id='father_name']")).sendKeys("Md Siddek Haq");
        
         //Set Mother name
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='mother_name']")).sendKeys("Amena Begum");
        Thread.sleep(2000);
        
        //Set Mobile Number 
        driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("01758871166");
        Thread.sleep(2000);
       
        //Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();
        
        //Print alert message.  
        System.out.println(alertMessage);
        
        // tream alert message. 
        System.out.println(alertMessage.substring(26,30));
       
        //alert accept
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
       
        //Set OTP
        Thread.sleep(2000);
        driver.findElement(By.id("otp")).sendKeys(alertMessage.substring(26,30));
        
        //alert accept
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        
       //Set  Email Address
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("ekramulcsediu2016@gmail.com");
        
        //Select  Marital Status
        Select dropdown = new Select(driver.findElement(By.id("marital_status")));  
        dropdown.selectByVisibleText("SINGLE"); 
        Thread.sleep(2000);
      
        //Select  Religion
        Select dropdown1 = new Select(driver.findElement(By.id("religion")));  
        dropdown1.selectByVisibleText("ISLAM");
        
         //Upload PHOTO (300PX X 300PX) (UPTO 100KB) 
        driver.findElement(By.xpath("//input[@id='photo']")).sendKeys("C:\\Users\\Ekramul\\Desktop\\Pic_300.jpg");
        Thread.sleep(2000);
        //Upload SIGNATURE (300PX X 80PX) (UPTO 60KB)
        driver.findElement(By.xpath("//input[@id='signature']")).sendKeys("C:\\Users\\Ekramul\\Desktop\\Sig_300.png");
        Thread.sleep(2000);
        //Upload QUOTA ATTACHMENT (UPTO 600KB)
        driver.findElement(By.xpath("//input[@id='quota_attachment']")).sendKeys("C:\\Users\\Ekramul\\Desktop\\QUOTA ATTACHMENT.JPG");
        Thread.sleep(2000);
        
        //Fill Up Basic Information Then Click Next Button
        Thread.sleep(5000);
	    driver.findElement(By.xpath("//button[@value='first']")).click();
	    ////////////////////////////////////End Basic Information /////////////////////////////////////////////////
	  
	    
       //////////////////////////////////// Start Address /////////////////////////////////////////////////
	    
	    //Select  permanent division
        Select division = new Select(driver.findElement(By.id("permanent_division")));  
        division.selectByVisibleText("DHAKA"); 
        Thread.sleep(3000);
        
        //Select  permanent district
        Select district = new Select(driver.findElement(By.id("permanent_district")));  
        district.selectByVisibleText("DHAKA"); 
        Thread.sleep(5000);
        
        
        WebElement dropdown11 = driver.findElement(By.className("select2-selection__rendered"));

        // Click on the dropdown to open the options
        dropdown11.click();

        // Find and click the specific option (e.g., "SAVAR")
        WebElement option = driver.findElement(By.xpath("//li[contains(text(), 'SAVAR')]"));
        option.click();
      
     // Find the select2 dropdown trigger
        WebElement dropdownTrigger = driver.findElement(By.className("selection"));

        // Click on the trigger to open the dropdown
        dropdownTrigger.click();
        
        driver.findElement(By.id("select2-permanent_thana-container")).click();

        // Find all options in the dropdown
        List<WebElement> options = driver.findElements(By.className("select2-selection"));
        //Set post office
        Thread.sleep(2000);
        driver.findElement(By.id("permanent_post_office_name")).sendKeys("DHAKA");
        
        
      //Set post Code
        Thread.sleep(2000);
        driver.findElement(By.id("permanent_post_code")).sendKeys("2216");
     
        Thread.sleep(2000);
        //Set permanent_village
        driver.findElement(By.id("permanent_village")).sendKeys("DEBGRAM");
       
        Thread.sleep(2000);
        //Set permanent_address
        driver.findElement(By.id("permanent_village_bng")).sendKeys("দেবগ্রাম");
       
        //Set permanent_village_bng
        Thread.sleep(2000);
        driver.findElement(By.id("permanent_address")).sendKeys("WEST KAZIPARA, MIRPUR 10 DHAKA 1216.");
        
        Thread.sleep(2000);
        //permanent_address_bng Clear
        driver.findElement(By.id("permanent_address_bng")).clear();
        
       
        //Set permanent_address_bng
        Thread.sleep(5000);
        driver.findElement(By.id("permanent_address_bng")).sendKeys("পশ্চিম কাজীপাড়া, মিরপুর 10 ঢাকা 1216");
       
       
        //Click Same As Permanent Address
        Thread.sleep(5000);
        driver.findElement(By.xpath("//label[@for='same_as_permanent_address']")).click();
        
      //Click next Button
        Thread.sleep(5000);
       driver.findElement(By.xpath("//div[@id='enable_after_district_verification']//button[@type='button'][normalize-space()='Next']")).click();
      ////////////////////////////////////End Address /////////////////////////////////////////////////
	
	
       ////////////////////////////////////Start Education /////////////////////////////////////////////////
      
     // Select HSC Exam
       Thread.sleep(2000);
       Select education = new Select(driver.findElement(By.id("education_0_exam")));  
       education.selectByVisibleText("HSC"); 
       
       
       // Find the dropdown element by its class name
       Thread.sleep(2000);
       WebElement dropdown12 = driver.findElement(By.id("select2-education_0_subject-container"));
     
       // Click on the dropdown to open the options
       Thread.sleep(2000);
       dropdown12.click();

       // Find and click the specific option (e.g., "Science")
       Thread.sleep(2000);
       WebElement option12 = driver.findElement(By.xpath("//li[contains(text(), 'Science')]"));
       option12.click();
       

       
       //Select Board
       Thread.sleep(2000);
       WebElement  KhulnaBoard= driver.findElement(By.id("select2-education_0_exam_body-container"));

       // Click on the dropdown to open the options
       KhulnaBoard.click();

       // Find and click the specific option (e.g., "BIT, KHULNA")
       Thread.sleep(2000);
       WebElement khulna = driver.findElement(By.xpath("//li[contains(text(), 'BIT, KHULNA')]"));
       khulna.click();
     

       //Click Calendar
       Thread.sleep(2000);
       driver.findElement(By.id("education_0_passing_year")).click();
    
       //Set Year
       Thread.sleep(2000);
       driver.findElement(By.xpath("//span[@class='year active']")).click();
       
     
       //Set CGPA
       Thread.sleep(2000);
        WebElement cgpa = driver.findElement(By.id("select2-education_0_result_type-container"));

       // Click on the dropdown to open the options
        cgpa.click();

       // Find and click the specific option (e.g., "GPA OUT OF 5.00")
        Thread.sleep(2000);
       WebElement gpa = driver.findElement(By.xpath("//li[contains(text(), 'GPA OUT OF 5.00')]"));
       gpa.click();
       

       //Set RESULT
       Thread.sleep(2000);
       driver.findElement(By.id("education_0_result")).sendKeys("4");
       
       
      // Select SSC Exam
       Thread.sleep(2000);
       Select education2 = new Select(driver.findElement(By.id("education_1_exam")));  
       education2.selectByVisibleText("SSC"); 
      
     
       
   
       ///Select Subject
       Thread.sleep(2000);
       WebElement education1 = driver.findElement(By.id("select2-education_1_subject-container"));
       // Click on the dropdown to open the options
       education1.click();
       // Find and click the specific option (e.g., "Science")
       Thread.sleep(2000);
       WebElement Science1 = driver.findElement(By.xpath("//li[contains(text(), 'Science')]"));
       Science1.click();
      
           
     //Select Board
    // Find the dropdown element by its ID
       Thread.sleep(2000);
       WebElement board1 = driver.findElement(By.id("select2-education_1_exam_body-container"));
       // Click on the dropdown to open the options
       board1.click();
       // Find and click the specific option (e.g., "DHAKA BOARD")
       Thread.sleep(2000);
       WebElement dhaka1 = driver.findElement(By.xpath("//li[contains(text(), 'DHAKA BOARD')]"));
       dhaka1.click();
      
       
     //Click Calendar
       driver.findElement(By.id("education_1_passing_year")).click();
       Thread.sleep(2000);
       //Set Year
       Thread.sleep(2000);
       driver.findElement(By.xpath("//span[normalize-space()='2022']")).click();
       
     
      // Set CGPA
       Thread.sleep(2000);
       WebElement result1 = driver.findElement(By.id("select2-education_1_result_type-container"));
       // Click on the dropdown to open the options
       result1.click();
       // Find and click the specific option (e.g., "GPA OUT OF 5.00")
       Thread.sleep(2000);
       WebElement gpa1 = driver.findElement(By.xpath("//li[contains(text(), 'GPA OUT OF 5.00')]"));
       gpa1.click();
     
       //Set RESULT
       driver.findElement(By.id("education_1_result")).sendKeys("4");
       Thread.sleep(2000);
    
       //Click Next Button
       driver.findElement(By.xpath("//div[@id='nextButtonContainer']//button[@type='button'][normalize-space()='Next']")).click();
       Thread.sleep(5000);
       ////////////////////////////////////End Education ///////////////////////////////////////////////// 
       
       
    ////////////////////////////////////Add Job Experience ///////////////////////////////////////////////// 
       Thread.sleep(2000);
       driver.findElement(By.id("jobexperience_0_organization")).sendKeys("ARENA PHONE BD LTD");
    
    
    // Set DESIGNATION
    Thread.sleep(2000);
    WebElement jobexperience = driver.findElement(By.id("select2-jobexperience_0_designation-container"));
    // Click on the dropdown to open the options
    jobexperience.click();
    
    // Find and click the specific option (e.g., "3RD ENGINEER")
    Thread.sleep(2000);
    WebElement desination = driver.findElement(By.xpath("//li[contains(text(), '3RD ENGINEER')]"));
    desination.click(); 
   
    
   // Set jobexperience
    Thread.sleep(5000);
    WebElement startDateInput = driver.findElement(By.id("jobexperience_0_start_date"));

    // Set the date value using the sendKeys method
    Thread.sleep(3000);
    startDateInput.sendKeys("01/01/2017"); // Adjust the date as needed
    
    // Check END DATE
    Thread.sleep(2000);
    driver.findElement(By.xpath("//tbody/tr[@role='row']/td[@role='cell']/div[1]/input[1]")).click();
    
  
    // Set Address
    Thread.sleep(2000);
    driver.findElement(By.id("jobexperience_0_address")).sendKeys("Dhaka");
   
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@class='btn btn-secondary jobExpNext nextBtn']")).click();
    ////////////////////////////////////End Job Experience ///////////////////////////////////////////////// 
	
	
    
    
    ////////////////////////////////////Add Certificate ///////////////////////////////////////////////// 
    // Set Course
    Thread.sleep(2000);
    WebElement training = driver.findElement(By.id("select2-training_0_course-container"));

    // Click on the dropdown to open the options
    training.click();
    Thread.sleep(2000);
    // Find and click the specific option (e.g., "Diploma")
    WebElement diploma = driver.findElement(By.xpath("//li[contains(text(), 'Diploma')]"));
    diploma.click();
    
   
    // Set DURATION
    Thread.sleep(2000);
    driver.findElement(By.id("training_0_duration")).sendKeys("3");
    
    
   // Set Course
    Thread.sleep(2000);
    Select year = new Select(driver.findElement(By.id("training_0_type")));  
    year.selectByVisibleText("YEAR"); 
    
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@class='btn btn-secondary trainingExpNext nextBtn']")).click();

    ////////////////////////////////////End Certificate /////////////////////////////////////////////////
    
    
     ////////////////////////////////////SartComplete /////////////////////////////////////////////////
    driver.findElement(By.xpath("//label[@for='accepted']")).click();

    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@name='completeBtn']")).click();
    //Thread.sleep(2000);
    //driver.findElement(By.xpath("/html/body")).click();
    
   
    
	}
}

