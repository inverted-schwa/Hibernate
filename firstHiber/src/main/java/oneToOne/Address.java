package oneToOne;
import javax.persistence.*;
@Entity
@Table(name="Address")
public class Address {
	@Id
	@Column(name="addressid")
	private int adressid;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	public int getAdressid() {
		return adressid;
	}
	public void setAdressid(int adressid) {
		this.adressid = adressid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
