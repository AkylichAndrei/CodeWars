package Task052024;
//Переместите первую букву каждого слова в конец, затем добавьте «ау» в конец слова.
// Знаки препинания оставляйте нетронутыми.
public class Task2 {
    String pigIt(String str){
        char[] ch;
        String result="";
        String[] words = str.split(" ");
        str="";
        for(String word : words){
            word += "ay";
            ch = word.toCharArray();
            if(ch.length > 2){
                str = (ch[ ch.length - 3 ] > 64) ? changePosition(ch, ch.length - 3, false) :
                        changePosition(ch, ch.length - 4, true);
            }
            result += str + " ";
        }
        result = result.trim();
        return result.replace(" ay"," ");
    }
    String changePosition(char[] ch, int lastPosition, boolean flag){
        char temp;
        for(int i = 0; i < lastPosition; i++){
            temp = ch[ i ];
            ch[ i ] = ch[ i + 1 ];
            ch[ i + 1 ] = temp;
        }
        if(flag)
            for(int i = lastPosition + 1; i < ch.length - 1; i++){
                temp = ch[ i ];
                ch[ i ] = ch[ i + 1 ];
                ch[ i + 1 ] = temp;
            }
        return String.valueOf(ch);
    }
    public static void main(String[] args) {
        Task2 myTask2 = new Task2();
        System.out.print(myTask2.pigIt(" Pig, latin. is! cool:  "));
    }
}
