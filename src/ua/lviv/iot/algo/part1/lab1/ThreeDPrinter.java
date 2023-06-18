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
@ToString
public class ThreeDPrinter extends Printer {
    private String type;
    private int printingSpeed;
    private boolean isColorPrinter;

    @Override
    public int getRemainingPagesCount() {
        return 0;
    }
}
