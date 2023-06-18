package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {

    private Printer printer;

    @BeforeEach
    void setUp() {
        printer = new LaserPrinter(250, 50);
        Printer.defaultPrinter = printer;
    }

    @Test
    void print_shouldPrintPages_whenEnoughPaperInTray() {
        printer.loadPaper(50);
        printer.print(20);
        assertEquals(200, printer.getRemainingPagesCount());
    }

    @Test
    void print_shouldNotPrintPages_whenNotEnoughPaperInTray() {
        printer.print(10);
        assertEquals(200, printer.getRemainingPagesCount());
    }

    @Test
    void loadPaper_shouldIncreasePaperCount() {
        printer.loadPaper(50);
        assertEquals(200, printer.getRemainingPagesCount());
    }

    @Test
    void loadPaper_shouldNotExceedPaperTrayCapacity() {
        printer.loadPaper(300);
        assertEquals(200, printer.getRemainingPagesCount());
    }

    @Test
    void getInstance_shouldReturnDefaultPrinter() {
        Printer actualPrinter = Printer.getInstance();
        assertEquals(printer, actualPrinter);
    }
    @Test
    public void testPrintNotEnoughPaper() {
        printer.print(60);
        assertEquals(200, printer.getRemainingPagesCount());
    }
    @Test
    public void testLoadPaperOverCapacity() {
        printer.loadPaper(70);
        assertEquals(200, printer.getRemainingPagesCount());
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
    public void testGetRemainingPagesCount() {
        assertEquals(200, printer.getRemainingPagesCount());
        printer.print(50);
        assertEquals(200, printer.getRemainingPagesCount());
    }
    @Test
    void loadPaper_shouldNotExceedPaperTrayCapacity_whenLoadedMoreThanCapacity() {
        printer.loadPaper(300);
        assertEquals(200, printer.getRemainingPagesCount());
    }

    @Test
    void getRemainingPagesCount_shouldReturnCorrectValue_whenNoPaperLoaded() {
        assertEquals(200, printer.getRemainingPagesCount());
    }

    @Test
    void getRemainingPagesCount_shouldReturnCorrectValue_whenSomePagesPrinted() {
        printer.loadPaper(100);
        printer.print(50);
        assertEquals(200, printer.getRemainingPagesCount());
    }

    @Test
    void getRemainingPagesCount_shouldReturnCorrectValue_whenTrayIsFull() {
        printer.loadPaper(200);
        assertEquals(200, printer.getRemainingPagesCount());
    }
    @Test
    void settersAndGetters_shouldWorkCorrectly() {
        printer.setModel("HP LaserJet");
        printer.setType("Laser");
        printer.setColor(true);
        printer.setDuplex(true);
        printer.setPaperTrayCapacity(500);
        printer.setPaperCount(300);
        printer.setInkLevel(0.5);
        assertEquals("HP LaserJet", printer.getModel());
        assertEquals("Laser", printer.getType());
        assertTrue(printer.isColor());
        assertTrue(printer.isDuplex());
        assertEquals(500, printer.getPaperTrayCapacity());
        assertEquals(300, printer.getPaperCount());
        assertEquals(0.5, printer.getInkLevel());
    }
    @Test
    void print_shouldNotPrint_whenPagesIsZero() {
        printer.loadPaper(50);
        printer.print(0);
        assertEquals(200, printer.getRemainingPagesCount());
    }

    @Test
    void print_shouldNotPrint_whenPagesIsNegative() {
        printer.loadPaper(50);
        printer.print(-5);
        assertEquals(200, printer.getRemainingPagesCount());
    }

}