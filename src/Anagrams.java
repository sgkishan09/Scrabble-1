import java.util.*;
import java.lang.*;
import java.io.*;

class Anagrams{

	public static String sortString(String str){
		char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
	}

	public static HashMap<String, ArrayList<String> > getAnagramMap(ArrayList<String> inputLines){
		HashMap<String, ArrayList<String>> anagramMap = new HashMap<String, ArrayList<String>>();

		for(int i=0; i<inputLines.size(); i++){
			String sortedString = sortString(inputLines.get(i));

			ArrayList<String> existingWords = anagramMap.get(sortedString);

			if(existingWords == null){
				existingWords = new ArrayList<String>();
			}
			existingWords.add(inputLines.get(i));
			anagramMap.put(sortedString, existingWords);
		}
		return anagramMap;
	}

	public static void printAnagramMap(HashMap<String, ArrayList<String>> map){
		StringBuilder result = new StringBuilder();
        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet())
        {

            if(entry.getValue().size() != 1){
                for(String item:entry.getValue()){
                    result.append(item+ " ");
                }
                result.append("\n");
            }
        }
        System.out.println(result);
	}

	public static ArrayList<String> readInput(){
		Scanner s = new Scanner(System.in);
		ArrayList<String> inputStrings = new ArrayList<String>();
		try{
			String line = s.nextLine();
			inputStrings.add(line);
		} catch (NoSuchElementException e){
			;
		}
		
		while (true){
		    try{
			String line = s.nextLine();
			inputStrings.add(line);
		} catch (NoSuchElementException e){
			break;
		}
		}
		return inputStrings;
	}

	public static void main(String[] args){

        ArrayList<String> inputStrings = readInput();
        HashMap<String, ArrayList<String> > anagramMap = getAnagramMap(inputStrings);
        
        printAnagramMap(anagramMap);

	}
}