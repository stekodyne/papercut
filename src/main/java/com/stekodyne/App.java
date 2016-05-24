package com.stekodyne;

import com.stekodyne.config.Config;
import com.stekodyne.queue.Queue;

/**
 * Papercut App
 *
 * mvn clean test compile exec:java -Dexec.mainClass="com.stekodyne.App"
 */
public class App {

    public static void main(String[] args) {
        Config config = new Config();

        if(config != null) {
            Queue queue = new Queue(config);
            System.out.print(queue.toString());
        }
    }
}
