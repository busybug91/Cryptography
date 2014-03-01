
public class VignereCipher {

	private String input;
	private StringBuilder key;
	private char mapping[][];
	private StringBuilder plainText;
	private StringBuilder cipherText;

	public void setInput(String input)
	{
		this.input=input.toLowerCase().replaceAll("\\s+","");
	}
	public String getInput()
	{
		return this.input;
	}
	public VignereCipher(String key)
	{
		this.key=new StringBuilder(key);
		mapping = initializeMapping();
	}
	public StringBuilder getKey()
	{
		return this.key;
	}
	public void setInputString(String input)
	{
		this.input=input.toLowerCase().replaceAll("\\s+","");
		while(key.length()<this.input.length())
		{
			key.append(key);
		}
		String s=key.substring(0, (this.input.length()));
		key=new StringBuilder(s);
	}

	public char [][] initializeMapping()
	{
		char [][]mapping= new char [26][26];
		for(int i=0;i<mapping.length;i++)
		{
			int val=(i+97);
			for(int j=0;j<mapping[0].length;j++)
			{
				if(val>122)
				{
					val=96+(val-122);
				}
				mapping[i][j]=(char)(val);
				val++;
			}
		}
		return mapping;
	}
	public void printMapping()
	{
		for(int i=0;i<mapping.length;i++)
		{
			for(int j=0;j<mapping[0].length;j++)
			{
				System.out.print(mapping[i][j]+" ");
			}
			System.out.println();
		}
	}
	public StringBuilder encrypt()
	{
		StringBuilder cipherText = new StringBuilder("");
		for(int i=0;i<input.length();i++)
		{
			int indexOfKey=(int)key.charAt(i)-97;
			int indexOfP=(int)this.input.charAt(i)-97;
			cipherText.append(mapping[indexOfKey][indexOfP]);
		}	
		this.cipherText=cipherText;
		return cipherText;
	}
	public StringBuilder decrypt()
	{
		StringBuilder plainText = new StringBuilder("");
		char p='\0';
		for(int i=0;i<input.length();i++)
		{
			int indexOfKey=(int)key.charAt(i)-97;
			for(int j=0;j<mapping[0].length;j++)
			{
				
				if(this.input.charAt(i)==mapping[indexOfKey][j])
				{
					p=(char)(j+97);
					break;
				}
				
			}
			plainText.append(p);
		}
		return plainText;
	}

}
