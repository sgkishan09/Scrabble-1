# Scrabble
ScrabblePayPal

Whats Up Wannabe Coders!

This is an attempt to explain to you how our code works and what its shortcomings are. So here it is:

1. We have a Master Class called 'Scrabble' that contains the main function.
2. Next, we have included a class named 'ScrabbleRack'. Why? Probably because Scrabble is a game never played alone.

About ScrabbleRack

1. Scrabble Rack contains an final static ArrayList that has the values of all Tiles of scrabble stored in Alphabetical order. In case one wishes to check the value of say 'Q', simply subtract the value of 'A' and check the value at that index.
2. State: charecterOnRack is the a private ArrayList of characters that has the details of the 7 Tiles.
3. Concept of DFS using recursion used to find a suitable word that can be considered as possible solution.


Shortcomings:
1. Calculation of Score is pending. From the DFS algorithm, you will get a set of words sorted in alphabetical order. Your Task is to:

- Check for its validity of score calculation.

- We have not included the test case in main function. Look at the constructor and figure it out.
