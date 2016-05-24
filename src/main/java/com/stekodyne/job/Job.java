package com.stekodyne.job;

import com.stekodyne.Constants;
import com.stekodyne.config.Config;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by steffen on 5/21/16.
 *
 * The parent class for all print jobs.
 *
 */
public abstract class Job {
    private final int pages;
    private final int colorPages;
    private final boolean isDoubleSided;
    private BigDecimal cost;
    private final Config config;

    protected Job(Config config, int pages, int colorPages, boolean isDoubleSided) {
        this.pages = pages;
        this.colorPages = colorPages;
        this.isDoubleSided = isDoubleSided;
        this.config = config;
        calculateCost();
    }

    @Override
    public String toString() {
        return "\t\tJob {\n" +
                "\t\t\tpages = " + pages + "\n" +
                "\t\t\tcolorPages = " + colorPages + "\n" +
                "\t\t\tisDoubleSided = " + isDoubleSided + "\n" +
                "\t\t\tcost = " + getCostAsString() + "\n" +
                "\t\t}\n";
    }

    private void calculateCost() {
        double color;
        double bw;
        if(isDoubleSided) {
            color = config.getDouble(Constants.A4_COLOR_DOUBLE);
            bw = config.getDouble(Constants.A4_BW_DOUBLE);
        } else {
            color = config.getDouble(Constants.A4_COLOR_SINGLE);
            bw = config.getDouble(Constants.A4_BW_SINGLE);
        }
        double result = ((pages - colorPages) * bw) + (colorPages * color);
        this.cost = new BigDecimal(result).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getCostAsString() {
        NumberFormat form = NumberFormat.getCurrencyInstance(new Locale(config.getString(Constants.LANGUAGE), config.getString(Constants.COUNTRY)));
        return form.format(cost);
    }
}
