package runnermaven.org;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import base.com.Base_new;
import pom.demo.BookAHotel;
import pom.demo.Booked_Itinerary;
import pom.demo.BookingConfirmation;
import pom.demo.Login_POM;
import pom.demo.Search_Hotel;
import pom.demo.Select_Hotel;

public class Runner_DemoMaven extends Base_new {
	
	public static WebDriver driver=BrowserLaunch();
	
	public static void main(String[] args) throws Throwable   {
		
		Login_POM lp= new Login_POM(driver);//Parameterized Constructor
		
		Url("https://adactinhotelapp.com/");
		SendKeys(lp.getUser(),Read_data(0, 0));
		SendKeys(lp.getPass(),Read_data(0, 1));
		Thread.sleep(2000);
		click1(lp.getLogin());
		 
		 Search_Hotel sh=new  Search_Hotel(driver);
		 Selectby_Index(sh.getLocation(),2);
		 Selectby_Index(sh.getHotels(),1);
		 Selectby_Index(sh.getRoomtype(),2);
		 Selectby_Index(sh.getNumberofRooms(),2);
		 
		 sh.getCheckinDate().clear();
		 sh.getCheckinDate().sendKeys("21/02/2023");
		 //SendKeys(sh.getCheckinDate(),Read_data(1, 0));
		 
		 sh.getCheckoutDate().clear();
		 //SendKeys(sh.getCheckinDate(),Read_data(1, 1));
		 sh.getCheckoutDate().sendKeys("25/02/2023");
		 
		 Selectby_Index(sh.getAdultperroom(),2);
		 Selectby_Index(sh.getChildperroom(),2);
		 click1(sh.getSearch());
		 
		 Select_Hotel sh1=new Select_Hotel(driver);
		 click1( sh1.getSelect());
		 click1(sh1.getContinue());
		 
		 BookAHotel bh= new BookAHotel(driver);
		// bh.getName().sendKeys("John");
		 
		 SendKeys(bh.getName(),Read_data(1, 0)); 
		 SendKeys(bh.getLname(),Read_data(1, 1));
		// bh.getLname().sendKeys("smith");
		 SendKeys(bh.getBillingAddress(),Read_data(2, 0)); 
		 //bh.getBillingAddress().sendKeys("Chennai");
		 SendKeys(bh.getCreditCardNo(),Read_data(2, 1)); 
		// bh.getCreditCardNo().sendKeys("1234 5678 8765 4321");
		 Selectby_Index(bh.getCreditType(),1);
		 Selectby_Index(bh.getExpDate(),11);
		 Selectby_Index(bh.getExpYear(),9);
		 SendKeys(bh.getCVVNo(),Read_data(3, 0)); 
		 //bh.getCVVNo().sendKeys("567");
		 click1(bh.getBookNow());
		 
		 BookingConfirmation bc=new BookingConfirmation(driver);
		 Thread.sleep(10000);
		 bc.getMyItinerary().click();
		 
		 Booked_Itinerary bi= new  Booked_Itinerary(driver);
		 bi.getOrderid().click();
		
		 bi.getCancelSelected().click();
		 
		 Alert1();
		 
		 bi.getLogout().click();
		 
	}

}
