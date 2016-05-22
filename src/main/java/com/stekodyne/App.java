package com.stekodyne;

import com.stekodyne.config.Config;
import com.stekodyne.queue.Queue;

/**
 * Papercut App
 */
public class App {
    static Config config;

    public static void main(String[] args) {
        config = new Config();

        if(config != null) {
            Queue queue = new Queue(config);
            System.out.print(queue.toString());
        }
    }
}
