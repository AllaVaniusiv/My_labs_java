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
public final class LaserPrinter extends Printer {
    private int tonerPagesCount;
    private int printedPagesCount;

    @Override
    public int getRemainingPagesCount() {
        return tonerPagesCount - printedPagesCount;
    }

}
