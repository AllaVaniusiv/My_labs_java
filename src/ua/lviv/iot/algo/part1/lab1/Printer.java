package ua.lviv.iot.algo.part1.lab1;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
    public Printer(){}
    public Printer(String model, String type ,boolean isColor , boolean isDuplex,int paperTrayCapacity,int paperCount){
        this.model=model;
        this.type=type;
        this.isColor=isColor;
        this.isDuplex=isDuplex;
        this.paperTrayCapacity=paperTrayCapacity;
        this.paperCount=paperCount;
    }
    private static Printer defaultPrinter = new Printer();

    public static Printer getInstance() {
        return defaultPrinter;
    }
    @Override
    public String toString() {
        return "Printer {" +
                "model=" + model +
                ",type='" + type + '\'' +
                ",isColor='" + isColor + '\'' +
                ",isDuplex='" + isDuplex + '\'' +
                ",paperTrayCapacity='" + paperTrayCapacity + '\'' +
                ",paperCount=" + paperCount +
                '}';
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

    public static void main (String[]args){
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