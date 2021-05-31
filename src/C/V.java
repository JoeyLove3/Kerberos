package C;

public class V implements State {
    private final Machine machine;
    public V(Machine machine){
        this.machine=machine;
    }
    @Override
    public void runnable(){
        machine.setState(machine.getFinish());
        System.out.println("V");
    }
}
