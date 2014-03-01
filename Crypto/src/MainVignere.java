
public class MainVignere {

	public static void main(String []args)
	{
		VignereCipher vc= new VignereCipher("sparky");
		vc.setInputString("eprfylscdxyjv");
//		String c=vc.encrypt().toString();
//		System.out.println(c);
//		vc.setInput(c);
		System.out.println(vc.getInput());
		System.out.println(vc.getKey());

		String p=vc.decrypt().toString();
		System.out.println(p);
		
//		vc.printMapping();
		
	}
}
