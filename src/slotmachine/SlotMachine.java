
package slotmachine;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SlotMachine {


    public static void main(String[] args) throws IOException, NumberFormatException {
        Scanner input = new Scanner(System.in);
        String words[] = {"Cherries", "Oranges", "Grapes", "Lemon", "Bars", "Sevens"};
        String checkWords[] = new String[3]; // random words will be stored here
        int initialmoney;
        double winningMoney;
        startGame();
        String yN;
        boolean flag = true;
        GamePlay gamePlay = new GamePlay();
        SaveAndExit saveAndExit = new SaveAndExit();
        while(flag){
            checkWords = gamePlay.initializeTheThreeSlots(words);
            System.out.println("How much money you want to bet? ");
            initialmoney = input.nextInt();
            winningMoney = gamePlay.checkTheSlotMachine(checkWords, initialmoney);
            System.out.println("You won: $" + winningMoney);
            System.out.println("Total winning: $" + gamePlay.getTotalWInningMoney());
            System.out.println("You want to play again? (Y/N)");
            yN = input.next();
            flag = gamePlay.yesNo(yN);
            if(flag == false){
                break;
            }
        }
        if(flag == false){            
            System.out.println("Your saved Score was: ");
            try {
                //saveAndExit.writeFile(gamePlay.getTotalWInningMoney());
                saveAndExit.readFile();
            } catch (IOException ex) {
                Logger.getLogger(SlotMachine.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("your recent score is: ");
            if(saveAndExit.compare(gamePlay.getTotalWInningMoney())){
                saveAndExit.writeFile(gamePlay.getTotalWInningMoney());
                //saveAndExit.readFile();
            }
            //saveAndExit.readFile();
            System.out.println(gamePlay.getTotalWInningMoney());

        }
    }
    
    public static void startGame(){
        System.out.println("Step right Ip and Try Your Luck at Kristin's Slot Machine!!!");
    }
    
}
