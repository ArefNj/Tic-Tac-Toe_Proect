import java.util.Scanner;

public class Menu {
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
        int key = Scan.nextInt();

        switch (key){
            case 1: // PvP menu
                this.isPvP_menu();
                break;
            case 2: // Info menu
                this.info();
                this.main_menu();
                break;
            case 3: // Exit
                System.out.println("Tnx for your attention ^.^\n\n");
                break;
            default: // if input was not valid
                System.out.println("Please Enter the Correct Entry (*_ *;) \n\n");
                this.main_menu();
                System.out.println("writing menu and abstractions");
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
