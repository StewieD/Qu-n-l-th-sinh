package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVmodel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLTSController;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

public class QLSVView extends JFrame {
	public QLSVmodel model;
	public ThiSinh modelThiSinh;
	private JPanel contentPane;
	public JTextField textField_1;
	private JTable table;
	public JTextField textField_ID;
	public JTextField textField_Name;
	public JTextField textField_BirthDay;
	public JTextField textField_Mon2;
	public JTextField textField_Mon1;
	public JTextField textField_Mon3;
	public JComboBox comboBox_BirthPlace;
	public ButtonGroup buttonGroup;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	public JComboBox comboBox;
	public int counting = 0;
	public int iAlert = 0;

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.model = new QLSVmodel();
		setSize(600, 500);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		ActionListener actionListener = new QLTSController(this);
		MouseListener mouseListener = new controller.MouseListener(this);
		JMenu mnNewMenu = new JMenu("File");

		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Open ...");
		mntmNewMenuItem_2.addActionListener(actionListener);
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_Save = new JMenuItem("Save ...");
		mntmNewMenuItem_Save.addActionListener(actionListener);
		mntmNewMenuItem_Save.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_Save);

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Exit ...");
		mntmNewMenuItem_3.addActionListener(actionListener);
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_1 = new JMenu("About");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("About me");
		mntmNewMenuItem.addActionListener(actionListener);
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quê Quán");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 37, 78, 32);
		contentPane.add(lblNewLabel);

		JLabel lblMSinhVin = new JLabel("Mã Sinh Viên");
		lblMSinhVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMSinhVin.setBounds(206, 37, 104, 32);
		contentPane.add(lblMSinhVin);

		textField_1 = new JTextField();
		textField_1.setBounds(300, 45, 77, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		comboBox = new JComboBox();
		ArrayList<Tinh> arrayListTinh = Tinh.getListTinh();
		for (Tinh tinh : arrayListTinh) {
			comboBox.addItem(tinh.getTenTinh());
		}

		comboBox.setBounds(85, 44, 111, 22);
		contentPane.add(comboBox);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 80, 554, 2);
		contentPane.add(separator_1);

		JLabel lblBLcSv = new JLabel("Bộ Lọc Thí Sinh");
		lblBLcSv.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBLcSv.setBounds(219, 2, 131, 32);
		contentPane.add(lblBLcSv);

		table = new JTable();
		table.addMouseListener(mouseListener);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 Th\u00ED Sinh", "T\u00EAn Th\u00ED Sinh", "Qu\u00EA Qu\u00E1n",
						"Ng\u00E0y Sinh", "Gi\u1EDBi T\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2",
						"\u0110i\u1EC3m 3" }));

		JScrollPane scrollBar = new JScrollPane(table);

		scrollBar.setBounds(10, 110, 564, 127);
		contentPane.add(scrollBar);

		JLabel lblDanhSchTh = new JLabel("Danh Sách Thí Sinh");
		lblDanhSchTh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDanhSchTh.setBounds(206, 80, 156, 32);
		contentPane.add(lblDanhSchTh);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(20, 248, 554, 2);
		contentPane.add(separator_1_1);

		JLabel lblThngTinTh = new JLabel("Thông Tin Thí Sinh");
		lblThngTinTh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThngTinTh.setBounds(206, 248, 156, 32);
		contentPane.add(lblThngTinTh);
		JLabel lblNewLabel_1 = new JLabel("Mã Thí Sinh");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 272, 78, 32);
		contentPane.add(lblNewLabel_1);
		String listTenTinh[] = new String[65];
		int i = 0;
		for (Tinh tinh : arrayListTinh) {
			listTenTinh[i] = tinh.getTenTinh();
			i++;
		}
		comboBox_BirthPlace = new JComboBox(listTenTinh);
		comboBox_BirthPlace.setBounds(98, 343, 125, 22);
		contentPane.add(comboBox_BirthPlace);

		JLabel lblNewLabel_1_1 = new JLabel("Họ và tên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 304, 78, 32);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Quê Quán");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 336, 78, 32);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Ngày Sinh");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(10, 368, 78, 32);
		contentPane.add(lblNewLabel_1_3);

		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(98, 280, 111, 20);
		contentPane.add(textField_ID);

		textField_Name = new JTextField();
		textField_Name.setColumns(10);
		textField_Name.setBounds(98, 312, 125, 20);
		contentPane.add(textField_Name);

		textField_BirthDay = new JTextField();
		textField_BirthDay.setColumns(10);
		textField_BirthDay.setBounds(98, 376, 125, 20);
		contentPane.add(textField_BirthDay);

		JLabel lblNewLabel_1_4 = new JLabel("Giới Tính");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(233, 272, 58, 32);
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_1_1 = new JLabel("Môn 1");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(243, 304, 58, 32);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("Môn 2");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(243, 336, 78, 32);
		contentPane.add(lblNewLabel_1_2_1);

		textField_Mon2 = new JTextField();
		textField_Mon2.setColumns(10);
		textField_Mon2.setBounds(300, 344, 117, 20);
		contentPane.add(textField_Mon2);

		textField_Mon1 = new JTextField();
		textField_Mon1.setColumns(10);
		textField_Mon1.setBounds(300, 312, 117, 20);
		contentPane.add(textField_Mon1);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Môn 3");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(243, 368, 78, 32);
		contentPane.add(lblNewLabel_1_2_1_1);

		textField_Mon3 = new JTextField();
		textField_Mon3.setColumns(10);
		textField_Mon3.setBounds(300, 376, 117, 20);
		contentPane.add(textField_Mon3);

		rdbtnNewRadioButton = new JRadioButton("Female");
		rdbtnNewRadioButton.setBounds(353, 279, 66, 23);
		rdbtnNewRadioButton_1 = new JRadioButton("Male");
		rdbtnNewRadioButton_1.setBounds(300, 279, 48, 23);
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton_1);
		contentPane.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton_1);

		modelThiSinh = new ThiSinh();

		JPanel panel = new JPanel();
		panel.setBounds(434, 270, 140, 152);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(3, 2, 2, 2));

		JButton btnNewButton_4 = new JButton("Thêm");
		btnNewButton_4.addActionListener(actionListener);
		panel.add(btnNewButton_4);

		JButton btnNewButton_1 = new JButton("Xóa");
		btnNewButton_1.addActionListener(actionListener);
		panel.add(btnNewButton_1);

		JButton btnNewButton_5 = new JButton("Sửa");
		btnNewButton_5.addActionListener(actionListener);
		panel.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Lưu");
		btnNewButton_6.addActionListener(actionListener);
		panel.add(btnNewButton_6);

		JButton btnNewButton_3 = new JButton("Hủy");
		btnNewButton_3.addActionListener(actionListener);
		panel.add(btnNewButton_3);

		JButton btnNewButton_Tim = new JButton("Tìm");
		btnNewButton_Tim.addActionListener(actionListener);
		btnNewButton_Tim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_Tim.setBounds(387, 42, 78, 23);
		contentPane.add(btnNewButton_Tim);

		JButton btnNewButton_BoTim = new JButton("Bỏ Tìm");
		btnNewButton_BoTim.addActionListener(actionListener);

		btnNewButton_BoTim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_BoTim.setBounds(475, 42, 99, 23);
		contentPane.add(btnNewButton_BoTim);

		this.setVisible(true);
	}

	public void xoaForm() {
		textField_ID.setText("");
		textField_Name.setText("");
		textField_BirthDay.setText("");
		textField_Mon1.setText("");
		textField_Mon2.setText("");
		textField_Mon3.setText("");
		comboBox_BirthPlace.setSelectedIndex(0);
		buttonGroup.clearSelection();
	}

	public ThiSinh getThiSinhVuaNhap() {
		ThiSinh thiSinhVuaNhap = new ThiSinh();
		try {
			int ID = Integer.valueOf(textField_ID.getText());
			String Name = textField_Name.getText();
			DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
			Date BirthDay = df.parse(textField_BirthDay.getText());
			int BirthPlace = comboBox_BirthPlace.getSelectedIndex();
			Tinh QueQuan = Tinh.getTinhByID(BirthPlace);
			Boolean Sex = false;
			Enumeration buttons = buttonGroup.getElements();
			while (buttons.hasMoreElements()) {
				AbstractButton button = (AbstractButton) buttons.nextElement();
				if (button.isSelected()) {
					if (button.getText().equals("Male")) {
						Sex = true;
					}
				}
			}
			float Mon2 = Float.valueOf(textField_Mon2.getText());
			float Mon1 = Float.valueOf(textField_Mon1.getText());
			float Mon3 = Float.valueOf(textField_Mon3.getText());
			thiSinhVuaNhap.setMaThiSinh(ID);
			thiSinhVuaNhap.setGioiTinh(Sex);
			thiSinhVuaNhap.setQueQuan(QueQuan);
			thiSinhVuaNhap.setTenThiSinh(Name);
			thiSinhVuaNhap.setNgaySinh(BirthDay);
			thiSinhVuaNhap.setDiemMon1(Mon1);
			thiSinhVuaNhap.setDiemMon2(Mon2);
			thiSinhVuaNhap.setDiemMon3(Mon3);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return thiSinhVuaNhap;
	}

	public void ThemHoacSua() {
		ThiSinh thiSinhVuaNhap = getThiSinhVuaNhap();

		if (!model.kiemTraTonTai(thiSinhVuaNhap)) {

			DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
			Object[] row = { thiSinhVuaNhap.getMaThiSinh(), thiSinhVuaNhap.getTenThiSinh(),
					thiSinhVuaNhap.getQueQuan().getTenTinh(), df.format(thiSinhVuaNhap.getNgaySinh()),
					thiSinhVuaNhap.isGioiTinh(), thiSinhVuaNhap.getDiemMon1(), thiSinhVuaNhap.getDiemMon2(),
					thiSinhVuaNhap.getDiemMon3() };
			DefaultTableModel modelOfTable = (DefaultTableModel) table.getModel();
			modelOfTable.addRow(row);
			model.insert(thiSinhVuaNhap);
		} else {
			ThiSinh thiSinhDangChon = getThiSinhDangChon();
			model.delete(thiSinhDangChon);
			model.insert(thiSinhVuaNhap);
			int soLuongDong = table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = thiSinhVuaNhap.getMaThiSinh() + "";
				if (id.equals(table.getValueAt(i, 0) + "")) {
					DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
					table.setValueAt(thiSinhVuaNhap.getMaThiSinh(), i, 0);
					table.setValueAt(thiSinhVuaNhap.getTenThiSinh(), i, 1);
					table.setValueAt(thiSinhVuaNhap.getQueQuan().getTenTinh(), i, 2);
					table.setValueAt(df.format(thiSinhVuaNhap.getNgaySinh()), i, 3);
					table.setValueAt(thiSinhVuaNhap.isGioiTinh(), i, 4);
					table.setValueAt(thiSinhVuaNhap.getDiemMon1(), i, 5);
					table.setValueAt(thiSinhVuaNhap.getDiemMon2(), i, 6);
					table.setValueAt(thiSinhVuaNhap.getDiemMon3(), i, 7);
				}
			}
		}
	}

	public void showInfoThiSinh() {
		DefaultTableModel modelOfTable = (DefaultTableModel) table.getModel();
		int iRow = table.getSelectedRow();

		int ID = Integer.valueOf(modelOfTable.getValueAt(iRow, 0) + "");
		String Name = String.valueOf(modelOfTable.getValueAt(iRow, 1));
		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		Date BirthDay = null;
		try {
			BirthDay = df.parse(modelOfTable.getValueAt(iRow, 3) + "");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Tinh QueQuan = Tinh.getTinhByTen((String) modelOfTable.getValueAt(iRow, 2));
		Boolean Sex = modelOfTable.getValueAt(iRow, 4).equals("Male");
		float Mon1 = (float) modelOfTable.getValueAt(iRow, 5);
		float Mon2 = (float) modelOfTable.getValueAt(iRow, 6);
		float Mon3 = (float) modelOfTable.getValueAt(iRow, 7);
		DateFormat df1 = new SimpleDateFormat("mm/dd/yyyy");

		textField_ID.setText(ID + "");
		textField_Name.setText(Name + "");
		textField_BirthDay.setText(df1.format(BirthDay) + "");
		textField_Mon1.setText(Mon1 + "");
		textField_Mon2.setText(Mon2 + "");
		textField_Mon3.setText(Mon3 + "");
		comboBox_BirthPlace.setSelectedIndex(QueQuan.getMaTinh());
		if (Sex == true) {
			rdbtnNewRadioButton_1.setSelected(true);
		} else {
			rdbtnNewRadioButton.setSelected(true);
		}
	}

	public void XoaTS() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int iRow = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn thật sự muốn Xóa thí sinh này ?");
		if (luaChon == JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDangChon();
			tableModel.removeRow(iRow);
			model.delete(ts);
		}
	}

	private ThiSinh getThiSinhDangChon() {
		DefaultTableModel modelOfTable = (DefaultTableModel) table.getModel();
		int iRow = table.getSelectedRow();
		int ID = Integer.valueOf(modelOfTable.getValueAt(iRow, 0) + "");
		String Name = String.valueOf(modelOfTable.getValueAt(iRow, 1));
		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		Date BirthDay = null;
		try {
			BirthDay = df.parse(modelOfTable.getValueAt(iRow, 3) + "");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Tinh QueQuan = Tinh.getTinhByTen((String) modelOfTable.getValueAt(iRow, 2));
		Boolean Sex = modelOfTable.getValueAt(iRow, 4).equals("Male");
		float Mon1 = (float) modelOfTable.getValueAt(iRow, 5);
		float Mon2 = (float) modelOfTable.getValueAt(iRow, 6);
		float Mon3 = (float) modelOfTable.getValueAt(iRow, 7);
		return new ThiSinh(ID, Name, QueQuan, BirthDay, Sex, Mon1, Mon2, Mon3);
	}

	public void ShowDanhSachThiSinh(ArrayList<ThiSinh> list) {
		DefaultTableModel modelOfTable = (DefaultTableModel) table.getModel();
		while (modelOfTable.getRowCount() > 0) {
			modelOfTable.removeRow(0);
		}
		for (ThiSinh thiSinh : list) {
			DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
			Object[] row = { thiSinh.getMaThiSinh(), thiSinh.getTenThiSinh(), thiSinh.getQueQuan().getTenTinh(),
					df.format(thiSinh.getNgaySinh()), thiSinh.isGioiTinh(), thiSinh.getDiemMon1(),
					thiSinh.getDiemMon2(), thiSinh.getDiemMon3() };
			modelOfTable.addRow(row);
		}
	}

	public void ShowThiSinh(ThiSinh thiSinh) {
		DefaultTableModel modelOfTable = (DefaultTableModel) table.getModel();
		while (modelOfTable.getRowCount() > 0) {
			modelOfTable.removeRow(0);
		}
		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		Object[] row = { thiSinh.getMaThiSinh(), thiSinh.getTenThiSinh(), thiSinh.getQueQuan().getTenTinh(),
				df.format(thiSinh.getNgaySinh()), thiSinh.isGioiTinh(), thiSinh.getDiemMon1(), thiSinh.getDiemMon2(),
				thiSinh.getDiemMon3() };
		modelOfTable.addRow(row);
	}

	public ThiSinh timKiemThiSinhByID() {
		int ID = Integer.valueOf(textField_1.getText());
		return model.getThiSinhByID(ID);
	}

	public ArrayList<ThiSinh> timKiemThiSinhByQueQuan() {
		int BirthPlace = comboBox.getSelectedIndex();
		Tinh QueQuan = Tinh.getTinhByID(BirthPlace);
		return model.getListThiSinhByQueQuan(QueQuan);
	}

	public ThiSinh timKiemThiSinhByIDvaQueQuan() {
		int BirthPlace = comboBox.getSelectedIndex();
		Tinh QueQuan = Tinh.getTinhByID(BirthPlace);
		ArrayList<ThiSinh> listTSQueQuan = model.getListThiSinhByQueQuan(QueQuan);
		int ID = Integer.valueOf(textField_1.getText());
		for (ThiSinh thiSinh : listTSQueQuan) {
			if (ID == thiSinh.getMaThiSinh())
				return thiSinh;
		}
		return null;
	}

	public void SaveDSThiSinh(ArrayList<ThiSinh> dsThiSinh) {
		if (!dsThiSinh.isEmpty()) {
			try {
				FileOutputStream fos = new FileOutputStream("studentdata.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(dsThiSinh);
				oos.flush();
				oos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void OpenDSThiSinh(String selectedFilePath) {
		if (selectedFilePath.endsWith(".txt")) {
			try {
				FileInputStream readData = new FileInputStream(selectedFilePath);
				ObjectInputStream readStream = new ObjectInputStream(readData);

				ArrayList<ThiSinh> dsThiSinh = (ArrayList<ThiSinh>) readStream.readObject();
				model.setDsThiSinh(dsThiSinh);
				readStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			ShowDanhSachThiSinh(model.getDsThiSinh());
		}else {
			JOptionPane.showMessageDialog(this, "Chỉ open được file .txt ", "Error" ,JOptionPane.ERROR_MESSAGE);
		}
	}
}
