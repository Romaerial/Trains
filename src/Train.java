import java.io.IOException;

/**
 * Created by GTT on 13.05.2017.
 */
public class Train {
    static int tPrib;
    static int Qlok = 150;
    static int Qbrytto;
    static int Q1;
    static int Q2;
    static int Q3;
    static int weight;
    static double aRashod = 3.6;
    static int Vx;
    static int trainSpeed;

    public  Train (int bryttoCategory, int speed) {                      // в зависимости от полученной категории придаем ему массу, так же задаем скорость
        if (bryttoCategory == 1) weight = FormingGraph1.random2(1000, 2000);
        else if (bryttoCategory ==2) weight = FormingGraph1.random2(2000, 4000);
        else if (bryttoCategory == 3) weight = FormingGraph1.random2(4000, 7000);
        trainSpeed = speed;

    }

    public static void TrainConfig() throws IOException {

        System.out.println("Составление поездов.");
        while (true) {
            System.out.println("Введите % количество 1го диапазона брутто: ");
            Q1 = Integer.parseInt(MainLogic.reader.readLine()) * InputStreamTrains.getNprib() / 100;
            System.out.println("Количество поездов 1го диапазона брутто: " + Q1);
            System.out.println("Введите % количество 2го диапазона брутто: ");
            Q2 = Integer.parseInt(MainLogic.reader.readLine()) * InputStreamTrains.getNprib() / 100;
            System.out.println("Количество поездов 2го диапазона брутто: " + Q2);
            Q3 = InputStreamTrains.getNprib() - Q2 - Q1;
            if (Q3 < 0) {
                System.out.println("Введено неправильное соотношение. Введите заново!");
                System.out.println();
            } else {
                System.out.println("Количество поездов 3го диапазона брутто рассчитано и равно: " + Q3);
                break;
            }
        }

    }



}
