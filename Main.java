import javax.sound.midi.Soundbank;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Notebook nb1 = new Notebook();
        nb1.ram = 8;
        nb1.os = "Windows";
        nb1.hdd = 256;
        nb1.color = "Черный";

        Notebook nb2 = new Notebook();
        nb2.ram = 16;
        nb2.os = "Windows";
        nb2.hdd = 512;
        nb2.color = "Черный";

        Notebook nb3 = new Notebook();
        nb3.ram = 8;
        nb3.os = "Linux";
        nb3.hdd = 256;
        nb3.color = "Серый";

        Notebook nb4 = new Notebook();
        nb4.ram = 32;
        nb4.os = "MacOS";
        nb4.hdd = 512;
        nb4.color = "Черный";

        Notebook nb5 = new Notebook();
        nb5.ram = 4;
        nb5.os = "Windows";
        nb5.hdd = 256;
        nb5.color = "Черный";

        Set<Notebook> set = new HashSet<>();
        set.add(nb1);
        set.add(nb2);
        set.add(nb3);
        set.add(nb4);
        set.add(nb5);

        print(set);
        Map<Integer, String> forfilter = menu();
        print(filter(forfilter, set));


    }

    static void print(Set<Notebook> set){
        for (Notebook item : set){
            System.out.println(item.toString());
        }
    }

    static Map<Integer, String> menu(){
        Map<Integer, String> choice = new HashMap<>();
        Integer pick = 0;
        Scanner scaner = new Scanner(System.in);
        while (pick != 5){
            System.out.println("Введит цифру критерия для поиска: \n" +
                    "1. Объем оперативной памяти\n" +
            "2. Объем памяти жесткого диска\n" +
                    "3. Операционная система\n" +
                    "4. Цвет\n" +
                    "5. Поиск");
            pick = scaner.nextInt();
            switch (pick){
                case 1:
                    System.out.println("Введите необходимый объем: ");
                    Integer orm = scaner.nextInt();
                    choice.put(pick, orm.toString());
                    break;
                case 2:
                    System.out.println("Введите необходимый объем: ");
                    Integer hdd = scaner.nextInt();
                    choice.put(pick, hdd.toString());
                    break;
                case 3:
                    System.out.println("Введите операционную систему: ");
                    String os = scaner.next();
                    choice.put(pick, os);
                    break;
                case 4:
                    System.out.println("Введите цвет: ");
                    String color = scaner.next();
                    choice.put(pick, color);
                    break;
                default:
                    System.out.println(choice);
                    break;
            }
        }
        return choice;
    }
    static Set<Notebook> filter(Map<Integer, String> search, Set<Notebook> allnotebook) {
        Set<Notebook> notebooks = new HashSet<>();
        if (!search.isEmpty()) {
            for (Notebook nb : allnotebook) {
                if (search.containsKey(1) && Integer.parseInt(search.get(1)) <= nb.ram) {
                    notebooks.add(nb);
                }
                if (search.containsKey(2) && Integer.parseInt(search.get(2)) <= nb.hdd) {
                    notebooks.add(nb);
                }
                if (search.containsKey(3) && nb.os.toLowerCase().equals(search.get(3).toLowerCase())) {
                    notebooks.add(nb);
                }
                if (search.containsKey(4) && nb.color.toLowerCase().equals(search.get(4).toLowerCase())) {
                    notebooks.add(nb);
                }
            }
            if (notebooks.isEmpty()) {
                System.out.println("По заданным параметрам ни чего не найдено.");
            }
        }
            else {
                System.out.println("Параметры не заданы.");
            }

        return notebooks;
    }
    }