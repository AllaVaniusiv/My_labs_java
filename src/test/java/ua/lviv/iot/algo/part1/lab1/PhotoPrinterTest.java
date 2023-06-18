package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhotoPrinterTest {
    private PhotoPrinter photoPrinter;

    @BeforeEach
    void setUp() {
        photoPrinter = new PhotoPrinter("Inkjet", 2400, true, 0.5);
    }

    @Test
    void testGetRemainingPagesCount() {
        assertEquals(0, photoPrinter.getRemainingPagesCount());
    }
    @Test
    public void testToString() {
        String expected = "PhotoPrinter(super=Printer(model=null, type=Inkjet, " +
                "isColor=true, isDuplex=false, paperTrayCapacity=0, paperCount=0, " +
                "inkLevel=0.5), type=Inkjet, resolution=2400, isColor=true, inkLevel=0.5)";
        Assertions.assertEquals(expected, photoPrinter.toString());
    }

}