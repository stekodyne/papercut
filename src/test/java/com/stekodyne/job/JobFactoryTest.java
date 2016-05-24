package com.stekodyne.job;

import com.stekodyne.Constants;
import com.stekodyne.config.Config;
import com.stekodyne.job.impl.A4;
import junit.framework.TestCase;

/**
 * Created by steffen on 5/22/16.
 */
public class JobFactoryTest extends TestCase {
    public void testGetJob() throws Exception {
        Config config = new Config();
        Job job = JobFactory.getJob(config, Constants.Paper.A4, 10, 5, false);
        assertEquals(A4.class, job.getClass());
    }
}