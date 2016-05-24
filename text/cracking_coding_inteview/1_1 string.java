public boolean isUniqueCharsAscii(String word) {
	int bitset = 0
	for( char c : word.toCharArray()) {
		int bittest = 1 << (c - 'a');
		
		if( bitset & pos > 0) {
			return false;
		}
		bitset |=  bittest;
	}
	return true;
}

 BigInteger checker = new BigInteger(0);
    for (int i = 0; i < str.length(); i++) {
        int val = str.charAt(i);
        if (checker.testBit(val)) return false;
        checker = checker.setBit(val);


StringBuilder() Constructs a string builder with no characters in it and an initial capacity of 16 characters.
StringBuilder(CharSequence seq) Constructs a string builder that contains the same characters as the specified CharSequence.
StringBuilder(int capacity) Constructs a string builder with no characters in it and an initial capacity specified by the capacity argument.
StringBuilder(String str)

append
StringBuilder 	delete(int start, int end) Removes the characters in a substring of this sequence.
StringBuilder 	deleteCharAt(int index)
 int 	indexOf(String str)         Returns the index within this string of the first occurrence of the specified substring.
 int 	indexOf(String str, int fromIndex) Returns the index within this string of the first occurrence of the specified substring, starting at the specified index.
 
  StringBuilder 	insert(int offset, <datatypes>
    void 	setCharAt(int index, char ch)

String 	substring(int start) Returns a new String that contains a subsequence of characters currently contained in this character sequence.
 String 	substring(int start, int end)
 
 
 ===
 
 String
 
char charAt(int index)
c[]	toCharArray()