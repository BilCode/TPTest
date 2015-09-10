package bil.learn.tutpoint;

import java.util.ArrayList;

public class FabronicSeries {
	
	int a = 0;
	int b=1;
	int c=0;
	ArrayList<Integer> series = new ArrayList<Integer>();
	String genrateSeries(int limit)
	{
		while(c<limit)
		{
			c=a+b;
			series.add(a);
			a=b;
			b=c;
			
		}
		String csv = series.toString().replace("[", "").replace("]", "")
        .replace(", ", ",");
		return csv;
	}

}
