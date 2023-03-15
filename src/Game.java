import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Game {
    /**
     *  Single Player Game mode
     * Player 1 : Human plays as 'X'
     * Player 2 : Computer ( Using A Random Generator Class ) 'plays as 'O'
     */
    public void singlePlayer(){
        // Creat Scanner and Random Generator
        Random generator = new Random();
        Scanner Scan = new Scanner(System.in);

        // Make a String array for Argument of Bored
        String[] cells = new String[17];
        for (int i = 0; i < 16; i++){
            if (i < 9)
                cells[i] = String.format("%d ",i+1);
            else
                cells[i] = String.format("%d",i+1);
        }

        // BLOCKING
            // Make ane Arraylist for Blocking cells
            List<Integer> blockCells = new ArrayList<>(100);
            while (blockCells.size() < 3){
            blockCells.add(generator.nextInt(1 , 16) - 1);
        }

            // APPLY BLOCKED CELLS IN LIST
            List<Integer> emptyCells = new ArrayList<>(100);

            // APPLY BLOCKED CELLS IN BORED
            for (int i = 0; i < 3; i++) {
             cells[blockCells.get(i)] = "\033[91m # \033[97m";
        }

        // SETTING DEFAULTS
            // Setting empty cells
            for (int i = 0; i < 16; i++) {
            if (!blockCells.contains(i))
                emptyCells.add(i);
        }
            // Player1 storage
            List<Integer> Player1 = new ArrayList<>();
            int player1Input;
            boolean isPlayer1win = false;

            // Player 2 storage
            List<Integer> Player2 = new ArrayList<>();
            int player2Input;
            boolean isPlayer2win = false;


        System.out.println("The player's turn is Player 1\n");
        while (!emptyCells.isEmpty()){

            bored(cells);
            // get input from human
            player1Input = Scan.nextInt() - 1;
            // Check player 1 input
            if (emptyCells.contains(player1Input)){

                // HUMAN SELECTION
                Player1.add(player1Input);
                cells[player1Input] = "\033[94m X \033[97m";
                emptyCells.remove((Integer) player1Input);

                    // My Algorithm  for check win conditions
                    /*
                 * //                if (Player1.size() >= 3){
//                    Collections.sort(Player1);
//
//                    for (int i = 0; i < Player1.size(); i++) {
//                        // exit point
//                        if (Player1.size() - i < 3 ){
//                            break;
//                        }
//
//                        // Horizontally
//                            if (Player1.get(i) + 1 == Player1.get(i + 1)){
//                                if (Player1.get(i + 1) + 1 == Player1.get(i + 2)){
//                                    isPlayer1win = true;
//                                    System.out.println("H");
//                                    break;
//                                }
//                            }
//
//                            // Vertically
//                            if (Player1.get(i) + 4  == Player1.get(i + 1)){
//                                if (Player1.get(i + 1) + 4 == Player1.get(i + 2)){
//                                    isPlayer1win = true;
//                                    System.out.println("V");
//                                    break;
//                                }
//                            }
//
//                            // Diagonally
//                        if (Player1.get(i) + 5  == Player1.get(i + 1)){
//                            if (Player1.get(i + 1) + 5 == Player1.get(i + 2)){
//                                isPlayer1win = true;
//                                System.out.println("D1");
//                                break;
//                            }
//                        }
//
//                        if (Player1.get(i) + 3  == Player1.get(i + 1)){
//                            if (Player1.get(i + 1) + 3 == Player1.get(i + 2)){
//                                isPlayer1win = true;
//                                System.out.println("D2");
//                                break;
//                            }
//                        }
//                    }
//                }
                 */


                // checking human inputs
                if (Player1.size() >= 3){
                    isPlayer1win = this.winCONDITIONS(Player1);
                }

                // player 1 wins
                if (isPlayer1win)
                    break;

                //  exit point for last input
                if (emptyCells.isEmpty())
                    continue;

                // COMPUTER SELECTION
                player2Input = (emptyCells.get(generator.nextInt((emptyCells.size()))));
                Player2.add(player2Input);
                cells[player2Input] = "\033[95m O \033[97m";
                emptyCells.remove((Integer) player2Input);

                // checking computer inputs
                    if (Player2.size() >= 3)
                        isPlayer2win = winCONDITIONS(Player2);

                    if (isPlayer2win)
                        break;
            }
            // Show massage if input Argument is wrong
            else {
                System.out.println("Please Enter the Correct Entry (*_ *;)\nThe player's turn is Player 1\n");
            }
        }
        // Show Win Massage
        wingMassage(isPlayer1win,isPlayer2win);
        // RESET THE GAME
            bored(cells);
            System.out.println("\n * You can restart the game with enter R key * ");

            String resetKey = Scan.next();
            resetKey = resetKey.trim().toLowerCase();
            while (!resetKey.equals("r")){
                System.out.println("\n * You can restart the game with enter R key * ");
            }
            new Menu().main_menu();
    }
    /**
     * PvP Game mode
     *  Player 1 : Human 1 plays as 'X'
     *  Player 2 : Human 2 plays as 'O'
     */
    public void PvP(){
        // Creat Scanner and Random Generator
        Random generator = new Random();
        Scanner Scan = new Scanner(System.in);

        // Make a String array for Argument of Bored
        String[] cells = new String[17];
        for (int i = 0; i < 16; i++){
            if (i < 9)
                cells[i] = String.format("%d ",i+1);
            else
                cells[i] = String.format("%d",i+1);
        }

        // BLOCKING
        // Make ane Arraylist for Blocking cells
        List<Integer> blockCells = new ArrayList<>(100);
        while (blockCells.size() < 3){
            blockCells.add(generator.nextInt(1 , 16) - 1);
        }

        // APPLY BLOCKED CELLS IN LIST
        List<Integer> emptyCells = new ArrayList<>(100);

        // APPLY BLOCKED CELLS IN BORED
        for (int i = 0; i < 3; i++) {
            cells[blockCells.get(i)] = "\033[91m # \033[97m";
        }

        // SETTING DEFAULTS
        // Setting empty cells
        for (int i = 0; i < 16; i++) {
            if (!blockCells.contains(i))
                emptyCells.add(i);
        }
        // Player1 storage
        List<Integer> Player1 = new ArrayList<>();
        int player1Input;
        boolean isPlayer1win = false;

        // Player 2 storage
        List<Integer> Player2 = new ArrayList<>();
        int player2Input;
        boolean isPlayer2win = false;


        while (!emptyCells.isEmpty()){

            System.out.println("The player's turn is Player 1\n");
            bored(cells);
            // get input from human
            player1Input = Scan.nextInt() - 1;
            // Check player 1 input
            if (emptyCells.contains(player1Input)){

                // HUMAN SELECTION
                Player1.add(player1Input);
                cells[player1Input] = "\033[94m X \033[97m";
                emptyCells.remove((Integer) player1Input);

                // My Algorithm  for check win conditions
                    /*
                 * //                if (Player1.size() >= 3){
//                    Collections.sort(Player1);
//
//                    for (int i = 0; i < Player1.size(); i++) {
//                        // exit point
//                        if (Player1.size() - i < 3 ){
//                            break;
//                        }
//
//                        // Horizontally
//                            if (Player1.get(i) + 1 == Player1.get(i + 1)){
//                                if (Player1.get(i + 1) + 1 == Player1.get(i + 2)){
//                                    isPlayer1win = true;
//                                    System.out.println("H");
//                                    break;
//                                }
//                            }
//
//                            // Vertically
//                            if (Player1.get(i) + 4  == Player1.get(i + 1)){
//                                if (Player1.get(i + 1) + 4 == Player1.get(i + 2)){
//                                    isPlayer1win = true;
//                                    System.out.println("V");
//                                    break;
//                                }
//                            }
//
//                            // Diagonally
//                        if (Player1.get(i) + 5  == Player1.get(i + 1)){
//                            if (Player1.get(i + 1) + 5 == Player1.get(i + 2)){
//                                isPlayer1win = true;
//                                System.out.println("D1");
//                                break;
//                            }
//                        }
//
//                        if (Player1.get(i) + 3  == Player1.get(i + 1)){
//                            if (Player1.get(i + 1) + 3 == Player1.get(i + 2)){
//                                isPlayer1win = true;
//                                System.out.println("D2");
//                                break;
//                            }
//                        }
//                    }
//                }
                 */


                // checking human inputs
                if (Player1.size() >= 3){
                    isPlayer1win = this.winCONDITIONS(Player1);
                }

                // player 1 wins
                if (isPlayer1win)
                    break;

                //  exit point for last input
                if (emptyCells.isEmpty())
                    continue;
                System.out.println("The player's turn is Player 2\n");
                do {
                    bored(cells);
                    player2Input = Scan.nextInt() - 1;
                    if (!emptyCells.contains(player2Input))
                        System.out.println("Please Enter the Correct Entry (*_ *;)\nThe player's turn is Player 2\n");
                } while (!emptyCells.contains(player2Input));

                // Player2 SELECTION
                Player2.add(player2Input);
                cells[player2Input] = "\033[95m O \033[97m";
                emptyCells.remove((Integer) player2Input);

                // checking computer inputs
                if (Player2.size() >= 3)
                    isPlayer2win = winCONDITIONS(Player2);

                if (isPlayer2win)
                    break;
            }
            // Show massage if input Argument is wrong
            else {
                System.out.println("Please Enter the Correct Entry (*_ *;)\nThe player's turn is Player 1\n");
            }
        }
        // Show Win Massage
        wingMassage(isPlayer1win,isPlayer2win);

        // RESET THE GAME
        bored(cells);
        System.out.println("\n * You can restart the game with enter R key * ");

        String resetKey = Scan.next();
        resetKey = resetKey.trim().toLowerCase();
        while (!resetKey.equals("r")){
            System.out.println("\n * You can restart the game with enter R key * ");
        }
        new Menu().main_menu();
    }
    /**
     *  Printing Bored
     * @param inputs a String array for :
     *      Placing "#" for blocked cells
     *      Placing "X" for Player 1 cells
     *      Placing "O" for player 2 cells
     */
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
                """, (Object[]) inputs);

    }
    /** Checking all win conditions
     * @param input  ArrayList of players inputs
     * @return a boolean if player wins return True
     */
    public  boolean winCONDITIONS(List<Integer> input){

        boolean result = input.contains(0) && input.contains(1) && input.contains(2);

        if (input.contains(1)  && input.contains(2)  && input.contains(3))   {result  = true;}
        if (input.contains(4)  && input.contains(5)  && input.contains(6))   {result  = true;}
        if (input.contains(5)  && input.contains(6)  && input.contains(7))   {result  = true;}
        if (input.contains(8)  && input.contains(9)  && input.contains(10))  {result  = true;}
        if (input.contains(9)  && input.contains(10) && input.contains(11))  {result  = true;}
        if (input.contains(12) && input.contains(13) && input.contains(14))  {result  = true;}
        if (input.contains(13) && input.contains(14) && input.contains(15))  {result  = true;}

        if (input.contains(0)  && input.contains(4)  &&  input.contains(8))   {result  = true;}
        if (input.contains(4)  && input.contains(8)  &&  input.contains(12))  {result  = true;}
        if (input.contains(1)  && input.contains(5)  &&  input.contains(9))   {result  = true;}
        if (input.contains(5)  && input.contains(9)  &&  input.contains(13))  {result  = true;}
        if (input.contains(2)  && input.contains(6)  &&  input.contains(10))  {result  = true;}
        if (input.contains(6)  && input.contains(10) &&  input.contains(14))  {result  = true;}
        if (input.contains(3)  && input.contains(7)  &&  input.contains(11))  {result  = true;}

        if (input.contains(7)  && input.contains(11) &&  input.contains(15))  {result  = true;}
        if (input.contains(0)  && input.contains(5)  &&  input.contains(10))  {result  = true;}
        if (input.contains(1)  && input.contains(6)  &&  input.contains(11))  {result  = true;}
        if (input.contains(4)  && input.contains(9)  &&  input.contains(14))  {result  = true;}
        if (input.contains(5)  && input.contains(10) &&  input.contains(15))  {result  = true;}

        if (input.contains(2)  && input.contains(5)  &&  input.contains(8))   {result  = true;}
        if (input.contains(3)  && input.contains(6)  &&  input.contains(9))   {result  = true;}
        if (input.contains(6)  && input.contains(9)  &&  input.contains(12))  {result  = true;}
        if (input.contains(7)  && input.contains(10) &&  input.contains(13))  {result  = true;}

        return result;
    }
    /**
     *  Show who Wins
     * @param player1win if true print : Player 1 wins
     * @param player2win if true print : player 2 wins
     *      else :
     *          print : Game was tied
     */
    public  void  wingMassage (boolean player1win, boolean player2win){
        if (player1win){
            System.out.println("\033[33mP L A Y E R   1   W I N S\033[97m");
        } else if (player2win) {
            System.out.println("\033[33mP L A Y E R   2   W I N S\033[97m");
        } else {
            System.out.println("\033[33mT h e   g a m e   w a s   t i e d\033[97m");
        }
    }
}
