package br.com.jgle.acti.component;

import java.text.DecimalFormat;
import java.util.Date;

import org.zkoss.zk.ui.util.Statistic;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

public class StatisticGroupBox extends Groupbox {

	private static final long serialVersionUID = 1L;

	public StatisticGroupBox() {
		/**
		 * These Statistic Class is activated in the zk.xml
		 */
		Statistic stat = new Statistic();

		Caption caption = new Caption();
		appendChild(caption);
		caption.setImage("/img/png/monitorView.gif");
		caption.setLabel("Application Statistic");
		caption.setStyle("color: #000000;font-weight:bold; text-align:left ");

		Grid grid = new Grid();
		grid.setWidth("100%");
		// grid.setParent(panelchildren);
		appendChild(grid);

		Columns columns = new Columns();
		columns.setSizable(true);
		columns.setParent(grid);

		Column column1 = new Column();
		column1.setWidth("55%");
		column1.setLabel("Subject");
		column1.setParent(columns);
		Column column2 = new Column();
		column2.setWidth("45%");
		column2.setLabel("value");
		column2.setParent(columns);

		Rows rows = new Rows();
		rows.setParent(grid);

		addNewRow(rows, "Application Start-Time",
				String.valueOf(new Date(stat.getStartTime())));

		Long v = System.currentTimeMillis() - stat.getStartTime();
		// Application runing hours
		addNewRow(rows, "Tempo Aplicação/hora", ((double) v) / 3600000);
		// Count of active Desktops
		addNewRow(rows, "Quantidade Desktop ativos",
				String.valueOf(stat.getActiveDesktopCount()));
		// Count of active Sessions
		addNewRow(rows, "Quantidade de sessão ativada",
				String.valueOf(stat.getActiveSessionCount()));
		// Count of active Updates
		addNewRow(rows, "Quantidade de atividades update",
				String.valueOf(stat.getActiveUpdateCount()));

		// Average Count of active Desktops/hour
		addNewRow(rows, "Média de ativação Desktops/hora",
				getRoundedDouble(stat.getAverageDesktopCount()));
		// Average Count of active Sessions/hour
		addNewRow(rows, "Média de quantidade de ativação sessão/hora",
				getRoundedDouble(stat.getAverageSessionCount()));
		// Average Count of active Updates/hour
		addNewRow(rows, "Média de quantidade de ativação update/hora",
				getRoundedDouble(stat.getAverageUpdateCount()));

		// Count of total Desktops since start
		addNewRow(rows, "Quantidade total de Desktops iniciado",
				String.valueOf(stat.getTotalDesktopCount()));
		// Count of total Sessions since start
		addNewRow(rows, "Quantidade total de sessão iniciada",
				String.valueOf(stat.getTotalSessionCount()));
		// Count of total Updates since start
		addNewRow(rows, "Quantidade total de update iniciado",
				String.valueOf(stat.getTotalUpdateCount()));

		// Get the free Memory of the JAVA VM
		double value = ((Runtime.getRuntime().totalMemory() - Runtime
				.getRuntime().freeMemory()) * 100.0)
				/ Runtime.getRuntime().maxMemory();
		// current free memory on the JAVA VM
		addNewRow(rows, "Corrent memória disponivel na JAVA VM",
				getRoundedDouble(value) + " MB", "red");
		// Get the number of processors that are available for the JAVA VM
		int countCPU = Runtime.getRuntime().availableProcessors();
		// available processors to the JAVA VM
		addNewRow(rows, "Processos avaliados pela JAVA VM", countCPU, "red");
	}

	/**
	 * Add a new row to the grid.<br>
	 * 
	 * @param rowParent
	 * @param tableName
	 * @param value
	 */
	private void addNewRow(Rows rowParent, String tableName, Object value) {
		Row row;
		Label label_TableName;
		Label label_RecordCount;

		row = new Row();
		label_TableName = new Label(tableName);
		label_TableName.setParent(row);
		label_RecordCount = new Label(String.valueOf(value));
		label_RecordCount.setId("label_RecordCount_" + tableName);
		label_RecordCount.setParent(row);
		row.setParent(rowParent);
	}

	/**
	 * Round a double value to a string with two digits.
	 * 
	 * @param d
	 * @return
	 */
	private String getRoundedDouble(double d) {
		String result = "";

		DecimalFormat df = new DecimalFormat("0.00");
		result = df.format(d);

		return result;
	}

	/**
	 * Add a new row to the grid.<br>
	 * 
	 * @param rowParent
	 * @param tableName
	 * @param value
	 * @param color
	 */
	private void addNewRow(Rows rowParent, String tableName, Object value,
			String color) {

		Row row;
		Label label_TableName;
		Label label_RecordCount;
		row = new Row();
		label_TableName = new Label(tableName);

		if (color.equalsIgnoreCase("red")) {
			label_TableName.setStyle("color: " + color + ";");
		}

		label_TableName.setParent(row);
		label_RecordCount = new Label(String.valueOf(value));

		if (color.equalsIgnoreCase("red")) {
			label_RecordCount.setStyle("color: " + color + ";");
		}

		label_RecordCount.setParent(row);
		row.setParent(rowParent);
	}
}
