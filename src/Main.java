import java.util.*;
import java.util.ArrayList;

public class Main {
    /*#######*/ /*#######*/ /*#######*/ /*#######*/ /*#######*/
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String j=scan.nextLine();
        int schet=0;
        ArrayList<String> list1=new ArrayList<>();
        list1.add("I");
        list1.add("II");
        list1.add("III");
        list1.add("IV");
        list1.add("V");
        list1.add("VI");
        list1.add("VII");
        list1.add("VIII");
        list1.add("IX");
        list1.add("X");
        ArrayList<String> list2=new ArrayList<>();
        String[] sim=j.split(" ");
        for(String k:sim) list2.add(k);
        list2.remove(1);
        for(String z:list1){
            for(String l:list2){
                if(z.equals(l)) schet=1;
            }
        }
        if(schet==1){
            System.out.println(rom(j));
        } else System.out.println(arabic(j));

    }
    /*#######*/ /*#######*/ /*#######*/ /*#######*/ /*#######*/
    public static String rom(String input) throws Exception {           /*#######*/ /*#######*/
        int schet = -1;
        int summa=0;
        HashMap<String, Integer> roman = new HashMap<>();
        roman.put("I", 1);
        roman.put("II", 2);
        roman.put("III", 3);
        roman.put("IV", 4);
        roman.put("V", 5);
        roman.put("VI", 6);
        roman.put("VII", 7);
        roman.put("VIII", 8);
        roman.put("IX", 9);
        roman.put("X", 10);
        ArrayList<String> osn = new ArrayList<>();
        String[] words = input.split(" ");
        for (String h : words) {
            osn.add(h);
        }
        switch (osn.get(1)) {
            case "+":
                schet = 1;
                break;
            case "-":
                schet = 2;
                break;
            case "*":
                schet = 3;
                break;
            case "/":
                schet = 4;
                break;
        }
        int a,b=0;
        try{
            a=roman.get(osn.get(0));
            b=roman.get(osn.get(2));
        }catch (Exception e){
            throw new IllegalArgumentException("Числон не входит в диапазон.");
        }
        try{
            if(osn.get(3)!=null){
                schet=-1;
            }
        }catch(Exception e){
            if (romanchisl(osn.get(0)) && romanchisl(osn.get(2))) {
                if(schet==1) summa=a+b;
                if(schet==2) summa=a-b;
                if(schet==3) summa=a*b;
                if(schet==4) summa=a/b;
            }
            if(summa<=0) throw new IllegalArgumentException("Ошибка");
        }
        /*#############*/
        if(schet==-1){
            throw new IllegalArgumentException("Неверная арифметическая операция.");
        }else return convertToRoman(summa);
        /*#############*/
    }

    public static boolean romanchisl(String znach) {
        int a = 0;
        HashMap<String, Integer> rom = new HashMap<>();
        rom.put("I", 1);
        rom.put("II", 2);
        rom.put("III", 3);
        rom.put("IV", 4);
        rom.put("V", 5);
        rom.put("VI", 6);
        rom.put("VII", 7);
        rom.put("VIII", 8);
        rom.put("IX", 9);
        rom.put("X", 10);

        /*#############*/

        try{
            a = rom.get(znach);
        }catch(Exception e){
            throw new IllegalArgumentException("Число не входит в диапазон");
        }


        if(a>=1 && a<=10){
            return true;
        }else return false;


    }
    public static String convertToRoman(int number) {
        int[] arabicValues = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romanSymbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder romanNumber = new StringBuilder();

        for (int i = 0; i < arabicValues.length; i++) {
            while (number >= arabicValues[i]) {
                romanNumber.append(romanSymbols[i]);
                number -= arabicValues[i];
            }
        }

        return romanNumber.toString();
    }

    /*#######*/ /*#######*/ /*#######*/ /*#######*/ /*#######*/

    public static String arabic(String input) throws Exception {          /*#######*/ /*#######*/
        int schet = -1;
        int Romansum = 0;
        int Arabicsum = 0;
        String h = "";
        ArrayList<String> osn = new ArrayList<>();
        String[] words = input.split(" ");
        for (String word : words) {
            osn.add(word);
        }
        switch (osn.get(1)) {
            case "+":
                schet = 1;
                break;
            case "-":
                schet = 2;
                break;
            case "*":
                schet = 3;
                break;
            case "/":
                schet = 4;
                break;
        }
        int a = Integer.parseInt(osn.get(0));
        int b = Integer.parseInt(osn.get(2));
        try {
            if (osn.get(3)!=null) {
                schet=-1;
            }
        } catch (Exception e) {
            if (TrorFl(a) && TrorFl(b)) {
                if (schet == 1) Romansum = a + b;
                if (schet == 2) Romansum = a - b;
                if (schet == 3) Romansum = a * b;
                if (schet == 4) Romansum = a / b;
            }

        }
        if (!(TrorFl(a)) || !(TrorFl(b))) {
            throw new IllegalArgumentException("Числа вне диапазона!");
        }

        if (schet == -1) {
            throw new IllegalArgumentException("Неверная арифметичская операция!");
        } else return String.valueOf((Romansum));
    }

    public static boolean TrorFl(int chislo){
        if(chislo >=1 && chislo <=10){
            return true;
        }else return false;
    }

}

/*#######*/ /*#######*/ /*#######*/ /*#######*/ /*#######*/