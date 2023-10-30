package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {


	
   @Test(dataProvider = "getData")
   public void addProductToCart(String Name, int price , int quantity ,String model )
   {
	   System.out.println("phn name is -"+Name+"price- "+price+"quanity-"+quantity+"model-"+model);
   }
   
   @DataProvider
   public Object[][] getData()
   {
	   Object[][] data=new Object[3][4]; //3 sets of data with 4 details in each set
	                                       //that is 3 rows with 4 columns
	   data[0][0]="Samsung";
	   data[0][1]=10000;
	   data[0][2]=20;
	   data[0][3]="A80";
	   
	   data[1][0]="Samsung";
	   data[1][1]=10000;
	   data[1][2]=20;
	   data[1][3]="A80";
	   
	   data[2][0]="Samsung";
	   data[2][1]=10000;
	   data[2][2]=20;
	   data[2][3]="A80";
	   
	   return data;
	   
   }

}
