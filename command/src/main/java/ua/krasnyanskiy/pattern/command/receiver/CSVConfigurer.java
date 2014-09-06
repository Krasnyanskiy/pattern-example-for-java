package ua.krasnyanskiy.pattern.command.receiver;

/**
 * @author Alexander Krasnyanskiy
 */
public class CSVConfigurer implements Receiver, Configurer {

    private int rows;
    private int columns;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    @Override
    public void configureAndPrint() {
        rows = 5;
        columns = 25;
        System.out.println("rows " + rows + ", " + "columns " + columns);
    }
}
