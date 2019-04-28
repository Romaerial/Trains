import java.io.IOException;

/**
 * Created by GTT on 13.05.2017.
 */
public class TrainDeparture {
    static int tPrib;
    static int tObr;
    static int tObr1 = 30;
    static int tObr1Count;
    static int tObr2 = 60;
    static int tObr2Count;
    static int tObrPercent;
    static int tGot = tPrib + tObr;

    public static void gettObrCount() throws IOException {
        while (true) {
            System.out.println("Введите % соотношение первого времени обработки");
            tObr1Count = Integer.parseInt(MainLogic.reader.readLine()) * FormingGraph1.NnOtpr / 100;
            System.out.println("Получаем " + tObr1Count + " единиц первого времени обработки.");

            tObr2Count = FormingGraph1.NnOtpr - tObr1Count;
            if (tObr2Count < 0) {
                System.out.println("Введены неправильные соотношения! Введите заново.");
            } else {
                System.out.println("Соотношение рассчитано. Количество: " + tObr2Count);
                break;
            }
        }
    }



}
