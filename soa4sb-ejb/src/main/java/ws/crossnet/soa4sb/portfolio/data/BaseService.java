package ws.crossnet.soa4sb.portfolio.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SERVICE")
public class BaseService {
	@Id @Column(name="CODE") String code;

	public BaseService() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
