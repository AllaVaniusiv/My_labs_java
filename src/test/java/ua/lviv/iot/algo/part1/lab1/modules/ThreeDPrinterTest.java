package ua.lviv.iot.algo.part1.lab1.modules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab1.modules.Printer;
import ua.lviv.iot.algo.part1.lab1.modules.ThreeDPrinter;

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
        String expected = "ThreeDPrinter(super=Printer(model=null, type=laser," +
                " isColor=false, isDuplex=false, paperTrayCapacity=0, paperCount=0, inkLevel=0.0), type=laser, printingSpeed=250, isColorPrinter=true)";
        Assertions.assertEquals(expected, printer.toString());
    }


    @Test
    void testGetRemainingPagesCount() {
        assertEquals(0, printer.getRemainingPagesCount());
    }
    @Test
    public void testGetHeaders() {
        ThreeDPrinter printer = new ThreeDPrinter( "inkjet" ,150,true);
        String expectedHeaders = "model,type,isColor,isDuplex,paperTrayCapacity,paperCount,inkLevel,type,printingSpeed,isColorPrinter";
        assertEquals(expectedHeaders, printer.getHeaders());
    }

    @Test
    public void testToCSV() {
        ThreeDPrinter printer = new ThreeDPrinter( "inkjet" , 200 , true);
        String expectedCSV = "null,null,false,false,0,0,0.0,inkjet,200,true";
        assertEquals(expectedCSV, printer.toCSV());
    }


}