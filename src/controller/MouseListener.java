package controller;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import view.QLSVView;

public class MouseListener implements java.awt.event.MouseListener{
	QLSVView qlsvView;

	public MouseListener(QLSVView qlsvView) {
		this.qlsvView = qlsvView;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int counting = this.qlsvView.counting;
		counting++;
		int[] alert = {1,7,14,30};
		int i = this.qlsvView.iAlert;
		if(counting==alert[i]) {
		JOptionPane.showMessageDialog( this.qlsvView, "Bạn có thể chọn thí sinh ở đây\nNhưng hãy nhập thông tin ở dưới để tránh lỗi nhé ^^.","Cảnh Báo", JOptionPane.ERROR_MESSAGE);
		i++;
		}
		this.qlsvView.counting = counting;
		this.qlsvView.iAlert=i;
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
