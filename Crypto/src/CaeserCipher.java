import java.util.Scanner;

/* I developed this to decrpyt a simple text
 *  this program does no contain function for encryption. However, it is fairly to write one
 *  referring this code
*/

public class CaeserCipher {
	
	private String input;
	public void setInput(String input)
	{
		// call this method to set the input string
		this.input=input.toLowerCase();
	}
	public String getInput()
	{
		return this.input;
	}
	public StringBuilder decrypt(int shift)
	{
		StringBuilder plainText = new StringBuilder("");
		String []s=input.split(" ");
		for(String p:s)
		{
			for(int i=0;i<p.length();i++)
			{
				int pp=(int)p.charAt(i);
				pp=pp-shift;
				if(pp<97)
				{
					pp=97-pp;
					pp=123-pp;
				}
				plainText.append((char)(pp));	
			}	
			plainText.append(" ");
		}
		return plainText;
	}
	public void decryptWithMeaning()
	{
		System.out.println("Please enter start shift value");
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(decrypt(n));
		System.err.println("If it still does not makes sense. I can try again by incrementing value once again");
		System.err.println("Enter 1 for yes or 2 for no");
		try{
			int choice= sc.nextInt();

			while(choice==1)
			{
				if(n>26){
					n=n-26;
				}
				System.out.println(decrypt(++n));
				System.err.println("Enter 1 to try again or 2 for if you are done");
				choice=sc.nextInt();
			}
			System.out.println("The key for the encrypted text is "+n);
			sc.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}




}
