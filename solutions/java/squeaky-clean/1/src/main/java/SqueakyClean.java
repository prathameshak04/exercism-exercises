class SqueakyClean {
    static String clean(String identifier) {
        // Use StringBuilder to build the new string
        StringBuilder cleanIdentifier = new StringBuilder();
        boolean toUpperCase = false;

        // Loop through the input string's characters
        for (char ch : identifier.toCharArray()) {

            if (Character.isWhitespace(ch)) {
                // 1. Replace whitespace with an underscore
                cleanIdentifier.append('_');
                toUpperCase = false; // Reset camelCase flag
            } else if (ch == '-') {
                // 2. See a hyphen, set flag to capitalize the *next* letter
                toUpperCase = true;
            } else if (Character.isLetter(ch)) {
                // 3. Handle letters
                if (toUpperCase) {
                    cleanIdentifier.append(Character.toUpperCase(ch));
                    toUpperCase = false;
                } else {
                    cleanIdentifier.append(ch);
                }
            }else if(Character.isDigit(ch)){
                cleanIdentifier.append(ch);
            }
            // Any other characters (like control chars, emojis, etc.) are ignored
        }

        // 4. Handle leetspeak replacements *after* the loop
        // We work on the StringBuilder first, then convert to String
        String result = cleanIdentifier.toString();

        // 5. Fix the String immutability problem
        // You MUST re-assign the variable after each replace
        result = result.replace('4', 'a');
        result = result.replace('3', 'e');
        result = result.replace('0', 'o');
        result = result.replace('1', 'l');
        result = result.replace('7', 't');

        return result;
    }
}