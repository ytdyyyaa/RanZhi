package Data;

import org.testng.annotations.DataProvider;

public class SettingZiBank {
	@DataProvider(name = "apple")
	public Object[][] getmovieyugaodata() {
		FileDataProvider fdp = new FileDataProvider();
		return fdp.getTestDataByTxt("Data/settingsBankuai.txt");
	}

}
