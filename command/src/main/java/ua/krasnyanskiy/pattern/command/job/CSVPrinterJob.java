package ua.krasnyanskiy.pattern.command.job;

import ua.krasnyanskiy.pattern.command.receiver.Configurer;

/**
 * @author Alexander Krasnyanskiy
 */
public class CSVPrinterJob implements Command {

    private Configurer configurer;

    public CSVPrinterJob(Configurer configurer) {
        this.configurer = configurer;
    }

    @Override
    public void execute() {
        configurer.configureAndPrint();
    }
}
