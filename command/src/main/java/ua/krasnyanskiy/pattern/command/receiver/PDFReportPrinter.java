package ua.krasnyanskiy.pattern.command.receiver;

/**
 * @author Alexander Krasnyanskiy
 */
public class PDFReportPrinter implements Receiver, ReportPrinter {

    private int pages;

    public PDFReportPrinter() {
        this.pages = 100;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public void printReportAndIncrement() {
        System.out.println(pages);
    }
}
