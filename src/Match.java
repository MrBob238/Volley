import java.util.Random;

/**
 * Created by Vladimir on 24.03.2018.
 */
public class Match {
    private VolleyTeam teamA;
    private VolleyTeam teamB;
    private VolleyTeam winner = null;
    private int pointsA = 0, pointsB = 0;
    private double serveTeam; // 0.20 - TeamA, -0.20 - TeamB;

    public Match(VolleyTeam teamA, VolleyTeam teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.serveTeam = randomK(0.70, 1.30) > 1 ? 0.20 : -0.20;
    }

    /*
    * Вычисляет победителя из двух переданных команд, используя randomK:
    * Сначала сумма навыков одной команды делится на сумму навыков другой = skillK. Из этого коэффициента вычитается
    * результат работы randomK [0.7; 1.3). Если итог >= 0 - победила команда А.
    * 29.06.18
    * Реализован переход подачи: serveTeam = 0.2, если очко набрала teamA и = -0.2, если teamB
     */
    public VolleyTeam matchRnd(VolleyTeam teamA, VolleyTeam teamB) {
        teamA = teamA;
        teamB = teamB;
        double rndK = randomK(0.70,1.30);
        double skillK = teamA.totalSkill / teamB.totalSkill;
        winner = ((skillK) - rndK - serveTeam >= 0) ? teamA : teamB;
        serveTeam = winner.equals(teamA) ? 0.2 : -0.2;
        return winner;
    }

    /*
    * Определяет победителя в каждом розыгрыше в отдельно взятой партии, используя matchRnd().
    * Возвращает ленту событий (только очки).
    * Пока что игра идёт строго до 25 очков =/
    * Добавление зависимости длины партии от номера партии (5-я партия до 15). ++ 29.06.18
    * Добавление игры до разницы в 2 очка. ++ 29.06.18
     */

    public String setLine(VolleyTeam teamA, VolleyTeam teamB, int numOfSet) {
        String result;
        StringBuilder firstTeam = new StringBuilder("Team A ");
        StringBuilder secondTeam = new StringBuilder("Team B ");
        int maxPoints = numOfSet == 5 ? 15 : 25;

        while ((pointsA < maxPoints) && (pointsB < maxPoints)) {
            VolleyTeam winner = matchRnd(teamA, teamB);
            if (winner.equals(teamA)) {
                pointsA++;
                String strPointsA = "" + pointsA;
                firstTeam.append("|" + strPointsA);
                secondTeam.append("|" + strPointsA.replaceAll("\\d"," "));
                if ((pointsA >= maxPoints - 1) && (pointsA == pointsB)) maxPoints++;
            }
            if (winner.equals(teamB)) {
                pointsB++;
                String strPointsB = "" + pointsB;
                secondTeam.append("|" + strPointsB);
                firstTeam.append("|" + strPointsB.replaceAll("\\d"," "));
                if ((pointsA >= maxPoints - 1) && (pointsA == pointsB)) maxPoints++;
            }
        }
        result = firstTeam.toString() + "\n" + secondTeam.toString() + "\n" +
        teamA.getName() + " - " + teamB.getName() + " " + pointsA + " : " + pointsB;
        return result;
    }

    public VolleyTeam matchLine (VolleyTeam teamA, VolleyTeam teamB) {
        int setsWinTeamA = 0;
        int setsWinTeamB = 0;
        int numberOfSet = 1;
        StringBuilder resultOfMatch = new StringBuilder();
        VolleyTeam winnerOfMatch;
        while ((setsWinTeamA < 3) && (setsWinTeamB < 3)) {
            pointsA = 0;
            pointsB = 0;
            System.out.println("Начало " + numberOfSet + " сета");
            System.out.println(setLine(teamA, teamB, numberOfSet));
            for (int i = 0; i < 10000 ; i++){}
            if (pointsA > pointsB) {
                setsWinTeamA++;
                System.out.println("Победитель " + numberOfSet + " сета - " + teamA.getName());
            } else {
                setsWinTeamB++;
                System.out.println("Победитель " + numberOfSet + " сета - " + teamB.getName());
            }
            resultOfMatch.append("(" + pointsA + ":" + pointsB + ") ");
            numberOfSet++;
        }
        winnerOfMatch = (setsWinTeamA == 3) ? teamA : teamB;
        System.out.println(teamA.getName() + " - " + teamB.getName() + " " + setsWinTeamA + ":"
                + setsWinTeamB + "  " + resultOfMatch.toString());
        return winnerOfMatch;
    }

    /*
    Возвращает псевдослучайное вещественное число из заданного диапазона
     */
    public double randomK (double min, double max) {
        return (Math.random()* (max - min) + min);
    }
}
