import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class WPMProgram {

    static Boolean loop= true;
    
    // selection of words the randomiser picks from
    static String[] words ={"quick","brown","fox","jumped","over","the","lazy","dog","random","enevlope",
    "test","dramatic","samsung","apple","microsoft","amamzon","java","python","javascript","xml","windows","linux"};

    //imports random tool
    static  Random rand = new Random();
    static Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    public static void main(String [] args) throws InterruptedException{


        //sets up the difficulty 
        int difficulty = 0;

        //loops until the user inputs the correct difficulty 
        System.out.println("Select difficulty: Low (L), Medium (M), High (H)");
        do {
           

            String difficultySelect = scanner.nextLine().toUpperCase();

            switch (difficultySelect) {

                case "L":
                    difficulty = 5;
                    System.out.println("You selected Low difficulty");
                    loop = false;
                    break;

                case "M":
                    difficulty = 10;
                    System.out.println("You selected Medium difficulty");
                    loop = false;
                    break;

                case "H":
                    difficulty = words.length;
                    System.out.println("You selected High difficulty");
                    loop = false;
                    break;

                default:
                    System.out.println("Invalid difficulty selection. Low (L), Medium(M) or High(H)");
                    break;

            }

        } while (loop);
        
        //does the intial countdown
        for(int num=3; num>0; num--){

            System.out.println(num);
            TimeUnit.SECONDS.sleep(1);
        }


        //prints out word amount depending on difficulty selected by user 
        while(difficulty>0){
        System.out.print(words[rand.nextInt((words.length-1))]+ " ");
        difficulty=difficulty-1;
        }
        System.out.println();

        //all about the timetaken
        double starttimer = LocalTime.now().toNanoOfDay();
        //allows user input
        String typedWords = scanner.nextLine();

        double end = LocalTime.now().toNanoOfDay();
        
        //calculates time taken for user to enter
        double timetaken = (end -starttimer)/1000000000.0;

        //calculates total wpm
        int wpm = (int) ((((double) typedWords.length()/5.0) /timetaken)*60) ;


        //gives user final result
        System.out.println("You took: "+ timetaken +" seconds \nAnd your words per minute was: " + wpm);


    }

    
}
