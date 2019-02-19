import memo.mainMemory;

public class reg{

    private int out1Addr;
    private int out2Addr;
    private int inAddr;

    private int[] register = new int[32];

    reg(int out1Addr,int out2Addr, int inAddr){
        this.out1Addr = out1Addr;
        this.out2Addr = out2Addr;
        this.inAddr = inAddr;
    }
    reg(int out1Addr, int inAddr){
        this.out1Addr = out1Addr;
        this.inAddr = inAddr;
    }

    public void getData(){
        MainMemory data = new MainMemeory();
        register[out1Addr] = data.lw(out1Addr);
        register[out2Addr] = data.lw(out2Addr);
    }

    public int getOut1(){
        return register[out1Addr];
    }

    public int getOut2(){
        return register[out2Addr];
    }

    public void saveIn(int in){
        register[inAddr] = in;
    }

}