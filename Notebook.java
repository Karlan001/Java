import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class Notebook {
    int ram;
    int hdd;
    String os;
    String color;

    @Override
    public String toString() {
        return "Объем оперативной памяти = " + ram + "; Обеъм памяти жесткого диска = "
                + hdd + "; Операционная система = " + os + "; Цвет = " + color;
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Notebook)) {
            return false;
        }
        Notebook nb = (Notebook) obj;
        return ram == nb.ram && hdd == nb.hdd && os.equals(nb.color.toLowerCase()) && color.equals(nb.color);
    }

    @Override
    public int hashCode() {
        return ram + hdd + os.hashCode() * 5 + color.hashCode() * 7;
    }

}
