package Data;

import org.testng.annotations.DataProvider;

public class LoginAdmin {
	@DataProvider(name = "Bankuai")
	public Object[][] getmovieyugaodata() {
		FileDataProvider fdp = new FileDataProvider();
		return fdp.getTestDataByTxt("Data/setting-addbankuai.txt");
	}

}
