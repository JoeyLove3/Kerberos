package C;

public class Machine {
    private final State AS;
    private final State TGS;
    private final State V;
    private final State Finish;

    private State state;

    public Machine() {
        this.AS = new AS(this);
        this.TGS = new TGS(this);
        this.V = new V(this);
        this.Finish = new Finish(this);
        this.state=AS;
    }

    public void runnable(){
        state.runnable();
    }

    public State getstate(){return this.state;}

    public State getAS() {
        return AS;
    }

    public State getTGS() { return TGS; }

    public State getV() {
        return V;
    }

    public State getFinish() { return Finish; }

    public void setState(State state) {
        this.state = state;
    }
}
