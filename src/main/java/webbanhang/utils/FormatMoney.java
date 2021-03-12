package webbanhang.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FormatMoney {
	public static String formatMoney(double money) {
		NumberFormat formatter = new DecimalFormat("#0.000");  
		
		return formatter.format(money); 
	}
	public static void main(String[] args) {
		System.out.println(formatMoney(1000.0));
	}
}
