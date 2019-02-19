import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


public class InstructionMemory {

   

     
     public  static HashMap<String,String> rtype_functions = new HashMap<String,String>();
     public  static HashMap<String,String> itype_functions = new HashMap<String,String>();
     public  static  HashMap<String,String> jtype_functions = new HashMap<String,String>();
    


    
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

          String instruction ="00000000000000000000000000100000"; 
          String opcode = instruction.substring(0,6);
          String functionCode=instruction.substring(26,32);
          String function=null;
        
         
          if("000000".equals(opcode)) {
                
            for (String key : rtype_functions.keySet()) {

              if(rtype_functions.get(key).equals(functionCode)) {
                    System.out.println(key);
                    function=key;
                    break;
              }
               
            }
              
              
          }else {

            for (String key : itype_functions.keySet()) {

              if(itype_functions.get(key).equals(opcode)) {
                    System.out.println(key);
                    function=key;
                    break;
              }
               
            }
            
            for (String key : jtype_functions.keySet()) {

              if(jtype_functions.get(key).equals(opcode)) {
                    System.out.println(key);
                    function=key;
                    break;
                  
              }
              
            }
          }

            return function;

      }  
     
        
        

       public static void main(String args[]){

          InstructionMemory ob = new InstructionMemory();
          ob.instructionFormats();
          ob.retunFunction();
         
         
        

         }

}
// ALU
public class ALU {
    String compare ;
    compare = function ;
// compare and redirect to function
    switch(compare)

    {
        case "add":
            add();
            break;
        case "sub":
            sub();
            break;
        case "mul":
            mul();
            break;
        case "div":
            div();
            break;
        case "and":
            and();
            break;
        case "or":
            or();
            break;
        case "nor":
            nor();
            break;
        case "xor":
            xor();
            break;
        case "srl":
            srl();
            break;
        case "sll":
            sll();
            break;
        case "slt":
            slt();
            break;
        case "syscall":
            syscall();
            break;
        case "addi":
            addi();
            break;
        case "subi":
            subi();
            break;
        case "beq":
            beq();
            break;
        case "bgt":
            bgt();
            break;
        case "lw":
            lw();
            break;
        case "sw":
            sw();
            break;
        case "j target":
            j();
            break;
        case "jal target":
            jal();
            break;
        case "jr target_register":
            jr();
            break;
        default :
            System.out.println("Error in ALU");
    }
    int add (int rs , int rt){

        int rd = rs + rt ;
        return rd ;

    }
    int sub (int rs , int rt){

        int rd = rs - rt ;
        return rd ;

    }
    int mul (int rs , int rt){

        int rd = rs * rt ;
        return rd ;

    }
    int div (int rs , int rt){

        int rd = rs / rt ;
        return rd ;

    }
    int and (int rs , int rt){

        int rd = rs & rt ;
        return rd ;

    }
    int or (int rs , int rt){

        int rd = rs | rt ;
        return rd ;

    }
    int nor (int rs , int rt){

        int rd = ~(rs | rt) ;
        return rd ;

    }
    int xor (int rs , int rt){

        int rd = rs ^ rt ;
        return rd ;

    }
    int srl (int rs , int rt){

        int rd = rs >> rt ;
        return rd ;

    }
    int sll (int rs , int rt){

        int rd = rs << rt ;
        return rd ;

    }
    int slt (int rs , int rt){

        int rd = (rs < rt) ? 1:0 ;
        return rd ;  // take 1 as set value for rd

    }
    void syscall (){

        System.out.println("syscall");

    }
    int addi (int rs , int imm){

        int rt = rs + imm ;
        return rt ;

    }
    int subi (int rs , int imm){

        int rt = rs + imm ;
        return rt ;

    }
    int beq (int rs , int target){

        int rt = (rs == target) ? 1:0 ;
        return rt ; // 1 if target true

    }
    int bgt (int rs , int target){

        int rt = (rs > target) ? 1:0 ;
        return rt ; // 1 if target true

    }
    // not so sure to write function for j-tyoe



}