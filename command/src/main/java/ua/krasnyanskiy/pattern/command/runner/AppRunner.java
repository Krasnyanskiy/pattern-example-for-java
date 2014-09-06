package ua.krasnyanskiy.pattern.command.runner;

import ua.krasnyanskiy.pattern.command.job.CSVPrinterJob;
import ua.krasnyanskiy.pattern.command.receiver.CSVConfigurer;
import ua.krasnyanskiy.pattern.command.invoker.Client;
import ua.krasnyanskiy.pattern.command.job.Command;
import ua.krasnyanskiy.pattern.command.receiver.Configurer;
import ua.krasnyanskiy.pattern.command.receiver.PDFReportPrinter;
import ua.krasnyanskiy.pattern.command.job.PDFReportJob;
import ua.krasnyanskiy.pattern.command.receiver.ReportPrinter;

import java.util.Arrays;

/**
 * @author Alexander Krasnyanskiy
 */
public class AppRunner {
    public static void main(String[] args) {

        /** Invoker **/
        Client client = new Client();

        /** Receivers **/
        ReportPrinter reportPrinter = new PDFReportPrinter();
        Configurer configurer = new CSVConfigurer();

        /** Commands **/
        Command configurerJob = new CSVPrinterJob(configurer);
        Command reportJob = new PDFReportJob(reportPrinter);

        /** Invoker setup **/
        client.setCommands(Arrays.asList(configurerJob, reportJob));

        for (Command command : client.getCommands()){
            command.execute();
        }

        //CSVConfiguratorJob retrieved = (CSVConfiguratorJob) client.getCommands().get(0);
        //retrieved.execute();
        //retrieved.save();
    }
}
