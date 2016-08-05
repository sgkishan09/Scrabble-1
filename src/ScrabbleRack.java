import java.util.*;

class ScrabbleRack {
	final static ArrayList<Integer> characters = new ArrayList<Integer>(Arrays.asList({1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10}));

	private ArrayList<Character> charactersOnRack;

	public ScrabbleRack(ArrayList<Character> rack) {
		charactersOnRack = new ArrayList<Character>();

		for (int i = 0; i < rack.size(); i++) {
			charactersOnRack.add(Character.toUpperCase(rack.get(i)));
		}

		Collections.sort(charactersOnRack);
	}

	private boolean isInAnagramList(ArrayList<Character> characters) {
		ArrayList<String> inputStrings = Anagrams.readInput();
		HashMap<String, ArrayList<String>> anagramMap = Anagrams.getAnagramMap(inputStrings);

		String testString = "";

		for (int i = 0; i < characters.size(); i++) {
			testString += characters.get(i);
		}

		ArrayList<String> setOfWords = anagramMap.get(testString);

		return setOfWords != null;

		return true;
	}

	private static int getScore(ArrayList<Character> word) {
		return 0;
	}

	private ArrayList<Character> getBestWordFrom(ArrayList<Character> characters) {
		if (isInAnagramList(characters)) {
			return characters;
		} else {
			int maxScore = 0;
			int maxIndex = -1;
			for (int i = 0; i < characters.size(); i++) {
				ArrayList<Character> characterSubSet = new ArrayList<Character>(characters);
				characterSubSet.remove(i);
				ArrayList<Character> bestWord = getBestWordFrom(characterSubSet);
				int score = getScore(bestWord);
				if (score > maxScore) {
					maxScore = score;
					maxIndex = i;
				}
			}
			ArrayList<Character> characterSubSet = new ArrayList<Character>(characters);
			characterSubSet.remove(i);
			return characterSubSet;
		}
	}

	public ArrayList<Character> getBestWord() {
		return getBestWordFrom(charactersOnRack);
	}

}

class Anagrams {

	public static String sortString(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	public static HashMap<String, ArrayList<String>> getAnagramMap(ArrayList<String> inputLines) {
		HashMap<String, ArrayList<String>> anagramMap = new HashMap<String, ArrayList<String>>();

		for (int i = 0; i < inputLines.size(); i++) {
			String sortedString = sortString(inputLines.get(i));

			ArrayList<String> existingWords = anagramMap.get(sortedString);

			if (existingWords == null) {
				existingWords = new ArrayList<String>();
			}
			existingWords.add(inputLines.get(i));
			anagramMap.put(sortedString, existingWords);
		}
		return anagramMap;
	}

	public static void printAnagramMap(HashMap<String, ArrayList<String>> map) {
		StringBuilder result = new StringBuilder();
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {

			if (entry.getValue().size() != 1) {
				for (String item : entry.getValue()) {
					result.append(item + " ");
				}
				result.append("\n");
			}
		}
		System.out.println(result);
	}

	public static ArrayList<String> readInput() {
		Scanner s = new Scanner(System.in);
		ArrayList<String> inputStrings = new ArrayList<String>();
		try {
			String line = s.nextLine();
			inputStrings.add(line);
		} catch (NoSuchElementException e) {
			;
		}

		while (true) {
			try {
				String line = s.nextLine();
				inputStrings.add(line);
			} catch (NoSuchElementException e) {
				break;
			}
		}
		return inputStrings;
	}
}

public class Scrabble {
	public static void main(String[] args) {

	}
}