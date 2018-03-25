/**
 * Created by Vladimir on 24.03.2018.
 */
public class GameCenter {
    public static void main(String[] args) {
        VolleyTeam belogorie = new VolleyTeam("Belogorie");
        VolleyTeam nova = new VolleyTeam("Nova");
        Match match = new Match(belogorie, nova);
        //System.out.println("Определедние победителя случайным образом: " + match.matchRnd(belogorie, nova));
        //System.out.println("Протокол матча. Первый сет: ");
        //System.out.println(match.setLine(belogorie, nova));
        System.out.println("Победитель матча: " + match.matchLine(belogorie, nova));
    }
}
