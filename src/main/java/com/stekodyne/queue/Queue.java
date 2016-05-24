package com.stekodyne.queue;

import com.stekodyne.Constants;
import com.stekodyne.config.Config;
import com.stekodyne.job.Job;
import com.stekodyne.job.JobFactory;

import java.io.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by steffen on 5/21/16.
 * <p>
 * Print job process class and basic reporting.
 */
public class Queue {
    private final ArrayList<Job> jobs;
    private final String file;
    private BigDecimal cost;

    private final Config config;

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder()
                .append("Queue {\n")
                .append("\tfile = ").append(file).append("\n")
                .append("\tconfig = ").append(config).append("\n")
                .append("\tcost = ").append(getCostAsString()).append("\n")
                .append("\tjobs = {\n");
        for (Job job : jobs) {
            output.append(job.toString());
        }
        output.append("\t}\n}\n");
        return output.toString();
    }

    public Queue(Config config) {
        this.config = config;
        this.jobs = new ArrayList<Job>();
        this.file = this.config.getString(Constants.QUEUE_FILE_LOCATION) + this.config.getString(Constants.QUEUE_FILE_NAME);
        this.cost = new BigDecimal(0);
        process();
    }

    private void process() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] printJob = line.split(",");
                Job job = JobFactory.getJob(config, Constants.Paper.A4, Integer.parseInt(printJob[0].trim()), Integer.parseInt(printJob[1].trim()), Boolean.parseBoolean(printJob[2].trim()));
                jobs.add(job);
                cost = cost.add(job.getCost());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getCostAsString() {
        NumberFormat form = NumberFormat.getCurrencyInstance(new Locale(config.getString(Constants.LANGUAGE), config.getString(Constants.COUNTRY)));
        return form.format(cost);
    }
}
