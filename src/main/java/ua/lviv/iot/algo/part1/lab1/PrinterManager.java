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
public final class PrinterManager {
    private final List<Printer> printers = new ArrayList<>();

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
}
