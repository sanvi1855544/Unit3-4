
import java.util.*;

class PLayground {


    public static void main(String args[]){
        //unit3problem1a(true);
        //unit3problem1b(1);
        //unit3problem1c(true, 1);
        //String option1 = "Thanks for attending. You will be served beef.";
        //String option2 = "Sorry you can't make it.";
        //unit3problem1d(option1, option2);
        //unit3problem2(2, 3, 4);
        //unit4problem1("CCAAAAATTT!");

    }

    public static void unit3problem1a(boolean rsvp){
        //conditional checking if true/false and prints output based off of that
        if (rsvp==true){
            System.out.println("attending");
        }
        else{
            System.out.println("not attending");
        }
    }

    public static void unit3problem1b(int selection){
        if (selection == 1){
            System.out.println("beef");
        }
        else if(selection == 2){
            System.out.println("chicken");
        }
        else if(selection == 3){
            System.out.println("pasta");
        }
        else{
            System.out.println("fish");
        }
    }

    public static String selectionToFood(int selection){
        //setting food based on selection
        //returning food output
        String food;
        if (selection == 1){
            food = "beef";
        }
        else if(selection == 2){
            food = "chicken";
        }
        else if(selection == 3){
            food = "pasta";
        }
        else{
            food = "fish";
        }

        return food;
    }

    public static void unit3problem1c(boolean rsvp, int selection){
        //conditional statement
        //calling selectiontoFood method to convert number to the corresponding food.
        if (rsvp == true){
            System.out.println("Thanks for attending. You will be served " + selectionToFood(selection) + ".");
        }
        else{
            System.out.println("Sorry you can't make it.");
        }

    }

    public static void unit3problem1d(String option1, String option2){
        //checking if strings are same or not
        if (option1.equals(option2)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }

    }

    //empty method so the program compiles
    public static void drawLine(int x1, int y1, int x2, int y2)
    {

    }

    public static void unit3problem2(int x, int y, int len){
        //checking if the square dimensions are out of bounds
        //sets len to 10 - x or y based on which is greater of the two
        if((x+len>10)||(y-len<0)){
            len = 10 -x;
            if (len > y){
                len = y;
            }
        }
        //using an array to refer to positions
        int[][] coordinates = new int[4][2];
        //giving each position a coordinate value
        coordinates[0][0] = x;
        coordinates[0][1] = y;
        coordinates[1][0] = x + len;
        coordinates[1][1] = y;
        coordinates[2][0] = x + len;
        coordinates[2][1] = y - len;
        coordinates[3][0] = x;
        coordinates[3][1] = y - len;
        //printing each segment
        drawLine(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);
        drawLine(coordinates[1][0], coordinates[1][1], coordinates[2][0], coordinates[2][1]);
        drawLine(coordinates[2][0], coordinates[2][1], coordinates[3][0], coordinates[3][1]);
        drawLine(coordinates[3][0], coordinates[3][1], coordinates[0][0], coordinates[0][1]);
    }

    public static void longestStreak(String s) {
        //setting global variables
        int count = 0;
        int maxCount = 0;
        char maxChar = 0;
        char c = 0;
        int i = 0;
        //use i and j as pointers, algo is if i and j are equal to each other that means consequetive char are same
        while(i < s.length()){
            count = 0;
            c = 0;
            for(int j =i; j<s.length(); j++){

                c = s.charAt(j);
                if(c == s.charAt(i)){
                    count++;
                }else{
                    c=s.charAt(i);
                    i=j;
                    break;
                }
            }
            //make sure that max count updates
            //sets maxchar to c
            if (count > maxCount){
                maxCount = count;
                maxChar = c;

            }
            i++;
        }
        //printing the max char and max count
        maxCount = maxCount + 1;
        System.out.println(maxChar + " " + maxCount);
    }

    //method that passes string to longestStreak method
    public static void unit4problem1(String s){
        longestStreak(s);
    }


    public static int getPlayer2Move(int round){
        //else if statement to write what happens in 3 possible conditions: div by 3, not div by 3 but div by 2, not div by 3 or 2
        if (round % 3 == 0){
            result = 3;
        }else if(round % 2 == 0){
            result = 2;
        }else {
            result = 1;
        }
        return result;

    }

    //assigned arbitrary number to round to test it
    //method passes round to getPlayer2Move
    public static void unit4problem2a(){
        int round = 8;
        getPlayer2Move(round);
    }

    //method to start problem
    public static void unit4problem2b(){
        playGame();
    }
    //note the method is not supposed to be static in the frq but we have to make it static as it is being called by another static method
    public static void playGame(){
        int round = 1;
        int p1coins = p2coins = startingCoins;
        int p1bet = p2bet = 0;
        //while all 2 conditions are true
        while( (round<=maxRounds) && (p1coins >= 3) && (p2coins >= 3) ){
            //this method call returns the amount player 1 spends
            p1bet = getPlayer1Move();
            //this subtracts the spent amount from player 1 coins
            p1coins -= p1bet;
            //this method call returns the amount player 2 spends
            p2bet = getPlayer2Move(round);
            //this subtracts the spent amount from player 2 coins
            p2coins -= p2bet;
            //uses absolute value to check if difference is 2
            if(Math.abs(p1bet-p2bet)==2){
                //if conditon true then 2 coins added to player 1
                p1coins = p1coins + 2;
            }else{
                //if condition false then 1 coin added to player 2
                p2coins += 1;
            }
            //round increased, eventually round will be max round ending loop
            round++;

        }

    }






}