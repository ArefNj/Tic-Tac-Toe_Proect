import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public void singlePlayer(){
        Random generator = new Random();

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


        // CHECK BLOCKED
        for (int i = 0; i < 3; i++) {
             cells[blockCells.get(i)] = "\033[91m # \033[97m";

        }

        bored(cells);



        // GET INPUT X FROM USER

        // RANDOM SELECTION BETWEEN SELECTABLE CELLS







    }
    public void PvP(){

        String[] cells = new String[16];
        for (int i = 0; i < 16; i++){
            cells[i] = String.format("%d",i+1);
        }
        bored(cells);



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
