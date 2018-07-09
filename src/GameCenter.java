/**
 * Created by Vladimir on 24.03.2018.
 */
public class GameCenter {
    public static void main(String[] args) {
        VolleyTeam belogorie = new VolleyTeam("Belogorie");
        belogorie.load("Belogorie.properties");
        VolleyTeam nova = new VolleyTeam("Nova");
        Match match = new Match(belogorie, nova);
        //System.out.println(match.setLine(belogorie, nova));
        System.out.println("Победитель матча: " + match.matchLine(belogorie, nova));
        //Вынести в отдельный метод, где будет всё подведение итогов.
        VolleyTeam winner = match.getMatchWinner();
        if (winner.equals(belogorie)) {
            belogorie.setMorale(belogorie.getMorale()+1);
            nova.setMorale(nova.getMorale()-1);
        }
        if (winner.equals(nova)) {
            nova.setMorale(nova.getMorale()+1);
            belogorie.setMorale(belogorie.getMorale()-1);
        }

        nova.save("Nova.properties");
        belogorie.save("Belogorie.properties");
    }
}
