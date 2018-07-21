package App.util;

public class CommonUtil {

	public double  get2DecimalNumbers(Double num)
	{
		Double res = Math.floor(num * 100) / 100;
		return res;
	}
}
