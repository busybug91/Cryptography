

import java.math.*;
import java.util.HashMap;

public class AffineCipher {
	
	private String input;
	private int a;
	private char[] rMapping;
	
	//magnitude of shift
	private int b;
	
	private HashMap<Character, Integer> mapping;
	//Size of the alphabet
	private int m;
	public void setInput(String input)
	{
		this.input=input.toLowerCase();
	}
	public String getInput()
	{
		return this.input;
	}
	public AffineCipher(int a, int b, int m)
	{
		this.a=a;
		this.b=b;
		this.m=m;
		mapping=new HashMap<Character, Integer>();
		rMapping=new char[this.m];
		initMap();
	}
	public void initMap()
	{
		int start=97;
		for(int i=0;i<m;i++)
		{
			mapping.put((char)(i+start), i);	
		}
		for(int i=0;i<m;i++)
		{
			rMapping[i]=(char)(65+i);	
		}
	}
	public HashMap<Character, Integer> getMap()
	{
		return this.mapping;
	}
	public void setABandM(int a, int b, int m)
	{
		this.a=a;
		this.b=b;
		this.m=m;
	}
	public StringBuilder decrypt()
	{
		StringBuilder plainText = new StringBuilder("");
		String []s=input.split(" ");
		BigInteger b1= new BigInteger(Integer.toString(this.a));
		BigInteger b2= new BigInteger(Integer.toString(this.m));
		BigInteger b3= b1.modInverse(b2);
		int aInv=b3.intValue();
		for(String p:s)
		{
			for(int i=0;i<p.length();i++)
			{
				//System.out.println(mapping.get(p.charAt(i)));
				//pp will contain our plain text
				
				int pp=(aInv*((mapping.get(p.charAt(i))-this.b)))%this.m;
				if(pp<0)
				{
					pp=26-Math.abs(pp);
				}
				System.out.println(pp);
				plainText.append((char)(pp+97));
			}
			plainText.append(" ");
		}
		
		return plainText;
	}

}
