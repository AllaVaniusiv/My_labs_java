package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InkjetPrinterTest {
    private InkjetPrinter printer;

    @BeforeEach
    void setUp() {
        printer = new InkjetPrinter("Dye", 100, "Pigment", 50, "Dye", 70, "Pigment", 80);
    }

    @Test
    void testGetRemainingPagesCount() {
        assertEquals(10, printer.getRemainingPagesCount());
        printer.setCyanInkLevel(2);
        assertEquals(0, printer.getRemainingPagesCount());
    }
    @Test
    @DisplayName("Test getRemainingPagesCount with enough ink levels")
    public void testGetRemainingPagesCountEnoughInk() {
        assertEquals(10, printer.getRemainingPagesCount(), "Remaining pages count should be 20");
    }

    @Test
    @DisplayName("Test getRemainingPagesCount with not enough ink levels")
    public void testGetRemainingPagesCountNotEnoughInk() {
        printer.setCyanInkLevel(2.0);
        assertEquals(0, printer.getRemainingPagesCount(), "Remaining pages count should be 0");
    }
    @Test
    public void testInkTypeAndLevel() {
        assertEquals("Dye", printer.getCyanInkType());
        assertEquals(100, printer.getCyanInkLevel(), 0.001);
        assertEquals("Pigment", printer.getMagentaInkType());
        assertEquals(50, printer.getMagentaInkLevel(), 0.001);
        assertEquals("Dye", printer.getYellowInkType());
        assertEquals(70, printer.getYellowInkLevel(), 0.001);
        assertEquals("Pigment", printer.getBlackInkType());
        assertEquals(80, printer.getBlackInkLevel(), 0.001);
    }
    @Test
    public void testGetHeaders() {
        InkjetPrinter printer = new InkjetPrinter( "cyan", 50, "magenta", 50, "yellow", 50, "black", 50);
        String expectedHeaders = "model,type,isColor,isDuplex,paperTrayCapacity,paperCount,inkLevel, cyanInkType,cyanInkLevel,magentaInkType,magentaInkLevel,yellowInkType ,yellowInkLevel,blackInkType,blackInkLevel";
        assertEquals(expectedHeaders, printer.getHeaders());
    }

    @Test
    public void testToCSV() {
        InkjetPrinter printer = new InkjetPrinter( "cyan", 50, "magenta", 50, "yellow", 50, "black", 50);
        String expectedCSV = "null,null,false,false,0,0,0.0,cyan,50.0,magenta,50.0,yellow,50.0,black,50.0";
        assertEquals(expectedCSV, printer.toCSV());
    }
}
