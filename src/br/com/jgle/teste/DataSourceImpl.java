package br.com.jgle.teste;

import java.util.ArrayList;
import java.util.List;

public class DataSourceImpl implements DataSource {
	public List<String> getElementsList() {
		List<String> list = new ArrayList<String>();
		list.add("Tom");
		list.add("Henri");
		list.add("Jim");
		return list;
	}
}