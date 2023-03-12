import java.util.*;

public class Game {
    int FULLCELL = -1;

    public void singlePlayer(){
        Random generator = new Random();
        Scanner Scan = new Scanner(System.in);

        String[] cells = new String[17];
        for (int i = 0; i < 16; i++){
            if (i < 9)
                cells[i] = String.format("%d ",i+1);
            else
                cells[i] = String.format("%d",i+1);
        }

        // BLOCKING

        List<Integer> blockCells = new ArrayList<>(100);
        while (blockCells.size() < 3){
            blockCells.add(generator.nextInt(1 , 16) - 1);
        }

        // APPLY BLOCKED CELLS IN LIST
        List<Integer> emptyCells = new ArrayList<Integer>(100);

        // APPLY BLOCKED CELLS IN BORED
        for (int i = 0; i < 3; i++) {
             cells[blockCells.get(i)] = "\033[91m # \033[97m";
        }

        // setting defaults

        // setting empty cells
        for (int i = 0; i < 16; i++) {
            if (!blockCells.contains(i))
                emptyCells.add(i);
        }

        // player1 storage
        List<Integer> Player1 = new ArrayList<Integer>();
        int player1Input;
        boolean isPlayer1win = false;


        // player 2 storage
        List<Integer> Player2 = new ArrayList<Integer>();
        int player2Input;
        boolean isPlayer2win = false;


        System.out.println("The player's turn is Player 1\n");
        while (!emptyCells.isEmpty()){

            bored(cells);
            // get input from human
            player1Input = Scan.nextInt() - 1;

            if (emptyCells.contains(player1Input)){

                // HUMAN SELECTION
                    Player1.add(player1Input);
                    cells[player1Input] = "\033[94m X \033[97m";
                    emptyCells.remove(emptyCells.indexOf(player1Input) + 0);

                        // WIN CONDTIONS player 1

//                if (Player1.size() >= 3){
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

                // WIN CONDITIONS player 1


                // checking human inputs
                if (Player1.size() >= 3){
                    isPlayer1win = this.winCONDITIONS(Player1);
                }

                // player 1 wins
                if (isPlayer1win)
                    break;

                //exit point for last input
                if (emptyCells.isEmpty())
                    continue;

                // COMPUTER SELECTION
                player2Input = (emptyCells.get(generator.nextInt((emptyCells.size()))));
                Player2.add(player2Input);

                cells[player2Input] = "\033[95m O \033[97m";
                emptyCells.remove(emptyCells.indexOf(player2Input) + 0);

                // checking computer inputs
                if (Player2.size() >= 3)
                    isPlayer2win = winCONDITIONS(Player2);

                if (isPlayer2win)
                    break;
            }
            else {
                System.out.println("Please Enter the Correct Entry (*_ *;)\nThe player's turn is Player 1\n");
            }
        }

        if (isPlayer1win){
            System.out.println("\033[33mP L A Y E R   1   W I N S\033[97m");
        } else if (isPlayer2win) {
            System.out.println("\033[33mP L A Y E R   2   W I N S\033[97m");
        } else {
            System.out.println("\033[33mT h e   g a m e   w a s   t i e d\033[97m");
        }

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
        List<Integer> blockCells = new ArrayList<>(100);
        while (blockCells.size() < 3){
            blockCells.add(generator.nextInt(0 , 15));
        }


        // 2.Apply Blocked Cells in bored
        for (int i = 0; i < 3; i++) {
            cells[blockCells.get(i)] = "\033[91m # \033[97m";

        }

        // 3.Apply Blocked Cells in available cells list
        List<Integer> emptyCells = new ArrayList<Integer>(100);
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
    public  boolean winCONDITIONS(List<Integer> input){

        boolean result = false;

        if (input.contains(0)  && input.contains(1)  && input.contains(2))   {result  = true;}
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
}
