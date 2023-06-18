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
public class InkjetPrinter extends Printer {
    private String cyanInkType;
    private double cyanInkLevel;
    private String magentaInkType;
    private double magentaInkLevel;
    private String yellowInkType;
    private double yellowInkLevel;
    private String blackInkType;
    private double blackInkLevel;
    private static final int REQUIRED_COLOUR_PER_PAGE = 5;

    @Override
    public int getRemainingPagesCount() {
        int remainingCyanPages = (int) Math.floor(cyanInkLevel / REQUIRED_COLOUR_PER_PAGE);
        int remainingMagentaPages = (int) Math.floor(magentaInkLevel / REQUIRED_COLOUR_PER_PAGE);
        int remainingYellowPages = (int) Math.floor(yellowInkLevel / REQUIRED_COLOUR_PER_PAGE);
        int remainingBlackPages = (int) Math.floor(blackInkLevel / REQUIRED_COLOUR_PER_PAGE);
        return Math.min(Math.min(remainingCyanPages, remainingMagentaPages), Math.min(remainingYellowPages, remainingBlackPages));
    }
}
