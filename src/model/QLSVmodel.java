package model;

import java.util.ArrayList;

public class QLSVmodel {
	private ArrayList<ThiSinh> dsThiSinh;

	public QLSVmodel() {
		this.dsThiSinh = new ArrayList<ThiSinh>();
	}

	/**
	 * @return the dsThiSinh
	 */
	public ArrayList<ThiSinh> getDsThiSinh() {
		return dsThiSinh;
	}

	/**
	 * @param dsThiSinh the dsThiSinh to set
	 */
	public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}

	@Override
	public String toString() {
		return "QLSVmodel [dsThiSinh=" + dsThiSinh + "]";
	}

	public void insert(ThiSinh thiSinh) {
		this.dsThiSinh.add(thiSinh);
	}

	public void delete(ThiSinh thiSinh) {
		this.dsThiSinh.remove(thiSinh);
	}

	public void update(ThiSinh thiSinh) {
		this.dsThiSinh.remove(thiSinh);
		this.dsThiSinh.add(thiSinh);
	}

	public boolean kiemTraTonTai(ThiSinh ts) {
		for (ThiSinh thiSinh : dsThiSinh) {
			if (ts.getMaThiSinh() == thiSinh.getMaThiSinh())
				return true;
		}
		return false;
	}

	public ThiSinh getThiSinhByID(int i) {
		for (ThiSinh thiSinh : dsThiSinh) {
			if (i == thiSinh.getMaThiSinh())
				return thiSinh;
		}
		return null;
	}

	public ArrayList<ThiSinh> getListThiSinhByQueQuan(Tinh tinh) {
		ArrayList<ThiSinh> listThiSinhTinh = new ArrayList<ThiSinh>();
		for (ThiSinh thiSinh : dsThiSinh) {
			if (tinh.getTenTinh().equals(thiSinh.getQueQuan().getTenTinh())) {
				listThiSinhTinh.add(thiSinh);
			}
		}
		return listThiSinhTinh;
	}
}
