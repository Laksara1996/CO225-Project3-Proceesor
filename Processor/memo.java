

public class memo{

    interface memory{
        int lw(int addr);
        void sw(int addr, int val);
    }
    public static class MainMemory implements memory{
        
        private int[] main_memory = new int[32];

        public int lw(int addr){
            return main_memory[addr];
        }

        public void sw(int addr, int val){
            main_memory[addr] = val;

        }
    }

  /*  public static class CacheMemory implements memory{
        
        private int[] cache_memory = new int[32];

        public int lw(int addr){
            return cache_memory[addr];
        }

        public void sw(int addr, int val){
            cache_memory[addr] = val;

        }
    }*/

    public static void main(String [] args){
        MainMemory ex = new MainMemory();
        ex.sw(0,10);
        ex.sw(2,20);
        int ans = ex.lw(2);
        System.out.println(ans);
    }
}