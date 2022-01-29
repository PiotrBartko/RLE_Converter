package application;

public class Obliczenia
{
	public static String kodowanie(String inputString) 
	{
		String outputString= "";

        
        int count = 1;
        for (int i = 0; i < inputString.length(); i++) {

            
            count = 1;
            while (i < inputString.length() - 1 && inputString.charAt(i) == inputString.charAt(i + 1))
            {
                count++;
                i++;
            }
            if (i<inputString.length()-1)
            {
            outputString = outputString + inputString.charAt(i) + count+",";
            }
            else 
            {
            	outputString = outputString + inputString.charAt(i) + count;
				
			}
        }
       
		return outputString;
	}
	
	public static String dekodowanie(String input) 
	{
		
        String output="";

        String[] code = input.split(",");
      
        Integer[]liczby = new Integer[code.length];



        for(int i =0;i<=liczby.length-1;i++)
        {
        	liczby[i] = Integer.parseInt(code[i].substring(1));
        	System.out.println(liczby[i]);
            for(int j=1;j<=liczby[i];j++)
            {
                output+=code[i].charAt(0);
                System.out.println(output);
            }    
        }
        
		return output;
	}
	
	
	
	
	

}
