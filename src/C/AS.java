package C;

public class AS implements State{
    private final Machine machine;
    public AS(Machine machine){
        this.machine=machine;
    }
    @Override
    public void runnable(){
        machine.setState(machine.getTGS());
        System.out.println("AS");
    }
}
