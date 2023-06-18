package ua.lviv.iot.algo.part1.lab1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PrinterWriter {

    public void writeToFile(List<Printer> printers) throws IOException {
        if (printers.isEmpty()) {
            System.out.println("Список принтерів порожній, немає чого записувати в файл!");
            return;
        }
        File csvOutputFile = new File("printers.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            printers.stream()
                    .map(Printer::toCSV)
                    .forEach(pw::println);
        }
        System.out.println("Дані успішно записані у файл");
    }


    public void sortedWriteToFile(List<Printer> printers) throws IOException {
        File csvOutputFile = new File("sorted_printer.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            Printer printerType = printers.get(0);
            pw.println(printers.get(0).getHeaders());
            for (var printer : printers) {
                if (printerType.getClass() != printer.getClass()) {
                    printerType = printer;
                    pw.println(printer.getHeaders());
                }
                pw.println(printer.toCSV());
            }
        }
    }
}