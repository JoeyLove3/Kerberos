package AS;

public class Statemachine {
    public enum ASstate {
        listen{
            @Override
            public AS.Statemachine.ASstate nextstatus(){
                return verify;
            }
            @Override
            public AS.Statemachine.ASstate err(){ return listen; }
        },
        verify{
            @Override
            public AS.Statemachine.ASstate nextstatus(){ return echo; }
            @Override
            public AS.Statemachine.ASstate err(){ return listen; }
        },
        echo{
            @Override
            public AS.Statemachine.ASstate nextstatus(){ return listen; }
            @Override
            public AS.Statemachine.ASstate err(){ return listen; }

        };
        public abstract AS.Statemachine.ASstate nextstatus();

        public abstract AS.Statemachine.ASstate err();
    }
}
