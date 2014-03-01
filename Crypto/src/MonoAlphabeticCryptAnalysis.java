import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


public class MonoAlphabeticCryptAnalysis {

	SortedSet<Map.Entry<Character, Integer>> smap;
	private TreeMap<Character, Integer> counts;
	private String input;
	public MonoAlphabeticCryptAnalysis(String input)
	{
		counts= new TreeMap<Character, Integer>();
		this.input=input.toUpperCase().trim().replaceAll("\\s+","");
	}
	public String getInput()
	{
		return this.input;
	}
	public void countChar()
	{
		for(int i=0;i<input.length();i++)
		{
			if(counts.containsKey(input.charAt(i)))
			{
				int value=counts.get(input.charAt(i));
				value++;
				counts.put(input.charAt(i), value);
			}
			else
			{
				counts.put(input.charAt(i), 1);
			}
		}
	}
	public SortedSet getTopkChars(){
		SortedSet<Map.Entry<Character, Integer>> smap= new TreeSet<Map.Entry<Character, Integer>>(
				new Comparator<Map.Entry<Character, Integer>>()
				{
					public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b )
					{
						return b.getValue()-a.getValue();
					}
				});
		smap.addAll(counts.entrySet());
		return smap;
	}
	public TreeMap<Character, Integer> getCounts()
	{
		return this.counts;
	}


}
