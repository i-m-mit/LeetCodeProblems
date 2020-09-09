package Common;

public class WaterBottles {
    public int numWaterBottles(int nb, int ne) {
        int empty = 0;
        int count = 0;
        while (nb > 0) {
            count += nb;
            empty += nb;
            nb = empty / ne;
            empty -= nb * ne;
        }

        return count;
    }

    public static void main(String[] args) {
        WaterBottles o = new WaterBottles();
        System.out.println(o.numWaterBottles(2, 3));
    }
}
