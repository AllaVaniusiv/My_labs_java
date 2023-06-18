package ua.lviv.iot.algo.part1.lab1;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@ToString(callSuper = true)
public final class PrinterManager {
    private static List<Printer> printers = new ArrayList<>();

    public void addPrinter(final Printer printer) {
        this.printers.add(printer);
    }

    public List<Printer> findPrinterWithType(final String type) {
        return printers.stream().
                filter(printer -> printer.getType() == type).
                collect(Collectors.toList());
    }

    public List<Printer> findPrinterWithMoreInkLevelThan(final double inkLevel) {
        return printers.stream().
                filter(printer -> printer.getInkLevel() > inkLevel).
                collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        PrinterManager printerManager = new PrinterManager();
        printerManager.addPrinter(new InkjetPrinter("cyan", 9, "magenta",
                8, "yellow", 3, "black", 5));
        printerManager.addPrinter(new InkjetPrinter("cyan", 6, "magenta",
                7, "yellow", 2, "black", 1));
        printerManager.addPrinter(new LaserPrinter(15, 6));
        printerManager.addPrinter(new LaserPrinter(13, 3));
        printerManager.addPrinter(new PhotoPrinter("laser", 6, true, 3));
        printerManager.addPrinter(new PhotoPrinter("laser", 3, false, 5));
        printerManager.addPrinter(new ThreeDPrinter("scanner", 8, false));
        printerManager.addPrinter(new ThreeDPrinter("laser", 5, true));

        List<Printer> printers = PrinterManager.printers;
        PrinterWriter printerWriter = new PrinterWriter();
        printerWriter.writeToFile(printers);
    }
}

