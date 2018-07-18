import java.util.*;

/**
 * Created by Vladimir on 14.07.2018.
 */
public class testRnd {
    public static void main(String[] args) {

        RandomStation randomStation = new RandomStation();
        randomStation.mapOfStations.put(0, "Подача");
        randomStation.mapOfStations.put(1, "Выигрыш очка");
        randomStation.mapOfStations.put(2, "Блок");
        randomStation.mapOfStations.put(3, "Проигрыш очка");
        randomStation.mapOfStations.put(4, "Защита");
        randomStation.mapOfStations.put(5, "Атака");
        randomStation.mapOfStations.put(6, "Приём подачи");
        int station = 6;
        int newStation;
        while (true) {
            newStation = randomStation.rnd(randomStation.table[station]);
            System.out.println(randomStation.mapOfStations.get(station) + " --> " +
                    randomStation.mapOfStations.get(newStation));
            System.out.println("=====================================================");
            station = newStation;
            if (newStation == 1 || newStation == 3) {
                return;
            }
        }

    }

    /*public static void rnd (int[] arr) {
        ArrayList<Integer> line = new ArrayList<Integer>();
        Random random = new Random();
        int sum = 0;
        for (int i : arr) {
            line.add(i);
            sum += i;
        }
        int dice = random.nextInt(sum);
        Arrays.sort(arr);
        int sumForSearch = 0;
        System.out.println(line);
        System.out.println(dice);
        for (int i : arr) {
            sumForSearch += i;
            if (sumForSearch >= dice) {
                System.out.println(line.indexOf(i) + " - номер, " + i + " - элемент, на котором вышли");
                return;
            }

        }
    }
    */

    public static void print (int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
