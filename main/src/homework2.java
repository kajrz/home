import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FilenameFilter;
import java.io.File;

public class homework2 {

    static final String LOAD = "c:" + File.separator + "java";
    public static void main(String[] args) throws IOException {

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

            Double Open, Close, Change;
        try {
            File FILE = new File(LOAD);
            if (FILE.isDirectory()) {
                File[] FILES = FILE.listFiles(fileNameFilter);
                for (File ITEM : FILES) {
                    String NAME = ITEM.getName();
                    File SAVE = new File(LOAD + File.separator + "New" + File.separator + NAME);
                    FileWriter fw = new FileWriter(SAVE);
                    BufferedWriter bw = new BufferedWriter(fw);
                    File PATH = new  File(LOAD + File.separator + NAME);
                    System.out.println(LOAD);
                    System.out.println(SAVE);
                    System.out.println(PATH);
                    Scanner scanner = new Scanner(PATH);
                        while (scanner.hasNext()) {
                        String line = scanner.nextLine();
                        String[] variables = line.split(",");
                        if (variables[1].equals("Open")){
                            bw.write(line + ",Change");
                            } else {
                            Open = Double.parseDouble(variables[1]);
                            Close =Double.parseDouble(variables[4]);
                            Change = (Close - Open)/Open;
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
