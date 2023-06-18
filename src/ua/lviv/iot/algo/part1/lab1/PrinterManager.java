package ua.lviv.iot.algo.part1.lab1;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@ToString(callSuper = true)
public class PrinterManager {
    private final List<Printer> printers = new ArrayList<>();

    public void addPrinter(Printer printer) {
        this.printers.add(printer);
    }

    public List<Printer> findPrinterWithType(String type) {
        return printers.stream().
                filter(printer -> printer.getType() == type).
                collect(Collectors.toList());
    }

    public List<Printer> findPrinterWithMoreInkLevelThan(double inkLevel) {
        return printers.stream().
                filter(printer -> printer.getInkLevel() > inkLevel).
                collect(Collectors.toList());
    }

    public static void main(String[] args) {
        PrinterManager printerManager = new PrinterManager();
        printerManager.addPrinter(new InkjetPrinter("cyan", 9, "magenta",
                8, "yellow", 3, "black", 5));
        printerManager.addPrinter(new InkjetPrinter("cyan", 6, "magenta",
                3, "yellow", 2, "black", 5));
        printerManager.addPrinter(new LaserPrinter(15, 6));
        printerManager.addPrinter(new LaserPrinter(13, 3));
        printerManager.addPrinter(new PhotoPrinter("laser", 6, true, 3));
        printerManager.addPrinter(new PhotoPrinter("laser", 5, false, 5));
        printerManager.addPrinter(new ThreeDPrinter("scanner", 8, false));
        printerManager.addPrinter(new ThreeDPrinter("laser", 5, true));

        for (Printer printer : printerManager.getPrinters()) {
            System.out.println(printer);
            System.out.println("RemainingPages:" + printer.getRemainingPagesCount());
        }

        System.out.println("\n");

        var printerWithType = printerManager.findPrinterWithType("laser");
        System.out.println("Printers with type 'laser':");
        for (Printer printer : printerWithType) {
            System.out.println(printer);
        }

        System.out.println("\n");

        var printerWithMoreInkLevelThan = printerManager.findPrinterWithMoreInkLevelThan(3);
        System.out.println("Printers with paper tray capacity greater than 3:");
        for (Printer printer : printerWithMoreInkLevelThan) {
            System.out.println(printer);
        }
    }
}