package com.stekodyne.job;

import com.stekodyne.config.Config;
import com.stekodyne.job.impl.A4;
import junit.framework.TestCase;

import java.math.BigDecimal;

/**
 * Created by steffen on 5/22/16.
 */
public class JobTest extends TestCase {
    private final Config config = new Config();

    public void testGetCost() throws Exception {
        Job job = new A4(config, 10, 5, true);
        assertEquals(new BigDecimal(1.50).setScale(2, BigDecimal.ROUND_HALF_UP), job.getCost());

        job = new A4(config, 10, 5, false);
        assertEquals(new BigDecimal(2.00).setScale(2, BigDecimal.ROUND_HALF_UP), job.getCost());
    }

    public void testGetCostAsString() throws Exception {
        Job job = new A4(config, 10, 5, true);
        assertEquals("$1.50", job.getCostAsString());

        job = new A4(config, 10, 5, false);
        assertEquals("$2.00", job.getCostAsString());
    }

}