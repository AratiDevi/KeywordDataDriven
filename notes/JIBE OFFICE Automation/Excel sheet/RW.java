package CommanFunction;

public class RW {
	public ExcelRead data = new ExcelRead("C:\\Ankita\\NewTestNG\\Excel\\ankita.xlsx"); // Read excel path
	
	public WriteExcel write_data = new WriteExcel("C:\\Ankita\\NewTestNG\\Excel\\ankita.xlsx");
	
	public String url = data.getData(0, 1, 1);
	
}
