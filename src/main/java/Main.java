import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int i = Randomizer(2000); // первый пункт
        System.out.println("Выпало число i - " + i);
        System.out.println();

        int n = GetSeniorBitNumber(i); // второй пункт
        System.out.println("Номер старшего значащего бита n - " + n);
        System.out.println("///Для проверки --- " + (Integer.toBinaryString(i)) + " ///");
        System.out.println();

        System.out.printf("Все числа от %d до 32767 кратные %d", i, n);
        int[] m1 = GetM1(i, n); // третий пункт
        PrintArray(m1);
        System.out.println();

        System.out.printf("\nВсе числа от -32768 до %d не кратные %d", i, n);
        int[] m2 = GetM2(i, n); // четвертый пункт
        PrintArray(m2);
    }

    public static int Randomizer(int bound){
        return new Random().nextInt(bound);
    }

    public static int GetSeniorBitNumber(int num){
        return Integer.toBinaryString(num).length();
    }

    public static int[] GetM1(int border, int divisor){
        int[] arr = new int[0];
        int[] tmp;
        for (int i = border; i < Short.MAX_VALUE; i++) {
            if (i % divisor == 0){
                tmp = new int[arr.length + 1];
                for (int j = 0; j < arr.length; j++) tmp[j] = arr[j];
                arr = tmp;
                arr[arr.length - 1] = i;
            }
        }
        return arr;
    }

    public static void PrintArray(int[] arr){
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] GetM2(int border, int divisor){
        int[] arr = new int[0];
        int[] tmp;
        for (int i = Short.MIN_VALUE; i < border; i++) {
            if (i % divisor != 0){
                tmp = new int[arr.length + 1];
                for (int j = 0; j < arr.length; j++) tmp[j] = arr[j];
                arr = tmp;
                arr[arr.length - 1] = i;
            }
        }
        return arr;
    }
}
