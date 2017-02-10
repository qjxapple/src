package com.dvd.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	 private JPanel panel_main = null;//主面板
	 private JPanel panel_left = null;//左面板
	 private JPanel panel_right = null;//右面板
	 private JLabel lb_uname = null;//用户名标签
	 private JLabel lb_upass = null;//密码标签
	 private JLabel lb_ukind = null;//登录类型标签
	 private JLabel lb_img = null;//显示图片的标签
	 private JTextField jf_name = null;//用户文本框
	 private JPasswordField jf_pass = null;//密码文本框
	 private JButton btn_login = null;//登录按钮
	 private JButton btn_regist = null;//注册按钮
	 private JComboBox<String> cb_kind = null;//登录类型下拉列表框
	 //初始化控件的方法
	 private void init() {
		 this.setSize(320,220);//设置窗体大小
		 this.setResizable(false);//窗体大小不可拖动
		 this.setVisible(true);//显示窗体
		this.setLocationRelativeTo(null); //设置居中
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认关闭窗体
		this.setTitle("登录窗口");//设置窗口的标题
	 }
	 //构造方法初始化控件
	 public LoginView() {
		 init();
	 }
	 
	 
}
