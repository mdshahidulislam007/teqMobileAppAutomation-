package com.TeqApp.pageObjects;

import org.openqa.selenium.By;

import com.TeqApp.testCases.BaseClass;

public class tripsPageObjects extends BaseClass{

	//public By agreeBtn = By.id("app.ferdia.ferdiadriver.qa:id/agreeButton");
	//public By signinBtn = By.id("app.ferdia.ferdiadriver.qa:id/btn_login");

	public By locPermission = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
	public By cancelWritePermission = By.id("android:id/button2");
	//public By playBtn = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.ImageView[2]");

	public By newTab = By.xpath("//android.widget.LinearLayout[@content-desc=\"New\"]/android.widget.TextView");

	public By backBtn = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");

	public By reportIncident = By.id("app.ferdia.ferdiadriver.qa:id/btn_report_incident");
	public By normalTripId = By.id("app.ferdia.ferdiadriver.qa:id/tv_trip_no");

	public By driveTab = By.xpath("//android.widget.LinearLayout[@content-desc=\"Drive\"]/android.widget.TextView");
	public By acceptBtn = By.id("app.ferdia.ferdiadriver.qa:id/btn_accept");
	public By startBtn = By.id("app.ferdia.ferdiadriver.qa:id/btn_accept");
	public By okBtn = By.id("app.ferdia.ferdiadriver.qa:id/tv_confirm_dialog_submit");
	public By arrievToCustomerBtn = By.id("app.ferdia.ferdiadriver.qa:id/btn_accept");
	public By pickedUpCustomerBtn = By.id("app.ferdia.ferdiadriver.qa:id/btn_accept");
	public By reachedDestinationBtn = By.id("app.ferdia.ferdiadriver.qa:id/btn_accept");
	public By returnBtn = By.id("app.ferdia.ferdiadriver.qa:id/btn_accept");
	public By endBtn = By.id("app.ferdia.ferdiadriver.qa:id/btn_accept");








	public By actualBtn = By.id("app.ferdia.ferdiadriver.qa:id/tv_assignment_details_show_actual_time");
	public By fixedtripId = By.id("app.ferdia.ferdiadriver.qa:id/tv_trip_name");


	public By acceptShift = By.id("app.ferdia.ferdiadriver.qa:id/tv_assignment_details_trip_accept");
	public By startShift = By.id("app.ferdia.ferdiadriver.qa:id/tv_assignment_details_trip_start");
	public By startTrip = By.id("app.ferdia.ferdiadriver.qa:id/tv_assignment_details_trip_start");
	public By paxInput = By.id("app.ferdia.ferdiadriver.qa:id/confirm_dialog_input");
	public By confirmBtn = By.id("app.ferdia.ferdiadriver.qa:id/confirm_dialog_button_positive");
	public By endTrip = By.id("app.ferdia.ferdiadriver.qa:id/tv_individual_trip_end");
	public By backToGarage = By.id("app.ferdia.ferdiadriver.qa:id/tv_back_to_garage");
	public By reachedGarage = By.id("app.ferdia.ferdiadriver.qa:id/tv_reached_at_garage");







	public void givePermission() throws Exception {
		//clickElement(locPermission);
		clickElement(cancelWritePermission);

	}

	public void normalTrip() throws Exception {

		clickElement(newTab);

		int n=1;

		while(true) {

			String a = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout["+n+"]/android.widget.RelativeLayout/android.widget.ImageView[2]";

			By playBtn = By.xpath(a);

			clickElement(playBtn);

			boolean y = isPresent(driver,normalTripId);
			System.out.println(y);


			if(y==true)
			{
				String normalTripName = driver.findElement(normalTripId).getText();

				if(normalTripName.equals("BT-000745-S01-N002"))
				{
					System.out.println("Normal trip found");
					System.out.println(n);
					clickElement(driveTab);
					clickElement(acceptBtn);
					clickElement(startBtn);
					clickElement(okBtn);
					clickElement(arrievToCustomerBtn);
					clickElement(pickedUpCustomerBtn);
					clickElement(reachedDestinationBtn);
					clickElement(returnBtn);
					clickElement(endBtn);
					break;
				}else {
					n++;
					clickElement(backBtn);
				}

			}
			else if(y==false)
			{
				n++;
				clickElement(backBtn);
			}


		}

	}

	public void fixedTrip() throws Exception {

		clickElement(newTab);

		int n=1;

		while(true) {

			String a = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout["+n+"]/android.widget.RelativeLayout/android.widget.ImageView[2]";

			By playBtn = By.xpath(a);

			clickElement(playBtn);

			boolean x = isPresent(driver,fixedtripId);


			if(x==true) 
			{
				String tName = driver.findElement(fixedtripId).getText();

				if(tName.equals("BT-F151-R01")) 
				{
					System.out.println("Fixed trip found");
					System.out.println(n);
					clickElement(acceptShift);
					clickElement(startShift);
					clickElement(okBtn);
					clickElement(startTrip);
					verifyElementAndDataEntry(driver, paxInput,"20");
					clickElement(confirmBtn);
					clickElement(endTrip);
					clickElement(backToGarage);
					clickElement(reachedGarage);

					break;
				}else {
					n++;
					clickElement(backBtn);
				}

			}
			else if(x==false) {
				n++;
				clickElement(backBtn);
			}

		}


	}




}
