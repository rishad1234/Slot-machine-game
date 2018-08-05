
package slotmachine;


public class GamePlay {
    
    private static double totalWInningMoney; // total Winning money
    
    //getters

    public double getTotalWInningMoney() {
        return totalWInningMoney;
    }
  
    //methods
    public int generateRandom(){
        int random = (int) Math.round(Math.random() * 5);
        return random;
    }
    public boolean yesNo(String yN){
        String flag = yN.toLowerCase();
        return flag.equals("y");
        
    }
    public String[] initializeTheThreeSlots(String[] words){
        String[] checkWords = new String[3];
        
        for(int i = 0; i < 3; i++){
            int randomIndex = generateRandom();
            switch(randomIndex){
                case 0: checkWords[i] = words[0];
                        break;
                case 1: checkWords[i] = words[1];
                        break;
                case 2: checkWords[i] = words[2];
                        break;
                case 3: checkWords[i] = words[3];
                        break;
                case 4: checkWords[i] = words[4];
                        break;    
                case 5: checkWords[i] = words[5];
                        break;        
            }
        }
        return checkWords;
    }
    
    public double checkTheSlotMachine(String[] checkWords, int money){
        double mon = 0.0;
        if(checkWords[0].equals(checkWords[1]) && checkWords[0].equals(checkWords[2])){
            mon = money * 3;
            totalWInningMoney += mon;
        }
        else if(checkWords[0].equals(checkWords[1]) || checkWords[0].equals(checkWords[2]) ||
                checkWords[1].equals(checkWords[2])){
            mon = money * 2;
            totalWInningMoney += mon;
        }
        else{
            System.out.println("You earned $0");
        }
        return mon;
    }   
    
}
