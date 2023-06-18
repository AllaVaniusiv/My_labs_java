package ua.lviv.iot.algo.part1.lab1;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public final class ThreeDPrinter extends Printer {
    private String type;
    private int printingSpeed;
    private boolean isColorPrinter;

    @Override
    public int getRemainingPagesCount() {
        return 0;
    }
    public String getHeaders() {
        return super.getHeaders() + ",type,printingSpeed,isColorPrinter";
    }
    public String toCSV() {
        return super.toCSV() + "," + type + "," + printingSpeed + "," + isColorPrinter ;

    }

}
