package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeDPrinterTest {
    private ThreeDPrinter printer;

    @BeforeEach
    void setUp() {
        printer = new ThreeDPrinter("laser", 250, true);
        Printer.defaultPrinter = printer;
    }

    @Test
    public void testToString() {
        String expected = "ThreeDPrinter(super=Printer(model=null, type=laser, isColor=false, isDuplex=false, paperTrayCapacity=0, paperCount=0, inkLevel=0.0), type=laser, printingSpeed=250, isColorPrinter=true)";
        Assertions.assertEquals(expected, printer.toString());
    }


    @Test
    void testGetRemainingPagesCount() {
        assertEquals(0, printer.getRemainingPagesCount());
    }


}