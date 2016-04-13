package bil.learn.tutpoint;

public class Tests {

	public static void main(String[] args) {
		System.out.println("Test");
		Testing testing = new Testing();
		System.out.println(testing. lastTwo("Coding"));
		System.out.println(testing. withoutX("xCoding"));
		System.out.println(testing. stringMatch("xxcaazz", "xxbaaz"));
		OOPTest objoop = new OOPTest();
		System.out.println(objoop.b);
		Childoop objcoop = new Childoop();
		System.out.println(objcoop.a);
		objoop.pTest();
		Childoop.sTest();
	}
}

class Testing{
	public String lastTwo(String str) {
		char[] strc = str.toCharArray();
		int l= str.length()-1;
		char ld = strc[l];
		strc[l]=strc[l-1];
		strc[l-1]=ld;
		return String.valueOf(strc);
	}

	public int powerN(int base, int n) {
		if(n ==1) return base;
		int c = powerN(base,--n);
		return base * c;
	}

	public String makeOutWord(String out, String word) {
		int l = out.length()-1;
		int lh = l/2;
		return out.substring(0,lh)+word+out.substring(lh,l);
	}

	public String withoutX(String str) {
		String temp=str;
		if(str.startsWith("x")){
			temp= str.substring(1, str.length());
		} if(str.endsWith("x")){
			temp= str.substring(1, str.length());
		}
		return temp;
	}

	public int stringMatch(String a, String b) {
		int s = 0,e=2;
		int count=0;
		while((e<=(a.length()))&&(e<=(b.length()))){
			if(a.substring(s,e).equals(b.substring(s,e))){
				count++;
			}
			System.out.println(a.substring(s,e)+" -"+s+"- "+ b.substring(s,e)); 
			e=e+1;
			s=s+1;
		}
		return count;
	}

}
