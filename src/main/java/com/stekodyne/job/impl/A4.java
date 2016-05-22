package com.stekodyne.job.impl;

import com.stekodyne.config.Config;
import com.stekodyne.job.Job;

/**
 * Created by steffen on 5/21/16.
 */
public class A4 extends Job {

    public A4(Config config, int pages, int colorPages, boolean isDoubleSided) {
        super(config, pages, colorPages, isDoubleSided);
    }
}
