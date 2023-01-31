import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        int st = 1;
        int i = 0;
        int countQ1 = 0;
        int countQ2 = 0;
        int countQ3 = 0;
        int countI = 0;
        int countNotL = 0;
        int countTable = 0;
        int countEdit = 0;
        ArrayList<Object> firstState = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        boolean flag = false;
        s = reader.readLine();
        char[] chars = s.toCharArray();
        while (!flag) {
            if (countQ1 + countQ2 + countQ3 == 10 || countQ1 + countQ2 + countQ3 == 20 || countQ1 + countQ2 + countQ3 == 30) {
                firstState.add(chars[0]);
            }
            switch (st) {
                case (1) -> {
                    countQ1++;
                    switch (chars[i]) {
                        case ('L') -> {
                            chars[i] = 'a';
                            st = 2;
                            i--;
                            countEdit++;
                        }
                        case ('a'), ('b') -> {
                            countI++;
                            if(chars[i+2] == 'b' && chars[i+1] == 'y'){
                                countEdit++;
                            }
                            i++;
                        }
                        case ('y') -> {
                            countI++;
                            if(chars[i+2] == 'b' && chars[i+1] == 'y'){
                                countEdit++;
                            }
                            chars[i] = 'б';
                            i++;
                        }
                        case ('б') -> {
                            countI++;
                            if(chars[i+2] == 'b' && chars[i+1] == 'y'){
                                countEdit++;
                            }
                            chars[i] = 'y';
                            i++;
                        }
                    }
                }
                case (2) -> {
                    countQ2++;
                    switch (chars[i]) {
                        case ('L') -> {
                            chars[i] = 'б';
                            flag = true;
                            System.out.println("Завершено!");
                        }
                        case ('a') -> {
                            countTable++;
                            i--;
                        }
                        case ('b') -> {
                            i--;
                        }
                        case ('y') -> {
                            chars[i] = 'a';
                            st = 3;
                        }
                        case ('б') -> {
                            chars[i] = 'b';
                            st = 3;
                            i--;
                        }
                    }
                }
                case (3) -> {
                    countQ3++;
                    switch (chars[i]) {
                        case ('L') -> {
                            chars[i] = 'a';
                            st = 2;
                            i--;
                        }
                        case ('a') -> {
                            chars[i] = 'b';
                            i--;
                        }
                        case ('b') -> {
                            chars[i] = 'y';
                            st = 1;
                        }
                        case ('y') -> {
                            countI++;
                            chars[i] = 'б';
                            if(chars[i+2] == 'b' && chars[i+1] == 'б'){
                                countEdit++;
                            }
                            st = 1;
                            i++;
                        }
                        case ('б') -> {
                            countI++;
                            chars[i] = 'L';
                            countEdit++;
                            i++;
                            flag = true;
                            System.out.println("Завершено!");
                        }
                    }
                }
            }
        }

        for (char aChar : chars) {
            if (aChar != 'L') {
                countNotL++;
            }
        }
        System.out.println(chars);
        System.out.println("a)" + countQ1);
        System.out.println("б)" + countQ1 + " " + countQ2 + " " + countQ3);
        System.out.println("в)" + countI);
        System.out.println("г)" + countNotL);

        if (countQ1 != 0 && countQ2 != 0 && countQ3 != 0) {
            System.out.println("д) Да!");
        } else {
            System.out.println("д) Нет!");
        }

        System.out.println("е)" + firstState);
        System.out.println("ж)" + countTable);
        System.out.println("з)" + countEdit);
    }
}
