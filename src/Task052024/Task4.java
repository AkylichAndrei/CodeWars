package Task052024;
//Write a method that takes a field for well-known board game "Battleship" as an argument and
// returns true if it has a valid disposition of ships, false otherwise. Argument is guaranteed
// to be 10*10 two-dimension array. Elements in the array are numbers, 0 if the cell is free and
// 1 if occupied by ship.
//
//Battleship (also Battleships or Sea Battle) is a guessing game for two players. Each player has
// a 10x10 grid containing several "ships" and objective is to destroy enemy's forces by targetting
// individual cells on his field. The ship occupies one or more cells in the grid. Size and number of
// ships may differ from version to version. In this kata we will use Soviet/Russian version of the game.
public class Task4 {
    public boolean fieldValidator(int[][] field) {
        try {
            int[] fourDecker = new int[1];
            int[] threeDecker = new int[2];
            int[] twoDecker = new int[3];
            int[] oneDecker = new int[4];
            int counter = 0, threeD = -1, twoD = -1, fourD = -1, oneD = -1, k = 0;
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    if (field[i][j] == 1) {
                        for (k = j; k < field.length && field[i][k] == 1; k++) {
                            counter += (field[i][k] == 1) ? 1 : 0;
                            j = k;
                        }
                        if (counter == 4) {fourD++; fourDecker[fourD] = 1;}
                        if (counter == 3) {threeD++; threeDecker[threeD] = 1;}
                        if (counter == 2) {twoD++; twoDecker[twoD] = 1;}
                        if (counter == 1) {
                            for (int stepDown = i + 1 ; stepDown < field.length; stepDown++) {
                                if (field[stepDown][j] == 0)
                                    break;
                                if (field[stepDown][j] == 1) {
                                    counter++;
                                    break;
                                }
                            }
                            for (int stepUp = i - 1 ; stepUp >= 0; stepUp--) {
                                if (field[stepUp][j] == 0)
                                    break;
                                if (field[stepUp][j] == 1) {
                                    counter++;
                                    break;
                                }
                            }
                        }
                        if (counter == 1){oneD++; oneDecker[oneD] = 1;}
                        counter = 0;
                    }

                }
            }
            for (int j = 0; j < field.length; j++) {
                for (int i = 0; i < field.length; i++) {
                    if (field[i][j] == 1) {
                        for ( k = i; k < field.length && field[k][j] == 1; k++) {
                            counter += (field[k][j] == 1) ? 1 : 0;
                            i = k;
                        }
                        if (counter == 4) {fourD++; fourDecker[fourD] = 1;}
                        if (counter == 3) {threeD++; threeDecker[threeD] = 1;}
                        if (counter == 2) {twoD++; twoDecker[twoD] = 1;}
                        counter = 0;
                    }
                }
            }
            System.out.println("stop");
        }
        catch (Exception ex){
            return false;
        }

        return true;
    }
    public static void main(String[] args){
        Task4 task4 = new Task4();
        int[][] battleField = {
                {1, 0, 0, 0, 1, 0, 1, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(task4.fieldValidator(battleField));
    }
}
