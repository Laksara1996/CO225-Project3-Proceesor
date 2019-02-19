import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


public class InstructionMemory {

     private String instruction ;

     public  InstructionMemory(String instruction){

             this.instruction =instruction;

     }

     
     public  static HashMap<String,String> rtype_functions = new HashMap<String,String>();
     public  static HashMap<String,String> itype_functions = new HashMap<String,String>();
     public  static  HashMap<String,String> jtype_functions = new HashMap<String,String>();
    
     int rs;
     int rt;
     int rd;
     int shamt;
     int  immediate;
     int target_address;

    
     public void instructionFormats( ){

              /*to find function of R-type format*/
          
               rtype_functions.put("add","100000" );
               rtype_functions.put("sub","100010" );
               rtype_functions.put("mul","011000" );
               rtype_functions.put("div","011010" );
               rtype_functions.put("and","100100" );
               rtype_functions.put("or" ,"100101" );
               rtype_functions.put("nor","100111" );
               rtype_functions.put("xor","100110" );
               rtype_functions.put("srl","000010" );
               rtype_functions.put("sll","000000" );
               rtype_functions.put("slt","101010" );
               rtype_functions.put("syscall","0001100" );
               
               /*to find function of I-type format*/

               itype_functions.put("addi","001000");
               itype_functions.put("subi","001100");
               itype_functions.put("beq","000100");
               itype_functions.put("bgt","000111");
               itype_functions.put("lw","100011");
               itype_functions.put("sw","101011");

                /*to find function of J-type format*/

               jtype_functions.put("j target","000010");
               jtype_functions.put("jal target","000011");
               jtype_functions.put("jr target_register","010000");
              

     }

     String retunFunction(){  
           
          String opcode = instruction.substring(0,6);
         
          String functionCode=instruction.substring(26,32);
          String function=null;
          int rs1;
          int rt1;
          int rd1;
          int shamt1;
          int  immediate1;
          int target_address1;
          int p=0;
         
          if("000000".equals(opcode)) {         //R-type

           

            ////// R-type functions//////

            for (String key : rtype_functions.keySet()) {

              if(rtype_functions.get(key).equals(functionCode)) {
                  //  System.out.println(key);
                    function=key;
                    break;
              }
               
            }
              
              
          }else {  // I-type or J-type

            for (String key : itype_functions.keySet()) {

              if(itype_functions.get(key).equals(opcode)) {
                  //  System.out.println(key);
                    function=key;
                    break;
              }
               
            }
            
            for (String key : jtype_functions.keySet()) {

              if(jtype_functions.get(key).equals(opcode)) {
                   // System.out.println(key);
                    function=key;
                    break;
                  
              }
              
            }
          }
            //to find instruction format//

         if("000000".equals(opcode)){
             ////R-type instruction format////

             rs1 = Integer.parseInt(instruction.substring(6,11));
             rt1 = Integer.parseInt(instruction.substring(11,16));
             rd1 = Integer.parseInt(instruction.substring(16,21));	
             shamt1 = Integer.parseInt(instruction.substring(21,26));	
              
             while(rs1!=0)
             {
                 rs+=((rs1%10)*Math.pow(2,p));
                 rs1=rs1/10;
                 p++;
             }
             p=0;
             while(rt1!=0)
             {
                 rt+=((rt1%10)*Math.pow(2,p));
                 rt1=rt1/10;
                 p++;
             }
 
             p=0;
             while(rd1!=0)
             {
                 rd+=((rd1%10)*Math.pow(2,p));
                 rd1=rd1/10;
                 p++;
             }
 
             p=0;
             while(shamt1!=0)
             {
                 shamt+=((shamt1%10)*Math.pow(2,p));
                 shamt1=shamt1/10;
                 p++;
             }
          
             ////I-type instruction format////
          }else if("addi".equals(function) ||"subi".equals(function) ||"beq".equals(function) ||"bgt".equals(function) ||"lw".equals(function) ||"sw".equals(function)){

            rs1 = Integer.parseInt(instruction.substring(6,11));
            rt1 = Integer.parseInt(instruction.substring(11,16));
            immediate1 = Integer.parseInt(instruction.substring(16));	
            
            while(rs1!=0)
             {
                 rs+=((rs1%10)*Math.pow(2,p));
                 rs1=rs1/10;
                 p++;
             }
              
             p=0;
             while(rt1!=0)
             {
                 rt+=((rt1%10)*Math.pow(2,p));
                 rt1=rt1/10;
                 p++;
             }

             p=0;
             while(immediate1!=0)
             {
              immediate+=((immediate1%10)*Math.pow(2,p));
                 immediate1=immediate1/10;
                 p++;
             }

          }else if("j target".equals(function) || "jal target".equals(function) ||  "jr target_register".equals(function) ){   ////J-type instruction format////

            target_address1 = Integer.parseInt(instruction.substring(6));

            while(target_address1!=0)
             {
              target_address+=((target_address1%10)*Math.pow(2,p));
              target_address1=target_address1/10;
                 p++;
             }
            
          }
      
        

            return function;

      }  
     
        
        

      

}