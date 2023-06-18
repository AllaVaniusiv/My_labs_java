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
public class PhotoPrinter extends Printer {
    private String type;
    private int resolution;
    private boolean isColor;
    private double inkLevel;

    @Override
    public int getRemainingPagesCount() {
        return 0;
    }
}
