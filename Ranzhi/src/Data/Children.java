package Data;

import org.testng.annotations.DataProvider;

public class Children {
	@DataProvider(name = "children")
	public Object[][] getmovieyugaodata() {
		FileDataProvider fdp = new FileDataProvider();
		return fdp.getTestDataByTxt("Data/setting-children.txt");
	}

}
