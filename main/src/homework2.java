import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FilenameFilter;
import java.io.File;

public class homework2 {
//katalog w którym będą wyszukiwane pliki
    static final String LOAD = "c:" + File.separator + "java";
    public static void main(String[] args) throws IOException {
//warunek na wyszukiwanie tylko plików csv
        FilenameFilter fileNameFilter = new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                if(name.toLowerCase().endsWith(".csv")) {

                    return true;
                }
                else {

                    return false;
                }
            }};
//zmienne do wyliczenia zmiany kursu
//Open przechowuje kurs otwarcia
//Close przechowuje kurs zamknięcia
//Change prechowuje wynik formuły wyliczającej zmianę kursu
            Double Open, Close, Change;
        try {
            File FILE = new File(LOAD);
            //jeśli ścieżka istnieje
            if (FILE.isDirectory()) {
                //wylistowanie plików z katalogu
                File[] FILES = FILE.listFiles(fileNameFilter);
                for (File ITEM : FILES) {
                    //pobranie nazwy pliku
                    String NAME = ITEM.getName();
                    //stworzenie ścieżki do zapisu nowego pliku w podkatalogu new
                    File SAVE = new File(LOAD + File.separator + "New" + File.separator + NAME);
                    FileWriter fw = new FileWriter(SAVE);
                    BufferedWriter bw = new BufferedWriter(fw);
                    //pełna ścieżka do pliku
                    File PATH = new  File(LOAD + File.separator + NAME);
                    Scanner scanner = new Scanner(PATH);
                        while (scanner.hasNext()) {
                        String line = scanner.nextLine();
                        //rozbicie linii na poszczególne elementy
                        String[] variables = line.split(",");
                        //sprawdzenie czy linia nie zawiera tytułów zmiennych
                        if (variables[1].equals("Open")){
                            bw.write(line + ",Change");
                            } else {
                            //wyliczenie zmiany kursu
                            Open = Double.parseDouble(variables[1]);
                            Close =Double.parseDouble(variables[4]);
                            Change = (Close - Open)/Open;
                            //dopisanie zmiany kursu do linii
                            bw.write(line + "," + Change);
                            }
                        bw.newLine();
                }
            scanner.close();
            bw.close();
            fw.close();
        }
            }
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
