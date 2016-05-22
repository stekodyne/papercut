package com.stekodyne.queue;

import com.stekodyne.config.Config;
import junit.framework.TestCase;

/**
 * Created by steffen on 5/22/16.
 */
public class QueueTest extends TestCase {
    private Config config;

    public QueueTest() {
        this.config = new Config();
    }

    public void testGetCostAsString() throws Exception {
        Queue queue = new Queue(config);
        assertEquals("$64.10", queue.getCostAsString());
    }
}