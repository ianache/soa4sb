package ws.crossnet.soa4sb.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "stockQuote")
public class StockQuoteBean {
	public Float getQuote(float i) {
        return i;
    }
}
