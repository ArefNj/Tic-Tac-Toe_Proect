import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public void main_menu() throws IOException {

        // creat a Scanner
        Scanner Scan = new Scanner(System.in);

        // print menu
        System.out.print   ("""
                Welcome to Tic-Tac-Toe game
                        1.Start\s
                        2.Info\s
                        3.Exit\s
                --->\040""");
        // init key and get it from user
        int key = Scan.nextInt();


        switch (key) {
            case 1 -> // PvP menu
                    this.isPvP_menu();
            case 2 -> { // Info menu
                this.info();
                System.out.print   ("""
                                Advanced Programming Project #1
                                    
                          Tic-Tac-Toe game in a console application
                                 
                        There are a few differences with the classical one:
                            # The board is square with 16 cells (4*4)
                            # Some cells will be randomly locked
                            #The goal of Tic-Tac-Toe is to be one of the players to get three same symbols in a row
                            # Up to 2 players can play simultaneously (PvP or single-player)

                            Player 1 as ' X ' and player 2 as ' O ' enter their moves in each step.
                                    
                            # there are only three possible results:
                                o a player wins
                                o his opponent (human or computer) wins
                                o it's a tie! (For equal or impossible score)
                                    
                            Author : Aref Najmaddini
                            Email  : Aref.Najmaddini@gmail.com
                            Tnx to :
                                Dr. Shokoofeh Bostan
                            Head-Ta :
                                Mohsen Gholami
                            Tas :
                                Ali Khaleghi Yekta
                                Pooria Azami
                        """);
                System.out.println("Press Enter key to continue");


                Scan.next();


                this.main_menu();
            }
            case 3 -> // Exit
                    System.out.println("Tnx for your attention ^.^\n\n");
            default -> { // if input was not valid
                System.out.println("Please Enter the Correct Entry (*_ *;) \n\nPress Enter key to continue");
                System.in.read();
                this.main_menu();
                System.out.println("writing menu and abstractions");
            }
        }






    }

    public void info(){

        System.out.println("** INFO **");

    }

    public int isPvP_menu(){

        System.out.println("** PVP **");

        return 0;
    }
}
