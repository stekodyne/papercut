package com.stekodyne.job;

import com.stekodyne.Constants.Paper;
import com.stekodyne.config.Config;
import com.stekodyne.job.impl.A4;

/**
 * Created by steffen on 5/21/16.
 *
 * This class would be extend to allow for different print jobs.
 */
public class JobFactory {
    public static Job getJob(Config config, Paper paper, int pages, int colorPages, boolean isDoubleSided) {
        Job job = null;
        switch (paper) {
            case A4:
                job = new A4(config, pages, colorPages, isDoubleSided);
                break;
            default:
                break;
        }
        return job;
    }
}
