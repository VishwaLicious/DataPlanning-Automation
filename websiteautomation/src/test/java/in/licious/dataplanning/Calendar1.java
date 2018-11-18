package in.licious.dataplanning;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calendar1 {

	private static final String MONTH = null;
	private static final String DAY_OF_MONTH = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Calendar cal = Calendar.getInstance();
		    cal.set(Calendar.MONTH, 1);
		    cal.set(Calendar.DAY_OF_MONTH, 30);
		    int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    System.out.print(df.format(cal.getTime()));
		    for (int i = 1; i < maxDay; i++) {
		        cal.set(Calendar.DAY_OF_MONTH, i + 1);
		        System.out.print(", " + df.format(cal.getTime()));
		    }

	}

	private Date getTime() {
		// TODO Auto-generated method stub
		return null;
	}

	private int getActualMaximum(String dayOfMonth) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void set(String month2, int i) {
		// TODO Auto-generated method stub
		
	}

	private static Calendar getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}
