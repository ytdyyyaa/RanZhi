package Data;

import org.testng.annotations.DataProvider;

public class LeiMu {
	@DataProvider(name = "leimu")
	public Object[][] getmovieyugaodata() {
		FileDataProvider fdp = new FileDataProvider();
		return fdp.getTestDataByTxt("Data/setting-Boke.txt");
	}


}
