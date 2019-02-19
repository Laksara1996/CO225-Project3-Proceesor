import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class DataRead{

    static final String FileName = "Instruction.txt";
    static String line;

    public static void main(String [] args) throws FileNotFoundException,IOException{

        
        FileReader fileReader;
        fileReader = new FileReader(FileName);
        
        BufferedReader bufferReader = new BufferedReader(fileReader);
        
        while ( (line = bufferReader.readLine()) != null ){

           InstructionMemory IM = new  InstructionMemory(line);
           IM.instructionFormats();
           IM.retunFunction();
            
        	
            
        }

    }
}