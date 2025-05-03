package utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders
{
	 @DataProvider(name = "LoginData")
	    public String[][] getData(Method method) throws IOException {
	        String path = ".\\testData\\Data.xlsx"; //taking xl file from testData
	       
			ExcelUtility xlutil = new ExcelUtility(path, "Sheet1"); //creating an object for ExcelUtility
	        int totalrows = xlutil.getRowCount();
	        int totalcols = xlutil.getColCount();
	        
	        String logindata[][] = new String[totalrows -1][totalcols]; //created for 2 dimension array which can store

	        for (int i=1;i<totalrows;i++) //1 read the data from xl storing in 2 dimensional array
	        {
	            for (int j=0;j<totalcols;j++) //0   i is rows and j is col
	            {
	                logindata[i-1][j] = xlutil.getCellData(i, j);  // 1,0
	            }
	        }  
	        return logindata;  //returning 2 dimensional array
	    }
	
	
	
}
