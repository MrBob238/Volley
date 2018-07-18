import java.util.*;

/**
 * Created by Vladimir on 14.07.2018.
 */
public class RandomStation {
    int station = 0;
    public int newStation = 0;
    Random random = new Random();
    int[][] table = {
            {0, 11, 65, 15, 0, 9, 0},
            {100, 0, 0, 0, 0, 0, 0},
            {0, 23, 27, 26, 24, 0},
            {0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 41, 20, 39, 0},
            {0, 40, 30, 10, 0, 20, 0},
            {0, 9, 20, 11, 0, 60, 0},};
    Map<Integer, String> mapOfStations = new HashMap<>();
    int rnd(int[] arr) {
        ArrayList<Integer> line = new ArrayList<>();
        int[] tempArray = new int [arr.length];
        int sum = 0;
        int newStation = 0;
        int k;
        for (int i = 0; i < arr.length; i++) {
            k = arr[i];
            tempArray[i] = k;
            line.add(k);
            sum += k;
        }
        Random random = new Random();
        int dice = random.nextInt(sum - 1) + 1;
        Arrays.sort(tempArray); // Попробовать переделать без сортировки
        int sumForSearch = 0;
        System.out.println("=====================================================");
        System.out.println(line);
        System.out.println(dice + " - dice");
        for (int i : tempArray) {
            sumForSearch += i;
            if (sumForSearch >= dice) {
                newStation = line.indexOf(i);
                System.out.println(newStation + " - номер, " + i + " - элемент, на котором вышли");
                break;
            }
        }
    return newStation;
    }
}
