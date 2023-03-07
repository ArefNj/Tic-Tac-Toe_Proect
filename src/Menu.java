import java.util.Scanner;

public class Menu {
    private boolean isPvP;

    // constructor
    public void main_menu(){

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

        // Checking input
        switch (key) {

            // PvP menu
            case 1 :
                    this.isPvP_menu();
                    if(isPvP)
                        new Game().PvP();
                    else
                        new Game().singlePlayer();

                    break;

            // Info menu
            case 2 : {
                this.info();
                this.main_menu();
                break;
            }
            // Exit
            case 3 :
                    System.out.println("Tnx for your attention ^.^\n\n");
                    break;
            // if input was not valid
            default : {
                System.out.println("Please Enter the Correct Entry (*_ *;)");
                pause();
                this.main_menu();
                break;
            }
        }
    }

    // Info menu
    public void info(){
        System.out.print   ("""
                                Advanced Programming Project #1
                                    
                            Tic-Tac-Toe game in a console application
                            
                        #The goal of Tic-Tac-Toe is to be one of the players to get three same symbols in a row
                        #Player 1 as ' X ' and player 2 as ' O ' enter their moves in each step.
                
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
        pause();


    }

    // PvP Menu (choosing between human and computer)
    public void isPvP_menu(){
        System.out.print("""
                    # Choose the second player
                    1. Human
                    2. Computer
                    """);

        // init PvP key and getIt from user
        int PvP_key = new Scanner(System.in).nextInt();
        // Checking input
        switch (PvP_key) {
            case 1 -> setPvP(true);
            case 2 -> setPvP(false);
            default -> {
                System.out.println("Please Enter the Correct Entry (*_ *;)");
                pause();
                isPvP_menu();
            }
        }
    }

    // Getter
    public boolean isPvP() {
        return isPvP;
    }

    // Setter
    public void setPvP(boolean pvP) {
        isPvP = pvP;
    }

    // System Pause
    public void pause(){
        System.out.println("Press Any Key To Continue...");
        new java.util.Scanner(System.in).nextLine();
    }
}
