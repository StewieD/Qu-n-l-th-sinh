package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Tinh implements Serializable{
private int maTinh;
private String tenTinh;
public Tinh(int maTinh, String tenTinh) {
	super();
	this.maTinh = maTinh;
	this.tenTinh = tenTinh;
}
/**
 * @return the maTinh
 */
public int getMaTinh() {
	return maTinh;
}
/**
 * @param maTinh the maTinh to set
 */
public void setMaTinh(int maTinh) {
	this.maTinh = maTinh;
}
/**
 * @return the tenTinh
 */
public String getTenTinh() {
	return tenTinh;
}
/**
 * @param tenTinh the tenTinh to set
 */
public void setTenTinh(String tenTinh) {
	this.tenTinh = tenTinh;
}

@Override
public String toString() {
	return "Tinh [maTinh=" + maTinh + ", tenTinh=" + tenTinh + "]";
}
@Override
public int hashCode() {
	return Objects.hash(maTinh, tenTinh);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Tinh other = (Tinh) obj;
	return  Objects.equals(tenTinh, other.tenTinh);
}
public static ArrayList<Tinh> getListTinh(){
	String[] listTenTinh = {"","An Giang",
			"Bà Rịa-Vũng Tàu",
			"Bạc Liêu",
			"Bắc Kạn",
			"Bắc Giang",
			"Bắc Ninh",
			"Bến Tre",
			"Bình Dương",
			"Bình Định",
			"Bình Phước",
			"Bình Thuận",
			"Cà Mau",
			"Cao Bằng",
			"Cần Thơ (TP)",
			"Đà Nẵng (TP)",
			"Đắk Lắk",
			"Đắk Nông",
			"Điện Biên",
			"Đồng Nai",
			"Đồng Tháp",
			"Gia Lai",
			"Hà Giang",
			"Hà Nam",
			"Hà Nội (TP)",
			"Hà Tây",
			"Hà Tĩnh",
			"Hải Dương",
			"Hải Phòng (TP)",
			"Hòa Bình",
			"Hồ Chí Minh (TP)",
			"Hậu Giang",
			"Hưng Yên",
			"Khánh Hòa",
			"Kiên Giang",
			"Kon Tum",
			"Lai Châu",
			"Lào Cai",
			"Lạng Sơn",
			"Lâm Đồng",
			"Long An",
			"Nam Định",
			"Nghệ An",
			"Ninh Bình",
			"Ninh Thuận",
			"Phú Thọ",
			"Phú Yên",
			"Quảng Bình",
			"Quảng Nam",
			"Quảng Ngãi",
			"Quảng Ninh",
			"Quảng Trị",
			"Sóc Trăng",
			"Sơn La",
			"Tây Ninh",
			"Thái Bình",
			"Thái Nguyên",
			"Thanh Hóa",
			"Thừa Thiên - Huế",
			"Tiền Giang",
			"Trà Vinh",
			"Tuyên Quang",
			"Vĩnh Long",
			"Vĩnh Phúc",
			"Yên Bái"};
	int maTinh = 0;
	ArrayList<Tinh> listTinh = new ArrayList<Tinh>(); 
	for (String tenTinh : listTenTinh) {
		Tinh t = new Tinh(maTinh, tenTinh);
		listTinh.add(t);
		maTinh++;
	}
	return listTinh;
}
public static Tinh getTinhByID(int birthPlace) {
	return Tinh.getListTinh().get(birthPlace);
}
public static Tinh getTinhByTen(String tenTinh) {
	ArrayList<Tinh> listTinh = Tinh.getListTinh();
	for (Tinh tinh : listTinh) {
		if(tinh.tenTinh.equals(tenTinh)) {
			return tinh;
		}
	}
	return null;
}
}
