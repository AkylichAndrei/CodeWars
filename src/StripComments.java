public class StripComments {
    public String stripComments(String text, String[] commentSymbols) {
        char[] charArray = text.toCharArray();
        int j = 0;
        for(String commentSymbol: commentSymbols) {
            StringBuilder textBuilder = new StringBuilder();
            for (int i = 0; i < charArray.length; i++) {
                if (commentSymbol.equals("" + charArray[i])) {
                    for (j = i; j < charArray.length; j++){
                        i = j;
                        if(charArray[j] == '\n')
                            break;
                    }
               }
                if (j == charArray.length)
                    break;;
                textBuilder.append(charArray[i]);
            }
            text = textBuilder.toString();
            charArray = text.toCharArray();
        }
        return text;
    }

}
