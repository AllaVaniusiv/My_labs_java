package ua.lviv.iot.algo.part1.lab1.modules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab1.modules.PhotoPrinter;

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
    @Test
    public void testGetHeaders() {
        PhotoPrinter printer = new PhotoPrinter( "laser" , 70 , true , 25.0);
        String expectedHeaders = "model,type,isColor,isDuplex,paperTrayCapacity,paperCount,inkLevel, type , resolution , isColor , inkLevel";
        assertEquals(expectedHeaders, printer.getHeaders());
    }

    @Test
    public void testToCSV() {
        PhotoPrinter printer = new PhotoPrinter( "laser" , 90 , true , 30.0);
        String expectedCSV = "null,null,false,false,0,0,0.0,laser,90,true,30.0";
        assertEquals(expectedCSV, printer.toCSV());
    }

}