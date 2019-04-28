import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.util.Collections.shuffle;

/**
 * Created by GTT for M.Badazhkov on 13.05.2017.
 */
public class FormingGraphMadeLikeMain {

    static int NnPrib = random2(70, 80);
    static int NnOtpr = getRandomNnOtpr(NnPrib);

    public static void main(String[] args) throws IOException {

        int countCategory0;
        int countCategory1;
        int countCategory24;
        int tn1;
        int tn2;
        int tnPercent1;
        int tnPercent2;
        int intervalsCount = getNnOtpr();
        int tn1Count;
        int tn2Count;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Создано " + getNnPrib() + " ниток прибытия.");
            System.out.println("Создано " + getNnOtpr() + " ниток отправления.");
            System.out.println("Укажите соотношение в процентах. Соотношение категории << от 2 до 4 >> рассчитается автоматически.");

        while (true) {
            System.out.println("Введите % соотношение категории << 0 >>");

            countCategory0 = Integer.parseInt(br.readLine()) * NnOtpr / 100;
            System.out.println("Получаем " + countCategory0 + " ниток.");

            System.out.println("Введите % соотношение категории << 1 )>>");
            countCategory1 = Integer.parseInt(br.readLine()) * NnOtpr / 100;
            System.out.println("Получаем " + countCategory1 + " ниток.");

            countCategory24 = NnOtpr - countCategory0 - countCategory1;
            if (countCategory24 < 0) {
                System.out.println("Введены неправильные соотношения! Введите заново.");
            }
            else {
            System.out.println("Соотношение категории << от 2 до 4 >> рассчитано. Количество ниток: " + countCategory24);
            break;
            }

        }

        Threads0[] threads0 = new Threads0[countCategory0];
        for (int i = 0; i < countCategory0; i++) {
        threads0[i] = new Threads0();
        }                                                                       // создаём массивы с нитями по соотношениям

        Threads1[] threads1 = new Threads1[countCategory1];
        for (int i = 0; i < countCategory1; i++) {
        threads1[i] = new Threads1(); }

        Threads24[] threads24 = new Threads24[countCategory24];
        for (int i = 0; i < countCategory24; i++) {
        threads24[i] = new Threads24(); }



        System.out.println("Создано ниток категории << 0 >>: " + threads0.length);
        System.out.println("Создано ниток категории << 1 >>: " + threads1.length);
        System.out.println("Создано ниток категории << от 2 до 4 >>: " + threads24.length);
        System.out.println();

        while (true) {
        System.out.println("Введите первый межпоездной интервал в минутах");
        tn1 = Integer.parseInt(br.readLine());
        tn2 = random2(20, 60);                                       // второй межпоездной интервал рандомно в минутах
        System.out.println("Случайный второй интервал: " + tn2);

        while (true) {
            System.out.println("Введите % количество первого интервала");
            tnPercent1 = Integer.parseInt(br.readLine());
            if (tnPercent1 > 100) {
                System.out.println("Неверное соотношение!");
            }
            else {
                tnPercent2 = 100 - tnPercent1;
                System.out.println("% количество второго интервала: " + tnPercent2);

                break;
            }
        }


        tn1Count = tnPercent1 * intervalsCount / 100;
        System.out.println("Количество первых интервалов: " + tn1Count);
        tn2Count = intervalsCount - tn1Count;
        System.out.println("Количество вторых интервалов: " + tn2Count);

        int totalTime = tn1 * tn2Count + tn2 * tn2Count; // общее время всех интервалов

            if (totalTime + tn2 < 1440) {
                System.out.println("Общее время: " + (totalTime + tn2));
                br.close();
                break;
            }
            else {
                System.out.println("Случайный второй интервал превысил норму или неверное % соотношение! Повторите ввод.");
                System.out.println();
            }
        }

        ArrayList<Integer> intervalsTimings = new ArrayList<>();
        for (int i = 0; i < tn1Count; i++) {
            intervalsTimings.add(tn1);
        }
        for (int i = 0; i < tn2Count; i++) {
            intervalsTimings.add(tn2);
        }
        shuffle(intervalsTimings);

        System.out.println("Список интервалов отправления: " + intervalsTimings);


    }



    private static int getRandomNnOtpr(int nN) { //генерирует шанс совпадения колчества прибытий и отправлений
        double rand = Math.random();
        double chance = 0.7;
        if (rand >= chance) nN = random2((nN - 4), (nN + 4));
        return nN;
    }


    public static int random2(int a, int b) { // получает рандомное значение из двух чисел
        b -= a;
        return ((int) (Math.random() * ++b) + a);
    }

    public static int getNnPrib () {
        return NnPrib;
    }
    public static int getNnOtpr () {
        return NnOtpr;
    }


}
