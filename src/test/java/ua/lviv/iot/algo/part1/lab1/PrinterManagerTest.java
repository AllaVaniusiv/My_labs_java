package ua.lviv.iot.algo.part1.lab1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrinterManagerTest {
    private PrinterManager printerManager;

    @BeforeEach
    void setUp() {
        printerManager = new PrinterManager();
        printerManager.addPrinter(new InkjetPrinter("cyan", 9, "magenta", 8, "yellow", 3, "black", 5));
        printerManager.addPrinter(new InkjetPrinter("cyan", 6, "magenta", 3, "yellow", 2, "black", 5));
        printerManager.addPrinter(new LaserPrinter(15, 6));
        printerManager.addPrinter(new LaserPrinter(13, 3));
        printerManager.addPrinter(new PhotoPrinter("laser", 6, true, 3));
        printerManager.addPrinter(new PhotoPrinter("laser", 5, false, 5));
        printerManager.addPrinter(new ThreeDPrinter("scanner", 8, false));
        printerManager.addPrinter(new ThreeDPrinter("laser", 5, true));
    }

    @Test
    void testAddPrinter() {
        var initialSize = printerManager.getPrinters().size();
        printerManager.addPrinter(new InkjetPrinter("cyan", 9, "magenta", 8, "yellow", 3, "black", 5));
        var updatedSize = printerManager.getPrinters().size();
        assertEquals(initialSize + 1, updatedSize);
    }

    @Test
    void testFindPrinterWithType() {
        var laserPrinters = printerManager.findPrinterWithType("laser");
        assertEquals(3, laserPrinters.size());
        var inkjetPrinters = printerManager.findPrinterWithType("inkjet");
        assertEquals(0, inkjetPrinters.size());
        var photoPrinters = printerManager.findPrinterWithType("photo");
        assertEquals(0, photoPrinters.size());
        var treeDPrinters = printerManager.findPrinterWithType("3d");
        assertEquals(0, treeDPrinters.size());
    }

    @Test
    void testFindPrinterWithMoreInkLevelThan() {
        PrinterManager printerManager = new PrinterManager();
        InkjetPrinter inkjetPrinter1 = new InkjetPrinter("cyan",9,"magenta", 8,"yellow" ,3,"black",5);
        InkjetPrinter inkjetPrinter2 = new InkjetPrinter("cyan",6,"magenta", 7,"yellow" ,2,"black",1);
        LaserPrinter laserPrinter = new LaserPrinter(15, 6);
        printerManager.addPrinter(inkjetPrinter1);
        printerManager.addPrinter(inkjetPrinter2);
        printerManager.addPrinter(laserPrinter);
        assertEquals(0, printerManager.findPrinterWithMoreInkLevelThan(2).size());
        assertFalse(printerManager.findPrinterWithMoreInkLevelThan(2).contains(inkjetPrinter1));
        assertFalse(printerManager.findPrinterWithMoreInkLevelThan(2).contains(inkjetPrinter2));
        assertEquals(0, printerManager.findPrinterWithMoreInkLevelThan(10).size());
        assertFalse(printerManager.findPrinterWithMoreInkLevelThan(10).contains(laserPrinter));
    }
}