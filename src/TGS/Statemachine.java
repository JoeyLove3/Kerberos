package TGS;

public class Statemachine {
    public enum TGSstate {
        listen{
            @Override
            public TGSstate nextstatus(){
                return verify;
            }
            @Override
            public TGSstate err(){ return listen; }
        },
        verify{
            @Override
            public TGSstate nextstatus(){ return echo; }
            @Override
            public TGSstate err(){ return listen; }
        },
        echo{
            @Override
            public TGSstate nextstatus(){ return listen; }
            @Override
            public TGSstate err(){ return listen; }

        };
        public abstract TGSstate nextstatus();

        public abstract TGSstate err();
    }
}