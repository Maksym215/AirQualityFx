package src.model;

public class Data {
private String data;
private String time;
private String O3;
private String SO2;
private String NO2;
private String indices;

public Data() {
	super();
}
public Data(String data, String time, String o3, String sO2, String nO2, String indices) {
	super();
	this.data = data;
	this.time = time;
	O3 = o3;
	SO2 = sO2;
	NO2 = nO2;
	this.indices = indices;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getO3() {
	return O3;
}
public void setO3(String o3) {
	O3 = o3;
}
public String getSO2() {
	return SO2;
}
public void setSO2(String sO2) {
	SO2 = sO2;
}
public String getNO2() {
	return NO2;
}
public void setNO2(String nO2) {
	NO2 = nO2;
}
public String getIndices() {
	return indices;
}
public void setIndices(String indices) {
	this.indices = indices;
}

}
