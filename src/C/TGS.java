package C;

public class TGS implements State{
    private final Machine machine;
    public TGS(Machine machine){
        this.machine=machine;
    }
    @Override
    public void runnable(){
        machine.setState(machine.getV());
        System.out.println("TGS");
    }
}
