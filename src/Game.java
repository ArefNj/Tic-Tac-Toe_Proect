import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    int FULLCELL = -1;

    public void singlePlayer(){
        Random generator = new Random();
        Scanner Scan = new Scanner(System.in);

        String[] cells = new String[16];
        for (int i = 0; i < 16; i++){
            if (i < 9)
                cells[i] = String.format("%d ",i+1);
            else
                cells[i] = String.format("%d",i+1);
        }

        // BLOCKING

        List<Integer> blockCells = new ArrayList<>(3);
        while (blockCells.size() < 3){
            blockCells.add(generator.nextInt(0 , 15));
        }


        // APPLY BLOCKED CELLS IN BORED
        for (int i = 0; i < 3; i++) {
             cells[blockCells.get(i)] = "\033[91m # \033[97m";
        }

        // APPLY BLOCKED CELLS IN LIST(SETTING (VALUE : -1) FOR BLOCK OR FILL)
        List<Integer> emptyCells = new ArrayList<Integer>(16);
        for (int i = 0; i < 16; i++) {
            if (!blockCells.contains(i))
                emptyCells.add(i,i);
            else
                emptyCells.add(i, FULLCELL);
        }
//        // setting defaults
//        boolean restartFlag = false;
//        boolean isPlayerXTurn = true;
//        while (!restartFlag && !emptyCells.contains(-1)){
//            System.out.println("The player's turn is Player 1");
//            bored(cells);
//
//
//        }






        // GET INPUT X FROM USER

        // RANDOM SELECTION BETWEEN SELECTABLE CELLS







    }
    public void PvP(){
        Random generator = new Random();
        Scanner Scan = new Scanner(System.in);


        String[] cells = new String[16];
        for (int i = 0; i < 16; i++){
            if (i < 9)
                cells[i] = String.format("%d ",i+1);
            else
                cells[i] = String.format("%d",i+1);
        }

        // BLOCKING
        // 1.Random get 3 cells from Random class to blocking
        List<Integer> blockCells = new ArrayList<>(3);
        while (blockCells.size() < 3){
            blockCells.add(generator.nextInt(0 , 15));
        }


        // 2.Apply Blocked Cells in bored
        for (int i = 0; i < 3; i++) {
            cells[blockCells.get(i)] = "\033[91m # \033[97m";

        }

        // 3.Apply Blocked Cells in available cells list
        List<Integer> emptyCells = new ArrayList<Integer>(16);
        for (int i = 0; i < 16; i++) {
            if (!blockCells.contains(i))
                emptyCells.add(i,i);
            else
                emptyCells.add(i, FULLCELL);
        }



        bored(cells);



        // GET INPUT X FROM USER

        // RANDOM SELECTION BETWEEN SELECTABLE CELLS






    }
    public void bored(String[] inputs){
        System.out.printf("""
                \033[97m+ + + + + + + + + + + + +
                + %3s + %3s + %3s + %3s +
                + + + + + + + + + + + + +
                + %3s + %3s + %3s + %3s +
                + + + + + + + + + + + + +
                + %3s + %3s + %3s + %3s +
                + + + + + + + + + + + + +
                + %3s + %3s + %3s + %3s +
                + + + + + + + + + + + + +
                """,inputs);

    }
}
