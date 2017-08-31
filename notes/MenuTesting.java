package MenuTest;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.relevantcodes.extentreports.ExtentReports;

import common_Function.RW;

public class MenuTesting extends RW {

	int i;

	List<String> arrayListPass = new ArrayList<String>();
	List<FailScreenshot_class> arrayListFail = new ArrayList<FailScreenshot_class>();
	List<String> arrayListNotAccessible = new ArrayList<String>();
	List<String> arrayListNotApplicable = new ArrayList<String>();

	String SShot = "";
	int sshot_no = 0;
	private static ExtentReports report;
	int CountPass = 0, CountFailed = 0, CountNotAccessible = 0, CountNotApplicble = 0;

	public synchronized static ExtentReports getReporter(String filePath) {
		if (report == null) {
			report = new ExtentReports(path.concat("Report.html"));

			report.addSystemInfo("Host Name", "Reshma").addSystemInfo("Environment", "QA");
		}

		return report;
	}

	public void MenuTestingByUrl(WebDriver driver1) throws Exception {

		ArrayList<Row> row1 = menu_testing_reqrd.searchSheet("VKT", 0, 0);

		String url1 = "";

		for (int i = 0; i < row1.size(); i++)

		{
			WebDriver driver = driver1;

			String title = driver.getTitle();

			try {

				String test = row1.get(i).getCell(3).toString();
				if (test.compareTo("x") == 0) {
					url1 = url.concat(row1.get(i).getCell(1).toString());

					driver.get(url1);
					Thread.sleep(k);

					String title1 = driver.getTitle();

					try {
						Boolean LOGO = driver.findElement(By.xpath(".//*[@id='aspnetForm']/div[3]/div[1]/div[1]/img"))
								.isDisplayed();

						if (LOGO.FALSE) {

							String URL_Error = driver.getCurrentUrl();
							SShot(driver);

						} else {
							if (title1.equalsIgnoreCase("Home Page")) {
								CountNotAccessible++;
								arrayListNotAccessible.add(url1);

							} else {

								CountPass++;
								arrayListPass.add(url1);
							}

						}
					} catch (Exception e) {

						String FailscrnShot = SShot(driver);

						CountFailed++;

						FailScreenshot_class a = new FailScreenshot_class();
						a.url = url1;
						a.screnshotpath = FailscrnShot;

						arrayListFail.add(a);

					}
					Thread.sleep(4000);

				} else {

					CountNotApplicble++;
					arrayListNotApplicable.add(url1);

				}
			} catch (Exception e) {

				SShot(driver);

			}
			Thread.sleep(k);

		}

		System.out.println("Total Count of URL:" + row1.size());
		System.out.println("Menus Passed:" + CountPass);
		System.out.println("Menus Not Applicable :" + CountNotApplicble);
		System.out.println("Menus Without Access :" + CountNotAccessible);
		System.out.println("Menus Failed :" + CountFailed);

		System.out.println("--------------------------------------------------------------------------------------");

		System.out.println("Pass URL :");
		for (String strPassURL : arrayListPass) {

			System.out.println(strPassURL);
		}
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("Fail URL :");
		for (FailScreenshot_class strPassFail : arrayListFail) {

			System.out.println(strPassFail.url + "(Refer screenshot : )" + strPassFail.screnshotpath);
		}

		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("Menu Not Applicable :");
		for (String strAccessNotApplicable : arrayListNotApplicable) {

			System.out.println(strAccessNotApplicable);
		}
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("Menus Not Accessible :");

		for (String strAccessNotAccessible : arrayListNotAccessible) {

			System.out.println(strAccessNotAccessible);
		}

		try {

			PrintStream Myconsole = new PrintStream(
					new File("C:\\Users\\Tester\\Desktop\\workspace\\MenuByLinks\\Console.txt"));

			System.setOut(Myconsole);

			System.out.println("Total Count of URL:" + row1.size());
			System.out.println("Menus Passed:" + CountPass);
			System.out.println("Menus Not Applicable :" + CountNotApplicble);
			System.out.println("Menus Without Access :" + CountNotAccessible);
			System.out.println("Menus Failed :" + CountFailed);

			System.out.println("Pass URL :");
			for (String strPassURL : arrayListPass) {

				System.out.println(strPassURL);
			}
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println("Fail URL :");
			for (FailScreenshot_class strPassFail : arrayListFail) {

				System.out.println(strPassFail.url + " " + strPassFail.screnshotpath);
			}

			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println("Menu Not Applicable :");
			for (String strAccessNotApplicable : arrayListNotApplicable) {

				System.out.println(strAccessNotApplicable);
			}
			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.println("Menus Not Accessible :");

			for (String strAccessNotAccessible : arrayListNotAccessible) {

				System.out.println(strAccessNotAccessible);

			}

			Myconsole.flush();

		} catch (FileNotFoundException fx) {
			System.out.println(fx);
		}

	}

	public String SShot(WebDriver driver1) throws IOException, AWTException {
		String ScreenshotName = "ABCD" + (i++) + ".jpg";

		String failScreenshot = Scrnshot.concat(ScreenshotName);
		WebDriver driver = driver1;

		Robot robot = new Robot();

		BufferedImage screenshot = robot
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

		ImageIO.write(screenshot, "JPG", new File(failScreenshot));

		return ScreenshotName;

	}

}
