package ua.lviv.iot.algo.part1.lab1.modules;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class Printer {
    private String model;
    private String type;
    private boolean isColor;
    private boolean isDuplex;
    private int paperTrayCapacity;
    private int paperCount;
    private double inkLevel;
    public static Printer defaultPrinter;

    public static Printer getInstance() {
        return defaultPrinter;
    }


    public final void print(final int pages) {
        if (pages <= paperCount) {
            paperCount -= pages;
            System.out.println("Printing " + pages + " pages...");
        } else {
            System.out.println("Not enough paper in the tray!");
        }
    }

    public final void loadPaper(final int count) {
        paperCount += count;
        if (paperCount > paperTrayCapacity) {
            paperCount = paperTrayCapacity;
        }
    }

    public abstract int getRemainingPagesCount();
    public  String getHeaders() {
        return "model,type,isColor,isDuplex,paperTrayCapacity,paperCount,inkLevel";
    }

    public  String toCSV() {
        return model + "," + type + "," + isColor + "," + isDuplex + ","
                + paperTrayCapacity + "," + paperCount + "," + inkLevel;
    }


}
