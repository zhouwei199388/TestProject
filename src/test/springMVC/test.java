package test.springMVC;

/**
 * Created by 15090 on 2018/5/26.
 */
public class test {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,-30,-20, 1, 12, 33, 22, 15, 3, 39, 5, 10, 66, 30, 16, 24, 88, 7};
        int temp;//临时值  用于比较
        int temp1;//临时替换值  用于内部判断内部
        int first;

        first = arr[0]>0?arr[0]:-arr[0];
        first = arr[1]>0?arr[1]+first:-arr[1]+first;

        int x = first;//最小值
        int c = first;//次小值
        int v = first;//次次小值


        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            if (x == temp) continue;
            if (x > temp) {
                temp1 = x;
                x = temp;
                temp = temp1;
            }
            if (c == temp) continue;
                if (c > temp) {
                temp1 = c;
                c = temp;
                temp = temp1;
            }
            if (v == temp) continue;
            if (v > temp) {
                v = temp;
            }
        }

        System.out.println(x);
        System.out.println(c);
        System.out.println(v);
    }


}
