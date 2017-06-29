package br.com.jgle.acti.util;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;

public class ExcelUtil {

	public static void export_to_csv(Listbox listbox) {
		String s = ";";
		StringBuffer sb = new StringBuffer();

		for (Object head : listbox.getHeads()) {
			String h = "";
			for (Object header : ((Listhead) head).getChildren()) {
				h += ((Listheader) header).getLabel() + s;
			}
			sb.append(h + "\n");
		}
		for (Object item : listbox.getItems()) {
			String i = "";
			for (Object cell : ((Listitem) item).getChildren()) {
				i += ((Listcell) cell).getLabel() + s;
			}
			sb.append(i + "\n");
		}
		org.zkoss.zul.Filedownload.save(sb.toString().getBytes(), "text/plain", "lista.csv");
	}
}
