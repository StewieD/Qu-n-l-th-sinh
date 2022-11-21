package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.ThiSinh;
import model.Tinh;
import view.QLSVView;

public class QLTSController implements ActionListener {
	QLSVView qlsvView;

	public QLTSController(QLSVView qlsvView) {
		this.qlsvView = qlsvView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if(cm.equals("Thêm")) {
			this.qlsvView.xoaForm();
		}else if(cm.equals("Lưu")) {
			this.qlsvView.ThemHoacSua();
		}else if(cm.equals("Sửa")) {
			this.qlsvView.showInfoThiSinh();
		}else if(cm.equals("Xóa")) {
			this.qlsvView.XoaTS();
		}else if(cm.equals("Hủy")) {
			this.qlsvView.xoaForm();
		}else if(cm.equals("Tìm")) {
			if(this.qlsvView.comboBox.getSelectedIndex() == 0) {
				ThiSinh ts = this.qlsvView.timKiemThiSinhByID();
				this.qlsvView.ShowThiSinh(ts);
			}else if(this.qlsvView.textField_1.getText().equals("")) {
			ArrayList<ThiSinh> listTS = this.qlsvView.timKiemThiSinhByQueQuan();
			this.qlsvView.ShowDanhSachThiSinh(listTS);
			}else if(!this.qlsvView.textField_1.getText().equals("")&&this.qlsvView.comboBox.getSelectedIndex() != 0) {
				ThiSinh ts = this.qlsvView.timKiemThiSinhByIDvaQueQuan();
				this.qlsvView.ShowThiSinh(ts);
			}
		}else if(cm.equals("Bỏ Tìm")) {
			this.qlsvView.ShowDanhSachThiSinh(this.qlsvView.model.getDsThiSinh());
		}else if(cm.equals("Save ...")) {
			this.qlsvView.SaveDSThiSinh(this.qlsvView.model.getDsThiSinh());
		}else if(cm.equals("Open ...")) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("C:\\Users\\vudan\\Desktop"));
			int result = fileChooser.showOpenDialog(this.qlsvView);
			if(result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				String selectedFilePath = selectedFile.getAbsolutePath();
				this.qlsvView.OpenDSThiSinh(selectedFilePath);}
		}else if(cm.equals("Exit ...")) {
			System.exit(0);
		}else if(cm.equals("About me")) {
			JOptionPane.showMessageDialog(this.qlsvView, "Application Student Management\n"+"By Stewie", "About me" ,JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
