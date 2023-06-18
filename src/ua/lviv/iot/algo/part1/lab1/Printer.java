package ua.lviv.iot.algo.part1.lab1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Printer {
    private String model;
    private String type;
    private boolean isColor;
    private boolean isDuplex;
    private int paperTrayCapacity;
    private int paperCount;
    private static Printer defaultPrinter = new Printer();

    public static Printer getInstance() {
        return defaultPrinter;
    }


    public void print(int pages) {
        if (pages <= paperCount) {
            paperCount -= pages;
            System.out.println("Printing " + pages + " pages...");
        } else {
            System.out.println("Not enough paper in the tray!");
        }
    }

    public void loadPaper(int count) {
        paperCount += count;
        if (paperCount > paperTrayCapacity) {
            paperCount = paperTrayCapacity;
        }
    }

    public static void main(String[] args) {
        Printer printer1 = new Printer();
        Printer printer2 = new Printer("HP LaserJet", "laser", true, true, 250, 50);
        Printer printer3 = Printer.getInstance();
        Printer printer4 = Printer.getInstance();

        Printer[] printers = {printer1, printer2, printer3, printer4};

        for (Printer printer : printers) {
            System.out.println(printer);
        }
    }
}
