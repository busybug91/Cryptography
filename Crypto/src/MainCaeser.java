
public class MainCaeser {

	public static void main(String []args)
	{
		CaeserCipher cc= new CaeserCipher();
		
		cc.setInput("Jxu auo veh rhuqaydw oekh dunj syfxuh yi hywxj kdtuh oekh deiu");
		System.out.println(cc.decrypt(26));
		cc.decryptWithMeaning();
	}
	
}
