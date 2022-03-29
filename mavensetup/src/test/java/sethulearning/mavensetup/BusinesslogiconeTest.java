package sethulearning.mavensetup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BusinesslogiconeTest {
	
	
	@Test(dependsOnMethods={"testMethod2"},dataProvider="getData")
	
	public void testMethod1(String username,String Password)
	{
		System.out.println("Test Method one logic executed");
		System.out.println("Username"+username);
		System.out.println("Password"+Password);
	}
	
	
	@Test
	public void testMethod2() throws IOException
	{
		String path=System.getProperty("user.dir");
		System.out.println(path);
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\sseth\\MavenProject1\\mavensetup\\src\\test\\java\\utils\\config.properties");
		prop.load(fis);
		System.out.println("get property"+prop.getProperty("browser"));
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\sseth\\MavenProject1\\mavensetup\\src\\test\\java\\utils\\config.properties");
		prop.setProperty("browser", "firefox");
		prop.store(fos, null);
		System.out.println("Test Method two logic executed");
	}
	
	
	@DataProvider
	public Object[][] getData()
	
	{
		
		Object[][]creds=new Object[3][2];
		creds[0][0]="u1";
		creds[0][1]="p1";
		
		/*creds[1][0]="u2";
		creds[1][1]="p2";
		
		creds[2][0]="u3";
		creds[2][1]="p3";*/
		
		return creds;
		
	}
	
	

}
