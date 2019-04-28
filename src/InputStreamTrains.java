
import java.io.IOException;


/**
 * Created by GTT on 13.05.2017.
 */
public class InputStreamTrains {

    static int Nprib;
    static Train[] inputTrains;
    static int trainSp;
    static int trainCategory;

    public static void IncomingTrains() throws IOException {

        System.out.println("Введите количество прибывающих поездов: ");
        Nprib = Integer.parseInt(MainLogic.reader.readLine());

        Train.TrainConfig();
        System.out.println("Создание прибывающих поездов.");
        inputTrains = new Train[Nprib];
        while (true) {
            System.out.println("Введите скорость поездов:");
            trainSp = Integer.parseInt(MainLogic.reader.readLine());
            if (trainSp >= 0) break;
            else System.out.println("Скорость не может быть отрицательной!");
        }



        for (int i = 0; i < inputTrains.length; i++) {                                   //создаем массив поездов по входящим параметрам категория и скорость

            inputTrains[i] = new Train(trainCategory, trainSp);
        }

    }

    public static Train[] getInputTrains() {
        return inputTrains;
    }

    public static int getNprib() {
        return Nprib;
    }
}
