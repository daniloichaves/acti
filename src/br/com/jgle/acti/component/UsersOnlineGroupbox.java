package br.com.jgle.acti.component;

import org.zkoss.zk.ui.util.Statistic;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Chart;
import org.zkoss.zul.DialModel;
import org.zkoss.zul.DialModelScale;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;

@SuppressWarnings("serial")
public class UsersOnlineGroupbox extends Groupbox {

	public UsersOnlineGroupbox() {
		Caption caption = new Caption();
		appendChild(caption);
		caption.setImage("/img/png/console_view.gif");
		caption.setLabel("Users online");
		caption.setStyle("color: #000000;font-weight:bold; text-align:left ");

		Div div = new Div();
		div.setWidth("100%");
		div.setHeight("100%");
		appendChild(div);

		// Chart Dial
		// Random random = new Random();
		Statistic statistic = new Statistic();

		int val = statistic.getActiveDesktopCount();
		DialModel dialmodel = new DialModel();
		DialModelScale scale = dialmodel.newScale(0.0, 500.0, -120.0, -300.0,
				100.0, 4);// scale's
		// configuration
		// data
		scale.setText("Users");
		scale.newRange(450, 500, "#FF0000", 0.83, 0.89);
		scale.newRange(360, 450, "#FFC426", 0.83, 0.89);
		scale.setValue(val);

		Chart chart = new Chart();
		chart.setType("dial");
		chart.setWidth("228px");
		chart.setHeight("220px");
		chart.setThreeD(false);
		chart.setFgAlpha(128);
		chart.setBgColor("#FFFFFF");
		chart.setModel(dialmodel);
		chart.setParent(div);
	}
}
