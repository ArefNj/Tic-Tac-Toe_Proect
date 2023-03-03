import java.util.Scanner;

public class Menu {
    private boolean isPvP;
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
        switch (key) {
            case 1 : // PvP menu
                    this.isPvP_menu();
                    new Game().test();
                    break;

            case 2 : { // Info menu
                this.info();
                this.main_menu();
                break;
            }
            case 3 : // Exit
                    System.out.println("Tnx for your attention ^.^\n\n");
                    break;
            default : { // if input was not valid
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                    # Choose the second player
                    1. Human
                    2. Computer
                    """);
        int PvP_key =  scanner.nextInt();

        switch (PvP_key){
            case 1:
                setPvP(true);
                break;
            case 2:
                setPvP(false);
                break;
            default:
                System.out.println("Please Enter the Correct Entry (*_ *;)");
                pause();
                isPvP_menu();
                break;
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
