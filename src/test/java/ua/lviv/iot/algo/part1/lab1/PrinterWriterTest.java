package ua.lviv.iot.algo.part1.lab1;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;


public class PrinterWriterTest {
    private final File actualFile = new File("printers.csv");
    ;
    private final File expectedFile = new File("expected.csv");
    private static List<Printer> printers;


    @Test
    public void writeToFileSuccess() throws IOException {
        List<Printer> printers = new ArrayList<>();
        printers.add(new InkjetPrinter("cyan", 9,
                "magenta",
                8, "yellow", 3,
                "black", 5));
        printers.add(new InkjetPrinter("cyan", 6,
                "magenta",
                7, "yellow", 2,
                "black", 1));
        printers.add(new LaserPrinter(15, 6));
        printers.add(new LaserPrinter(13, 3));
        printers.add(new PhotoPrinter("laser", 6, true,
                3));
        printers.add(new PhotoPrinter("laser", 3, false,
                5));
        printers.add(new ThreeDPrinter("scanner", 8,
                false));
        printers.add(new ThreeDPrinter("laser", 5,
                true));

        assertTrue(Files.exists(actualFile.toPath()));
        assertEquals(Files.readAllLines(expectedFile.toPath()),
                Files.readAllLines(actualFile.toPath()));
    }

    @Test
    public void testWriteToFileEmptyList() throws IOException {
        PrinterWriter printerWriter = new PrinterWriter();
        List<Printer> printers = new ArrayList<>();

        printerWriter.writeToFile(printers);

        File file = new File("printers.csv");
        assertTrue(file.exists());
    }

    @Test
    public void writeToFileExistingFile() throws IOException {
        FileWriter fileWriter = new FileWriter("printers.csv");
        fileWriter.write("printers");
        fileWriter.close();

    }

    @Test
    public void testSortedWritesToFile() throws IOException {
        // Arrange
        PrinterWriter printerWriter = new PrinterWriter();
        List<Printer> printers = new ArrayList<>();
        printers.add(new InkjetPrinter("cyan", 9, "magenta",
                8, "yellow", 3, "black", 5));
        printers.add(new LaserPrinter(15, 6));
        printers.add(new InkjetPrinter("cyan", 6, "magenta",
                7, "yellow", 2, "black", 1));
        printers.add(new LaserPrinter(13, 3));
        printers.add(new PhotoPrinter("laser", 6, true, 3));
        printers.add(new PhotoPrinter("laser", 3, false, 5));
        printers.add(new ThreeDPrinter("scanner", 8, false));
        printers.add(new ThreeDPrinter("laser", 5, true));
        File csvFile = new File("sorted_printer.csv");


        printerWriter.sortedWriteToFile(printers);


        Assertions.assertTrue(csvFile.exists());
        Assertions.assertTrue(csvFile.isFile());
        Assertions.assertEquals(14, countLines(csvFile));
    }

    private int countLines(File file) throws IOException {
        try (var reader = new java.io.BufferedReader(new java.io.FileReader(file))) {
            int lines = 0;
            while (reader.readLine() != null) lines++;
            return lines;
        }
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of("printers.csv"));
    }
}