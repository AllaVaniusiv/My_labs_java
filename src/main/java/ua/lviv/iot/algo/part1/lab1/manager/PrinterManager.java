package ua.lviv.iot.algo.part1.lab1.manager;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.lviv.iot.algo.part1.lab1.modules.Printer;
import ua.lviv.iot.algo.part1.lab1.modules.InkjetPrinter;
import ua.lviv.iot.algo.part1.lab1.modules.LaserPrinter;
import ua.lviv.iot.algo.part1.lab1.modules.PhotoPrinter;
import ua.lviv.iot.algo.part1.lab1.modules.ThreeDPrinter;
import ua.lviv.iot.algo.part1.lab1.writer.PrinterWriter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@ToString(callSuper = true)
public final class PrinterManager {
    public static final double CYAN_INK_LEVEL = 9;

    public static final double MAGENTA_INK_LEVEL = 8;

    public static final double YELLOW_INK_LEVEL = 3;

    public static final double BLACK_INK_LEVEL = 5;

    public static final double CYAN_INK_LEVEL1 = 6;

    public static final double MAGENTA_INK_LEVEL1 = 7;

    public static final double YELLOW_INK_LEVEL1 = 2;

    public static final double BLACK_INK_LEVEL1 = 1;

    public static final int TONER_PAGES_COUNT = 15;

    public static final int PRINTED_PAGES_COUNT = 19;

    public static final int TONER_PAGES_COUNT1 = 13;

    public static final int PRINTED_PAGES_COUNT1 = 4;

    public static final int RESOLUTION = 12;

    public static final double INK_LEVEL = 20;

    public static final int RESOLUTION_1 = 11;

    public static final double INK_LEVEL1 = 17;

    public static final int PRINTING_SPEED = 18;

    public static final int PRINTING_SPEED1 = 14;
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

    public static void main(final String[] args) throws IOException {
        PrinterManager printerManager = new PrinterManager();
        printerManager.addPrinter(new InkjetPrinter("cyan",
                CYAN_INK_LEVEL, "magenta",
                MAGENTA_INK_LEVEL, "yellow", YELLOW_INK_LEVEL,
                "black", BLACK_INK_LEVEL));
        printerManager.addPrinter(new InkjetPrinter("cyan",
                CYAN_INK_LEVEL1, "magenta",
                MAGENTA_INK_LEVEL1, "yellow", YELLOW_INK_LEVEL1,
                "black", BLACK_INK_LEVEL1));
        printerManager.addPrinter(new LaserPrinter(TONER_PAGES_COUNT,
                PRINTED_PAGES_COUNT));
        printerManager.addPrinter(new LaserPrinter(TONER_PAGES_COUNT1,
                PRINTED_PAGES_COUNT1));
        printerManager.addPrinter(new PhotoPrinter("laser", RESOLUTION,
                true, INK_LEVEL));
        printerManager.addPrinter(new PhotoPrinter("laser", RESOLUTION_1,
                false, INK_LEVEL1));
        printerManager.addPrinter(new ThreeDPrinter("scanner",
                PRINTING_SPEED, false));
        printerManager.addPrinter(new ThreeDPrinter("laser",
                PRINTING_SPEED1, true));
        List<Printer> printers = PrinterManager.printers;
        PrinterWriter printerWriter = new PrinterWriter();
        printerWriter.writeToFile(printers);
    }
}

