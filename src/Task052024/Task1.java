package Task052024;
//Формат представления упорядоченного списка целых чисел заключается в использовании списка, разделенного запятыми.
//-отдельные целые числа
//-или диапазон целых чисел, обозначенный начальным целым числом, отделенным от конечного целого числа в диапазоне тире «-». Диапазон включает все целые числа в интервале, включая обе конечные точки. Он не считается диапазоном, если он не охватывает как минимум 3 числа. Например "12,13,15-17"
//-Завершите решение так, чтобы оно принимало список целых чисел в порядке возрастания и возвращало правильно отформатированную строку в формате диапазона.
import java.util.Arrays;
//-6,-3-1,3-5,7-11,14,15,17-20",{-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20})
public class Task1 {

    String calculate(int[] arr) {
        String result = "";
        String endCycle = "";
        for(int i = 0; i < arr.length; i++){
            if(  arr.length - i < 3) {
                result += arr[ i ] + "," + arr[ i + 1 ]+",";
                break;
            }
            result += arr[ i ];
            if((Math.abs(arr[ i ] - arr[i + 1]) == 1) && (Math.abs(arr[i + 1] - arr[i + 2])== 1)) {
                endCycle = String.valueOf(arr[i + 2]);
                for (int j = i + 2; j < arr.length - 1; j++) {
                    if (Math.abs(arr[j] - arr[j + 1]) != 1){
                        i = j;
                        break;
                    }
                    endCycle = String.valueOf(arr[j + 1]);
                    i = j + 1;
                }
                result += "-" + endCycle;
            }
            result += ",";
        }
    return result.substring(0,result.length()-1);
    }
    public static void main(String[] args) {
        Task1 myTask1 = new Task1();
        System.out.print(myTask1.calculate(new int[]{-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20}));
    }
}