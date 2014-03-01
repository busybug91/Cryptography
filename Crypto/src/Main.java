
public class Main {

	public static void main(String []args)
	{
	AffineCipher af=new AffineCipher(9, 5, 26);
	af.setInput("Uqp Lds Gpmza xbabcl By jfcbbs fsg hbag abbr hcpfu");
	System.out.println(af.getMap());
	System.out.println(af.decrypt());
	}
}
