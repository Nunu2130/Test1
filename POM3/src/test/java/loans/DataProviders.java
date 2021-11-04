package loans;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders 
{
	 
	//GIT practice , Playing games with Funeka :)
	
		//Data providers
		@Test(dataProvider = "getData")
		public void DataProvidersTest(String stFirstname , String stLastname, int stAge ,String stGender, String vStatus)
		{
			System.out.println("Student Data Base");
			System.out.println(stFirstname + " "+stLastname + " " +stAge+ " "+stGender+ " "+vStatus);
			
		}
				
		@DataProvider
		public Object [] getData()
		{
			//Iteration :
			//1st user name and pass - good credit history
			//2nd user name and pass - no credit history
			//3rd user name and pass - fraudulent credit history
			
			// define a multidimensional object array with 3 rows and 2 columns 
			// 3 rows for the number of test cases 
			//2 columns for the number of values passed in 
			
			Object[][] data =new Object [10][5];
			
			//1st set
			data[0][0] = "Louise";
			data[0][1] = "Gilbert";
			data[0][2] = 23;
			data[0][3] = "F";
			data[0][4] = "Is Vaccinated";
			
			//2nd set
			data[1][0] = "Gertrude";
			data[1][1] = "Masipa";
			data[1][2] = 13;
			data[1][3] = "F";
			data[1][4] = "Is Not Vaccinated";
			
			//3rd set
			data[2][0] = "Mentos";
			data[2][1] = "Cola";
			data[2][2] = 15;
			data[2][3] = "M";
			data[2][4] = "Is Vaccinated";
				
			//4th set
			data[3][0] = "Ntombi";
			data[3][1] = "Aluta";
			data[3][2] = 20;
			data[3][3] = "F";
			data[3][4] = "Is Vaccinated";
			
			 
			//5th set
			data[4][0] = "Vanessa";
			data[4][1] = "Malone";
			data[4][2] = 29;
			data[4][3] = "F";
			data[4][4] = " Is Not Vaccinated";
			
			//6th set
			data[5][0] = "Melody";
			data[5][1] = "Van Rensburg";
			data[5][2] = 19;
			data[5][3] = "F";
			data[5][4] = "Is Vaccinated";
			
			//7th set
			data[6][0] = "Phillip";
			data[6][1] = "VMyburg";
			data[6][2] = 19;
			data[6][3] = "M";
			data[6][4] = "Is Not Vaccinated";
			
			//8th set
			data[7][0] = "Motho";
			data[7][1] = "Wabatho";
			data[7][2] = 23;
			data[7][3] = "M";
			data[7][4] = "Is Vaccinated";
			
			//9th set
			data[8][0] = "Mara";
			data[8][1] = "Why";
			data[8][2] = 19;
			data[8][3] = "M";
			data[8][4] = "Is Vaccinated";
			
			//9th set
			data[9][0] = "I am";
			data[9][1] = "Out of Names";
			data[9][2] = 20;
			data[9][3] = "F";
			data[9][4] = "Is Vaccinated";
			
			
			return data;
		}
		

}
