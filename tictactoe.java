import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class tictactoe {
    
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    public static void main(String[] args) {
        
        //2D array to print the board
        char[][] gameBoard = 
        {{' ', '|', ' ', '|',' '},
        {'-','+','-','+','-'},
        {' ', '|', ' ', '|',' '},
        {'-','+','-','+','-'},
        {' ', '|', ' ', '|',' '}};
  

    //method for printing the gameBoard
    printGameBoard(gameBoard);

    while(true){
    //Scanner
    Scanner scan = new Scanner(System.in);

    //Taking input from user
    System.out.println("Enter your placement (1-9)");
    //Position where the user wants to place their mark
    int pos = scan.nextInt();
        while(playerPositions.contains(pos)|| cpuPositions.contains(pos)){
            System.out.println("Enter another position!");
            pos = scan.nextInt();
        }
    //method to place the mark
    placeMark(gameBoard, pos,"player");
    String result = isWinner();
   if(result.length()>0){
       System.out.println(result);
       break;
}

    Random rand = new Random();
    int cpuPosition = rand.nextInt(9)+1;
    while(playerPositions.contains(cpuPosition)|| cpuPositions.contains(cpuPosition) ){
         cpuPosition = rand.nextInt(9)+1;
    }
    System.out.println("\nComputers marker:\n\n");
    placeMark(gameBoard, cpuPosition,"cpu");
    
   
   }
   
    
}

    private static void placeMark(char[][] gameBoard, int pos, String user) {

        char symbol =' ';
        if(user.equals("player")){
            symbol = 'X';
            playerPositions.add(pos);
        }
        else if(user.equals("cpu")){
            symbol = 'O';
            cpuPositions.add(pos);
        }
        //switch to perform certain action upon a certain number choice
        switch(pos){
            case 1:
            gameBoard[0][0]= symbol;
            break;
            case 2:
            gameBoard[0][2] = symbol;
            break;
            case 3:
            gameBoard[0][4] =symbol;
            break;
            case 4:
            gameBoard[2][0] = symbol;
            break;
            case 5:
            gameBoard[2][2] = symbol;
            break;
            case 6:
            gameBoard[2][4] = symbol;
            break;
            case 7:
            gameBoard[4][0] = symbol;
            break;
            case 8:
            gameBoard[4][2] = symbol;
            break;
            case 9:
            gameBoard[4][4] = symbol;
            break;
            default:
            break;
        }
    
        //Printing the gameBoard again
        printGameBoard(gameBoard);
    
    }

    private static String isWinner(){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for(List l :winning){
            if(playerPositions.containsAll(l)){
                return "Congratulations you Won!!";
            }
            else if(cpuPositions.containsAll(l)){
                return "Sorry you Lost :(";
            }
            else if(playerPositions.size()+ cpuPositions.size() ==9){
                return "TIE";
            }

        }
        return "";
        
    }
    private static void printGameBoard(char[][] gameBoard) {
        //Loop for Rows
        for(int i=0; i<5; i++){
            //Loop for Columns
            for(int j=0;j<5; j++){
                //Printing a Row
                System.out.print(gameBoard[i][j]);
            }
            //Changing Line
            System.out.println();
        }
    }


}
