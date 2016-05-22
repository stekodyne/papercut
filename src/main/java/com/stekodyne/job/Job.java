package com.stekodyne.job;

import com.stekodyne.Constants;
import com.stekodyne.config.Config;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by steffen on 5/21/16.
 */
public abstract class Job {
    private int pages;
    private int colorPages;
    private boolean isDoubleSided;
    private BigDecimal cost;
    private Config config;

    public Job(Config config, int pages, int colorPages, boolean isDoubleSided) {
        this.pages = pages;
        this.colorPages = colorPages;
        this.isDoubleSided = isDoubleSided;
        this.config = config;
        calculateCost();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Job{\n");
        output.append("pages=" + pages + "\n");
        output.append("colorPages=" + colorPages + "\n");
        output.append("isDoubleSided=" + isDoubleSided + "\n");
        output.append("cost=" + getCostAsString() + "\n");
        output.append("}\n");
        return output.toString();
    }

    private void calculateCost() {
        double color = 0;
        double bw = 0;
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
