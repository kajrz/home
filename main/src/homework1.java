import java.util.Scanner;
public class homework1 {

    public static void main(String args[]) {
        //wprowadzenie adresu e-mail
        Scanner scanner = new Scanner (System.in);
        System.out.print("Wprowadź adres e-mail");
        //zmienne
        String test = scanner.next();
        int licznik, check, at1, at2, dot, dot1, len;
        licznik = 0;
        check = 0;
        //pozycje zmiennych
        at1 = test.indexOf('@');
        at2 = test.lastIndexOf('@');
        dot = test.lastIndexOf('.');
        dot1 = test.indexOf('.');
        len = test.length();
        //tabela wykluczonych znaków
        String[] chars = new String[] { "!","#","$","%","^","&","*","(",")","[","{","]","}",";",":","\'","\"","<",",",">","?","/","\\","|","+","="," "};
        //czy w adresie występuje @
        if (test.contains("@")){
            check = 0;
        } else {
            check = 1;
        }
        licznik = licznik + check;
        check = 0;
        //czy adres nie rozpoczyna się od @ lub kropki
        if (at1 == 0 || dot1 == 0){
            check = 1;
        } else {
            check = 0;
        }
        licznik = licznik + check;
        check = 0;
        //czy między @ a kropką jest jakiś znak
        if (dot-at1>1){
            check = 0;
        } else {
            check = 1;
        }
        licznik = licznik + check;
        check = 0;
        //czy po kropce występują co najmniej dwa znaki
        if (len-dot>2){
            check = 0;
        } else {
            check = 1;
        }
        licznik = licznik + check;
        check = 0;
        //czy w adresie występuje jedna @
        if (at1 == at2){
            check = 0;
        } else {
            check = 1;
        }
        licznik = licznik + check;
        check = 0;
        //czy po @ występuje '.'
        if (dot > at1){
            check = 0;
        } else {
            check = 1;
        }
        licznik = licznik + check;
        check = 0;
        //czy adres ma co najmniej sześć znaków (@,".", dwa znaki po kropce, znak przed @, znak między @ a ".")
        if (len > 5){
            check = 0;
        } else {
            check = 1;
        }
        licznik = licznik + check;
        check = 0;
        //czy w adresie nie występują wykluczone znaki
        for (int i = 0; i < chars.length; i++) {
            if (test.contains(chars[i])){
                check = 1;
            } else {
                check = 0;
            }
            licznik = licznik + check;
            check = 0;
        }

//komunikat końcowy
        if (licznik == 0){
            System.out.println("Adres e-mail poprawny");
        } else {
            System.out.println("Adres e-mail niepoprawny");}

        //koniec
    }

}
