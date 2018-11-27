@Component
interface BattleComponent {
    War getWar();
}

public class BattleOfBastards {

    public static void main(String[] args){
//        Mannual DI
//        Starks starks = new Starks();
//        Boltons boltons = new Boltons();
//        War war = new War(starks,boltons);
//        war.prepare();
//        war.report();

//      Using Dagger 2
        BattleComponent component = DaggerBattleComponent.create();
        War war = component.getWar();
        war.prepare();
        war.report();

    }
}