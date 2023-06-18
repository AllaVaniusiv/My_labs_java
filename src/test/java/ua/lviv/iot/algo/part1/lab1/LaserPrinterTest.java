package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class LaserPrinterTest {
    private LaserPrinter laserPrinter;

    @BeforeEach
    public void setUp() {
        laserPrinter = new LaserPrinter(100, 0);
    }

    @Test
    public void testGetRemainingPagesCount() {
        assertEquals(100, laserPrinter.getRemainingPagesCount());
        laserPrinter.print(50);
        assertEquals(100, laserPrinter.getRemainingPagesCount());
    }

    @Test
    public void testPrint_withEnoughToner() {
        LaserPrinter printer = new LaserPrinter(10, 0);
        printer.print(5);
        assertEquals(10, printer.getTonerPagesCount());
        assertEquals(0, printer.getPrintedPagesCount());
    }

    @Test
    public void testPrint_withNotEnoughToner() {
        LaserPrinter printer = new LaserPrinter(3, 0);
        printer.print(5);
        assertEquals(3, printer.getTonerPagesCount());
        assertEquals(0, printer.getPrintedPagesCount());
    }
    @Test
    public void testGetInstance() {
        LaserPrinter laserPrinter1 = new LaserPrinter(100, 0);
        LaserPrinter laserPrinter2 = new LaserPrinter(200, 0);
        Printer.defaultPrinter = laserPrinter1;
        assertEquals(laserPrinter1, Printer.getInstance());
        Printer.defaultPrinter = laserPrinter2;
        assertEquals(laserPrinter2, Printer.getInstance());
    }
    @Test
    public void testLoadPaper_withNotEnoughSpace() {
        laserPrinter.loadPaper(150);
        assertEquals(0, laserPrinter.getPaperCount());
    }
    @Test
    public void testLoadPaper_withEnoughSpace() {
        laserPrinter.loadPaper(50);
        assertEquals(0, laserPrinter.getPaperCount());
    }

    @Test
    public void testPrint_withZeroPagesCount() {
        LaserPrinter printer = new LaserPrinter(10, 0);
        printer.print(0);
        assertEquals(0, printer.getPrintedPagesCount());
        assertEquals(10, printer.getTonerPagesCount());
    }

    @Test
    public void testPrintNotEnoughPaper() {
        int originalPaperCount = laserPrinter.getPaperCount();
        int pagesToPrint = 20;
        laserPrinter.print(pagesToPrint);
        assertEquals(originalPaperCount, laserPrinter.getPaperCount());
    }
    @Test
    public void testPrint_withExactToner() {
        LaserPrinter printer = new LaserPrinter(5, 0);
        printer.print(5);
        assertEquals(5, printer.getTonerPagesCount());
        assertEquals(0, printer.getPrintedPagesCount());
    }

}
