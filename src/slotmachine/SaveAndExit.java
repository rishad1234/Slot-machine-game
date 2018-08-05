
package slotmachine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SaveAndExit {
    private final String fileName = "HighScore.txt";
    private String line;
        public void writeFile(double score){
        String line1 = Double.toString(score);
        try {
            FileWriter fileWrite = new FileWriter(fileName);
            try (BufferedWriter bufferWriter = new BufferedWriter(fileWrite)) {
                bufferWriter.write(line1);
            }
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
        
    public void readFile() throws IOException{
        //String line;
        try {
            FileReader fileRead = new FileReader(fileName);
            try (BufferedReader bufferRead = new BufferedReader(fileRead)) {
                line = bufferRead.readLine();
//                System.out.println(line);
                while(!(line.isEmpty())){
                    System.out.println(line);
                    break;
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public boolean compare(double score1) throws IOException, NumberFormatException{
        
        
        String getTheNumberFromFile = line;
        double putLine = Double.parseDouble(getTheNumberFromFile);
        
        if(score1 >= putLine){
            return true;
        }
        return false;
    }

    public String getLine() {
        return line;
    }    
}
