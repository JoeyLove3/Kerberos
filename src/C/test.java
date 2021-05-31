package C;

public class test {
    public static void main(String[] args){
        Machine machine=new Machine();
        while(machine.getstate()!=machine.getFinish()) {
            machine.runnable();
        }
    }
}
