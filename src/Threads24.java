/**
 * Created by GTT on 13.05.2017.
 */
public class Threads24 extends Thread {

    int NOst = FormingGraphMadeLikeMain.random2(2,4);
    int tOst = gettOst();
    int tOtpr;

    public Threads24() {

    }
    private int gettOst () {
        int a = 20;
        if (NOst == 2) a = FormingGraphMadeLikeMain.random2(20, 50);
        else if (NOst == 3) a = FormingGraphMadeLikeMain.random2(30, 60);
        else if (NOst == 4) a = FormingGraphMadeLikeMain.random2(40, 70);
        return a;
    }
}
