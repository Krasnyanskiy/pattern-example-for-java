package ua.krasnyanskiy.pattern.command.job;

import ua.krasnyanskiy.pattern.command.receiver.ReportPrinter;

/**
 * @author Alexander Krasnyanskiy
 */
public class PDFReportJob implements Command {

    ReportPrinter receiver;

    public PDFReportJob(ReportPrinter receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.printReportAndIncrement();
    }
}
