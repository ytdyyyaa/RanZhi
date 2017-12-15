package Data;

import org.testng.annotations.DataProvider;

public class TJboke {
	@DataProvider(name = "boke")
	public Object[][] getmovieyugaodata() {
		FileDataProvider fdp = new FileDataProvider();
		return fdp.getTestDataByTxt("Data/tianjBoke.txt");
	}

}
