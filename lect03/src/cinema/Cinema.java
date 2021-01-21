/************************************************************
 * Student ID:6330300208
 * First Name:Yadaporn
 * Last Name: Ajmontri
 *
 * Team:
 * 1. 6330300208 : Yadaporn Ajmontri
 * 2. 6330300461 : Terapat Malaob
 * 3. 6330300879 : Supanut Klakerdpol
 *
 *
 *
 ************************************************************/
package cinema;

import java.util.Scanner;

public class Cinema {

    final static Scanner scanner = new Scanner(System.in);
    final static char EMPTY ='S';
    final static char BOUGHT ='B';
    final static int Frontrow = 100;
    final static int Backrow =80;
    private int numRow;
    private int numSeat;
    private int numPurchase;
    private int income;
    private int totseat;
    private int frontRow;
    private int backRow;
    private char[][] cinema;

    Cinema(int numRow, int numSeat) {
        this.numRow = numRow;
        this.numSeat = numSeat;
        this.totseat= numRow*numSeat;
        this.frontRow=numRow/2;
        this.backRow=numRow-this.frontRow;
        this.numPurchase =0;
        this.initCinema();}

    void initCinema()
    {
            this.cinema = new char[this.numRow][this.numSeat];
            for (int i =0;i<this.numRow;i++)
                for(int j =0;j<this.numSeat;j++)
                    this.cinema[i][j] = EMPTY;
        }


    void showCinema() {
        int nr,nc;
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int j=1; j<=this.numSeat;j++)
            System.out.print(j+" ");
        System.out.println();
        for (int i=0; i<this.numRow;i++){
            System.out.print((i+1)+" ");
            for(int j=0;j<this.numSeat;j++)
        {
            System.out.print(this.cinema[i][j]+" ");
        }
        System.out.println();
        }
        System.out.println("\n"+EMPTY+": หมายถึง ว่าง");
        System.out.println(BOUGHT+": หมายถึง ซื้อแล้ว");}

    boolean isWrongInput(int nr,int sr){
        if (nr<=0 || sr <=0){
            return true;}
        if (nr>this.numRow || sr > this.numSeat){
            return true;}
        return false;
    }
    boolean isTicketAvailable(int nr,int sr) {
        return this.cinema[nr - 1][sr - 1] == EMPTY;
    }
    boolean isLarge(){
        return this.totseat>60;}
    int getTicketPrice(int nr) {
        int price = Frontrow;
        if (isLarge()) {
            if (nr > frontRow) {
                price = Backrow;
            }
        }
        return price;
    }


    void doBuyTicket(int nr,int sr){
        int price = getTicketPrice(nr);

        this.numPurchase++;
        this.cinema[nr-1][sr-1] = BOUGHT;
        System.out.printf("Ticket Price : %d BAHT\n",price);
        this.income+=price;

    }



    void buyTicket()
    {
        boolean check=false;
        while(!check) {

            System.out.println("Enter a row number:");
            System.out.print(">");
            int nr = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            System.out.print(">");
            int sr = scanner.nextInt();
            if (isWrongInput(nr,sr)){
                System.out.println("\nWrong input!");

            } else if (! isTicketAvailable(nr,sr)) {
                System.out.println("\nThat ticket has already been purchased!");
            } else {
                doBuyTicket(nr,sr);
                check=true;

                }

            }
        }

    int totalIncome(){
        int total;//=(this.frontRow*this.numSeat*Frontrow)+(this.backRow*this.numSeat*Backrow);
        if(isLarge()){
            total=(this.frontRow*this.numSeat*Frontrow)+(this.backRow*this.numSeat*Backrow);
        }
        else{
            total=this.totseat*100;
        }
        return total;
    }



    void showStatistics() {
        double count=0.0,rowColumn=this.numSeat*this.numRow;
        for(int i=0;i<this.numRow;i++){
            for(int j=0;j<this.numSeat;j++){
                if(cinema[i][j]=='B'){
                    count++;
                }
            }
        }
        double percent=(count/rowColumn)*100;
        System.out.println("Number of purchased tickets: "+(int)count);
        System.out.printf("Percentage: %.2f",percent);
        System.out.println("%");
        System.out.println("Current income: "+this.income+" BAHT");
        System.out.println("Total income: "+totalIncome()+" BAHT");
    }

    static void showMenu() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        System.out.println();
    }

    static void showPrompt() {
        System.out.print("> ");
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        showPrompt();
        int numRow = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        showPrompt();
        int numSeat = scanner.nextInt();
        Cinema cinema = new Cinema(numRow, numSeat);
        int choice;
        boolean end = false;
        while (!end && true) {
            showMenu();
            showPrompt();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    cinema.showCinema();
                    break;
                case 2:
                    cinema.buyTicket();
                    break;
                case 3:
                    cinema.showStatistics();
                    break;
                case 0:
                    end = true;
                    break;
                default:
                    break;
            }
        }

    }


}
    void buyTicket() {
       // TODO
    }

    void showStatistics() {
       // TODO
    }
        
    static void showMenu() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");                    
        System.out.println();
    }

    static void showPrompt() {
        System.out.print("> ");
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        showPrompt();
        int numRow = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        showPrompt();
        int numSeat = scanner.nextInt();
        
        Cinema cinema = new Cinema(numRow, numSeat);
        int choice;
        boolean end = false;
        while (!end && true) {
            showMenu();
            showPrompt();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    cinema.showCinema();                
                    break;
                case 2:
                    cinema.buyTicket();
                    break;
                case 3:
                    cinema.showStatistics();
                    break;
                case 0:
                    end = true;
                    break;
                default:
                    break;
            }
        }        
        
    }
}
