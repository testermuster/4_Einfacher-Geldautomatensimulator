import java.util.Scanner;

public class geldautomatensimulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bankkonto konto = new Bankkonto(1000); // Start mit einem Kontostand von 1000

        while (true) {
            System.out.println("Willkommen beim einfachen Geldautomaten!");
            System.out.println("1 - Kontostand anzeigen");
            System.out.println("2 - Einzahlen");
            System.out.println("3 - Abheben");
            System.out.println("4 - Beenden");

            System.out.print("Wählen Sie eine Option: ");
            int wahl = scanner.nextInt();

            switch (wahl) {
                case 1:
                    System.out.println("Aktueller Kontostand: " + konto.getKontostand());
                    break;
                case 2:
                    System.out.print("Einzuzahlender Betrag: ");
                    double betrag = scanner.nextDouble();
                    konto.einzahlen(betrag);
                    break;
                case 3:
                    System.out.print("Abzuhebender Betrag: ");
                    betrag = scanner.nextDouble();
                    konto.abheben(betrag);
                    break;
                case 4:
                    System.out.println("Vielen Dank für die Nutzung unseres Geldautomaten.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Ungültige Option!");
            }
        }
    }
}

class Bankkonto {
    private double kontostand;

    public Bankkonto(double anfangsBalance) {
        this.kontostand = anfangsBalance;
    }

    public void einzahlen(double betrag) {
        if (betrag > 0) {
            kontostand += betrag;
            System.out.println(betrag + "€ eingezahlt. Neuer Kontostand: " + kontostand);
        } else {
            System.out.println("Ungültiger Betrag!");
        }
    }

    public void abheben(double betrag) {
        if (betrag > 0 && betrag <= kontostand) {
            kontostand -= betrag;
            System.out.println(betrag + "€ abgehoben. Neuer Kontostand: " + kontostand);
        } else {
            System.out.println("Ungültiger Betrag oder nicht genügend Guthaben!");
        }
    }

    public double getKontostand() {
        return kontostand;
    }
}
