package th.co.api.salary.model.rest;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RegisterModelRequest implements Serializable {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMdd", Locale.ENGLISH);

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String phone;
	private String address;
	private Integer salary;
	private String memberType;
	private String registerRef;
	private Date created;
	private Date updated;

	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	// last 4 digits of phone number like this “YYYYMMdd XXXX”
	public String getRegisterRef() {
		String dateTimeStr = dateFormat.format(this.created);
		String digitsLast = this.phone.substring(6, 10);
		this.registerRef = dateTimeStr + digitsLast;
		return registerRef;
	}

	public void setRegisterRef(String registerRef) {
		this.registerRef = registerRef;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegisterModelRequest [dateFormat=");
		builder.append(dateFormat);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", address=");
		builder.append(address);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", memberType=");
		builder.append(memberType);
		builder.append(", registerRef=");
		builder.append(registerRef);
		builder.append(", created=");
		builder.append(created);
		builder.append(", updated=");
		builder.append(updated);
		builder.append("]");
		return builder.toString();
	}

}
