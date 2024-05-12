package Task052024;
//Given an n x n array, return the array elements arranged from outermost elements to the middle element,
// traveling clockwise.
public class Task3 {
    public int[] snail(int[][] array) {
        int[] arrFinal;
        try {
            int x = 0, counter = 0, counter2 = 1;
            int arLen = array.length;
            arrFinal = new int[array.length * array.length];
            while (x < array.length * array.length - 1) {
                for (int i = counter, j = counter; j < arLen - counter2; j++, x++)
                    arrFinal[x] = array[i][j];
                for (int i = counter, j = arLen - counter2; i < arLen - counter2; i++, x++)
                    arrFinal[x] = array[i][j];
                for (int i = arLen - counter2, j = arLen - counter2; j > counter; j--, x++)
                    arrFinal[x] = array[i][j];
                for (int i = arLen - counter2, j = counter; i > counter; i--, x++)
                    arrFinal[x] = array[i][j];
                counter++;
                counter2++;
            }
            if (array.length % 2 != 0) {
                arrFinal[x] = array[counter][counter];
            }
        }
        catch(Exception ex){

            return  arrFinal = new int[0];
        }
        return arrFinal;
    }
    public static void main(String[] args){
        Task3 myTask3 = new Task3();
        int[][] array = {{1, 2, 3, 9},
                         {4, 5, 6, 4},
                         {7, 8, 9, 1},
                         {1, 2, 3, 4}};
        int[] resultArr = new int[array.length * array.length];
        System.arraycopy(myTask3.snail(array), 0, resultArr, 0, array.length * array.length);
        for (int j : resultArr) {
            System.out.print(j);
        }
    }
}
//[1, 2, 3, 9, 4, 1, 4, 3, 2, 1, 7, 4, 5, 6, 9, 8]
