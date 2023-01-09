package Classes;

import java.io.IOException;
import java.util.Arrays;

/*
Для набора прямоугольников, стороны которых параллельны OX и OY, заданных
координатами 2-х диагональных вершин, найти прямоугольник, который лежит внутри
максимального кол-ва других прямоугольников (граница вложенного прямоугольника
может проходить по границе внешнего прямоугольника). В случае существования
нескольких подходящих прямоугольников – выбрать минимального периметра (если и
таких будет несколько – то произвольный).

 */

public class MainLogicTask {
    public static int[] runMainLogic(int[][] array){
        int[] answer = new int[4];
        answer = array[array.length-1];
        return answer;
    }

    /*public static void main(String[] args) {
        int[][] arr = {{3,2,6,0},{5,0,4,2},{1,4,8,0}};
        System.out.println(massivVStroki(getAnswer(arr)));

    }
     */
    public static int[][] getAnswer(int[][] array){
        // array вида [x1, y1, x2, y2]
        //            [x1', y1', x2', y2']
        int[][] arr = new int[array.length+1][4];
        int max_schet = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++){
            int schet = 0;
            for (int j = 0; j < array.length; j++){
                if ((array[j][0] <= array[i][0]) && (array[j][1] >= array[i][1]) && (array[j][2] >= array[i][2]) && (array[j][3] <= array[i][3])){
                    // проверяем входят ли точки нашего прямоуголинка в точки нашего следующего прямоугольника
                    schet += 1;
                }
            }
            if (schet > max_schet){
                max_schet = schet;
                index = i;
            }
        }
        /* Так тоже можно но так диннее
        for (int i = 0; i < array.length; i++){
            int schet = 0;
            for (int j = 1; j < array.length; j++){
                if ((array[(j+i)%array.length][0] <= array[i][0]) && (array[(j+i)%array.length][1] >= array[i][1]) && (array[(j+i)%array.length][2] >= array[i][2]) && (array[(j+i)%array.length][3] <= array[i][3])){
                    // проверяем входят ли точки нашего прямоуголинка в точки нашего следующего прямоугольника
                    //%array.length для того, чтобы и точки перед нашей диагональю i посмтореть
                    schet += 1;
                }
            }
            if (schet > max_schet){
                max_schet = schet;
                index = i;
            }
        }

         */
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < 4; j++){
                arr[i][j] = array[i][j];
            }
        }
        for(int i = 0; i < 4; i++){
            arr[arr.length-1][i] = array[index][i];
        }
        return arr;
    }
    public static String massivVStroki(int [][] array){
        StringBuilder answer = new StringBuilder();
        for (int [] mas : array){
            for (int znach : mas){
                answer.append(znach);
                answer.append(" ");
            }
            answer.append("\n");

        }
        return answer.toString();
    }
//    .\input.txt .\output.txt
    public static void readAndWriteMethod(InputArgs inputArgs) throws IOException {
        int[][] arr = ClassesForInAndOut.readFile(inputArgs.getInputFile());
        String answer = MainLogicTask.massivVStroki(MainLogicTask.getAnswer(arr));
        ClassesForInAndOut.writeFile(inputArgs.getOutputFile(),answer);
    }
    public static void printSuccessMessage(int num){
        if(num==0){
            System.out.println("Основная программа выполнена.");
        }else{
            System.out.println("Тест " + num + " выполнен успешно.");
        }
        System.out.println();
    }
}
