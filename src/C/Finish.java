package C;

public class Finish implements State {
    private final Machine machine;
    public Finish(Machine machine){
        this.machine=machine;
    }
    @Override
    public void runnable(){
        System.out.println("Finish");
    }
}
