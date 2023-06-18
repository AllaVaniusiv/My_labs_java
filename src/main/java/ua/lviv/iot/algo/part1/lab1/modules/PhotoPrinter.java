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
@ToString(callSuper = true)
public final class PhotoPrinter extends Printer {
    private String type;
    private int resolution;
    private boolean isColor;
    private double inkLevel;

    @Override
    public int getRemainingPagesCount() {
        return 0;
    }

    public String getHeaders() {
        return super.getHeaders() + ", type , resolution , isColor , inkLevel";
    }

    public String toCSV() {
        return super.toCSV() + "," + type + "," + resolution + "," + isColor + "," + inkLevel;

    }
}
