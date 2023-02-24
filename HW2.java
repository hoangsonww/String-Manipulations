// David Nguyen - A class that represents the Homework #2
public class HW2 extends Object {
  
  // A METHOD that returns a new string that is identical as s but the first character of each sentence is capitalized
  public static String capitalizeSentences(String s) {
    StringBuilder builder = new StringBuilder();
    // A boolean variable that determine whether the character at the current index should be capitalized or not
    boolean capitalize = true;
    /* A loop that capitalizes the first letter of every sentence. The loop's required condition is that the variable
     * index should never be greater than or equal to the length of string s */
    for (int index = 0; index < s.length(); index = index + 1) {
      //A variable that represents the current character at the current index of string s
      char c = s.charAt(index);
      /* If statement that checks whether the current character is . ? or !. 
       * If yes, the next alphabetic character will be capitalized. 
       * To do this: If the variable capitalize is currently true and current character is an alphabet, 
       * that character will be capitalized.
       * If current character is not . ? or !, it will be appended normally */
      if (c == '.' || c == '?' || c == '!') {
        capitalize = true;
      }
      else if (capitalize && Character.isAlphabetic(c)) {
        c = Character.toUpperCase(c);
        capitalize = false;
      }
      builder.append(c);
    }
    return builder.toString();
  }
      
        
  // A METHOD that returns true if a sequence is a subsequence of the string
  public static boolean subSequence(String sequence, String string) {
    // A variable that stores the current index of the sequence string
    int sequenceIndex = 0;
    // A variable that stores the current index of the string string
    int stringIndex = 0;
    /* A loop that checks whether the sequence is the subsequence of string. 
     * First condition for this loop: index of sequence must be less than length of sequence. 
     * Second Condition for this loop: index of string must also be less than length of string */
    while (sequenceIndex < sequence.length() && stringIndex < string.length()) {
      /* If the character at the current sequence index in sequence == the character at the string index in string, 
       * both indexes will increase by 1 to continue comparing subsequent characters
       * Otherwise, only the stringIndex is increased */
      if (sequence.charAt(sequenceIndex) == string.charAt(stringIndex)) {
        sequenceIndex = sequenceIndex + 1;
        stringIndex = stringIndex + 1;
      }
      else {
        stringIndex = stringIndex + 1;
      }
    }
    /* If sequenceIndex variable is the same as the length of sequence, sequence is a subsequence of 
     * string */
    if (sequenceIndex == sequence.length())
      return true;
    else
      return false;
  }
  
  
  /* A METHOD that returns a new String that contains the same content as the input string, but any spaces at the 
   * beginning of the string and the end are removed. Any extra spaces between two non-space characters will also
   * be removed */
  public static String removeExtraSpaces(String s) {
    StringBuilder builder = new StringBuilder();
    // A variable that determines whether the current character at current index is a space or not
    boolean isWhiteSpace = true;
    /* Removes any leading and trailing and extra spaces using the variable above. 
     * Condition for this loop: the index must be less than the length of the string s */
    for (int index = 0; index < s.length(); index = index + 1) {
      // A variable that represents the current character at the current index of string s
      char c = s.charAt(index);
      /* Appends the current character if the variable is true and the current character is not a space.
       * Doing this will add only a space to the string, regardless of how many spaces there currently are.
       * If the variable whitespace is false, which means that the current character is not a space, that character 
       * will also be appended.*/ 
      if (isWhiteSpace == true && Character.isWhitespace(c) == false) {
        builder.append(c);
        isWhiteSpace = false;
      }
      else if (isWhiteSpace == false) {
        builder.append(c);
      }
      // Setting the isWhiteSpace variable based on whether the current character is a space or not
      if (Character.isWhitespace(c) == false) {
        isWhiteSpace = false;
      }
      else {
        isWhiteSpace = true;
      }
    }
    // A StringBuilder that creates a new string based on the output of the loop above - this is the output string
    StringBuilder result = new StringBuilder();
    /* A loop that removes the extra whitespace at the end of the resulting string
     * Condition: index must be less than the newly created string's length */
    for (int index = 0; index < (builder.toString()).length(); index = index + 1) {
      // A variable that represents the current character at the current index of the new string
      char c = (builder.toString()).charAt(index);
      // This code segment will remove the space at the end of the resulting string, if there is a space there
      if ((Character.isWhitespace(c) == true) && (index == (builder.toString()).length() - 1)) {
        c = (char) (c - c);
      }
      else
        result.append(c);
    }
    return result.toString();
  }
  
  
  // A METHOD that returns true if s contains at least 1 word that is the same as any of the words in the wordList
  public static boolean containsWord(String s, String wordList) {
    // A variable that stores the string wordList that has been removed all extra spaces 
    String stringWordList = new StringBuilder().append(removeExtraSpaces(wordList)).append(" ").toString();
    /* A temporary StringBuilder object
     * This will be used later to store each of the word from the wordList to compare with string s */
    StringBuilder temp = new StringBuilder();
    /* A loop that separates wordList into multiple strings that contains each of the words from the wordList
     * This is done in order to compare each word of wordList with words in string s
     * It will enters another loop to compare immediately when it sees a whitespace
     * Condition: the index must be less than the length of the stringWordList */
    for (int index = 0; index < stringWordList.length(); index = index + 1) {
      // A variable that represents the current character at the current index of stringWordList
      char c = stringWordList.charAt(index);
      // An if-statement that splits the string wordList into words seperated by spaces - then compares word by word
      if (!Character.isWhitespace(c)) {
        temp.append(c);
      }
      else {
        // The following statements are to take the each of the words out of the wordList and compare them to string s
        // A variable that stores the temporary word as it's being compared to the string s
        String tempWordList = temp.toString();
        /* A variable that stores the current index of the temporary string as it's being compared to 
         * stringWordList variable*/
        int tempIndex = 0;
        // A variable that stores the current index of the string s
        int sIndex = 0;
        /* Comparing each of the word in wordList with the characters in string s
         * Condition: the index of the temporary string is less than the tempWordList string's length 
         * and the sIndex is less than the s string.*/
        while (tempIndex < tempWordList.length() && sIndex < s.length()) {
          /* An if statement that compares each of the words of the temporary stringWordList to the string s
           * If the character in both strings at the current indexes match, the indexes will both increase to compare
           * the subsequent characters.
           * Otherwise, tempIndex will reset and sIndex will be decreased */
          if (tempWordList.charAt(tempIndex) == s.charAt(sIndex)) {
            tempIndex = tempIndex + 1;
            sIndex = sIndex + 1;
          }
          else {
            sIndex = sIndex - tempIndex + 1;
            tempIndex = 0;
          }
          /* If numberOfMatch is equal to length of the word currently being compared, 
           * the string contains that word & return true because there is at least 1 matched word now */
          if (tempIndex == tempWordList.length())
          return true;
        }
        /* At the end of each round of loop, both the tempWordList variable and the temp object is reset
         * so that next words in wordList will be compared separately */
        temp = new StringBuilder();
        tempWordList = " ";
      }
    }
    // If after running through loop but does not find any matched words, return false
    return false;
  }
  
  
  // A helper method that reverses all characters of a given string
  private static String reverse(String s) {
    StringBuilder newString = new StringBuilder();
    /* Appending characters of a given string s in the reverse order. 
     * Condition: The index must be less than string's length */
    for(int i = 0; i < s.length(); i = i + 1) {
      newString.append(s.charAt(s.length() - 1 - i));
    }
    return newString.toString();
  }
    
  
  /* A METHOD that returns a string containing each of the words from the wordList, separated by spaces, that appears
   * either forwards or backwards in any of the Strings of the board array */
  public static String wordSearch(String[] board, String wordList) {
    StringBuilder builder = new StringBuilder();
    // A StringBuilder object that creates a new string with the found words in the array board
    StringBuilder result = new StringBuilder();
    /* Loops that convert the array elements of strings into a big & long string, both in backward and forward order
     * Precondition for both loops: index must be less than the length of the array board
     * The second loop is using the helper method reverse(String s) defined above */
    for (int index = 0; index < board.length; index = index + 1) {
      builder.append(board[index]);
      builder.append(' ');
    }
    for (int index = 0; index < board.length; index = index + 1) {
      builder.append(reverse(board[index]));
      builder.append(' ');
    }
    // A variable that represents the newly created string - it represents the entire array, both backward & forward
    String stringBoard = builder.toString();
    // A temporary StringBuilder object to store the current word from wordList being compared to the newly created string
    StringBuilder temp = new StringBuilder();
    /* A loop that separates wordList into multiple strings that contains each of the words from the wordList
     * This is done in order to compare each word of wordList with words in string s
     * It will enters another loop to compare immediately when it sees a whitespace
     * Condition: the index must be less than the length of the stringWordList */
    for (int index = 0; index < wordList.length(); index = index + 1) {
      // A variable that represents the current character at the current index of string wordList
      char c = wordList.charAt(index);
      // An if-statement that splits the string wordList into words seperated by spaces - then compares word by word
      if (!Character.isWhitespace(c)) {
        temp.append(c);
      }
      else {
        // A variable that stores the temporary word as it's being compared to the string
        String tempWordList = temp.toString();
        /* A variable that stores the current index of the temporary string as it's being compared to 
         * stringWordList variable*/
        int tempIndex = 0;
        // Variable that stores the current index of the string s
        int sIndex = 0;
        /* A loop that compares each word of wordList to that of string s. If they match, they'll be appended to 
         * the final , resulting string
         * Condition: temporary index must be less than the temporary string's length & sIndex is less than the big
         * string's length */
        while (tempIndex < tempWordList.length() && sIndex < stringBoard.length()) {
          // A variable that represents the current character at the current index of string tempWordList
          char d = tempWordList.charAt(tempIndex);
          /* An if statement that compares each of the words of the temporary stringWordList to the string s
           * If the character in both strings at the current indexes match, the indexes will both increase to compare
           * the subsequent characters.
           * Otherwise, tempIndex will reset and sIndex will be decreased */
          if (tempWordList.charAt(tempIndex) == stringBoard.charAt(sIndex)) {
            tempIndex = tempIndex + 1;
            sIndex = sIndex + 1;
          }
          else {
            sIndex = sIndex - tempIndex + 1;
            tempIndex = 0;
          }
          /* If tempIndex is equal to the current word being compared's length, the words match
           * If the words match, they will be appended to the resulting string, separated by spaces */
          if (tempIndex == tempWordList.length()) {
            result.append(tempWordList).append(' ');
          }
        }
        /* At the end of each round of loop, both the tempWordList variable and the temp object is reset
         * so that next words in wordList will be compared separately */
        temp = new StringBuilder();
        tempWordList = " ";
      }
    }
    // A variable that creates a new string based on the output of the loop above
    StringBuilder out = new StringBuilder();
    /* A loop that removes the extra whitespace at the end of the resulting string from the loop above.
     * Condition: the index must be less than the resulting string above's length */
    for (int index = 0; index < (result.toString()).length(); index = index + 1) {
      // A variable that represents the current character at the current index of the string above
      char c = (result.toString()).charAt(index);
      /* If the character at the end of the string is a whitespace, remove that character. 
       * Otherwise, append current character. */
      if ((Character.isWhitespace(c) == true) && (index == (result.toString()).length() - 1)) {
        c = (char) (c - c);
      }
      else
        out.append(c);
    }
    return out.toString();
  }
}