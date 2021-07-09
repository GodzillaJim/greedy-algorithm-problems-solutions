import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FractionalKnapsack {

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
         class data{
             int value, weight; float valPerWeight;
             data(int val,int weig,float
                     valPerW){
                 value = val; weight = weig; valPerWeight = valPerW;
             }
        }
        data[] valPerWeight = new data[weights.length];
        for(int i=0;i<weights.length;i++){
                float temp = values[i]/weights[i];
                valPerWeight[i] = new data(values[i],weights[i],temp);
        }
        if(values.length > 1){
            for(int a =0; a<valPerWeight.length;a++){
                for(int b=a+1;b<valPerWeight.length;b++){
                    if(valPerWeight[a].valPerWeight < valPerWeight[b].valPerWeight){
                        data temp = valPerWeight[a];
                        valPerWeight[a] = valPerWeight[b];
                        valPerWeight[b] = temp;
                    }
                }
            }
        }

        float temp = capacity; float value=0;
        while(temp > 0){
            for(int a=0;a<valPerWeight.length;a++){
                if(valPerWeight[a].weight <= temp){
                    value += valPerWeight[a].value;
                    temp -= valPerWeight[a].weight;
                }else{
                    value += (temp * valPerWeight[a].value)/valPerWeight[a].weight;//*valPerWeight[a].value;
                    temp -= temp;
                }
                if(temp == 0){
                    return value;
                }
            }
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.print(String.format("%.4f",getOptimalValue(capacity,values,weights)));//60 20 100 50 120 30
    }
}