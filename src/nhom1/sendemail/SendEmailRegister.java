package nhom1.sendemail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SendEmailRegister {
	public void sendEmail(HttpServletRequest request, HttpServletResponse response,String email,String token) {
		final String username = "flashteam1998@gmail.com";
		final String pass = "Loc666666";
		Properties pop = new Properties(); 
		pop.put("mail.smtp.host", "smtp.gmail.com");
		pop.put("mail.smtp.port", "587");
		pop.put("mail.smtp.auth", "true");
		pop.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getInstance(pop, new Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username, pass);
			}
		});
		//
		
		try {
			Message mess = new MimeMessage(session);
			mess.setFrom(new InternetAddress(username));
			mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			mess.setSubject("XÁC THỰC EMAIL");
			mess.setText("Chào mừng bạn đến với Flash, xin hãy nhấn vào link dưới để xác nhận tài khoản\n"
					+ "Link: http://flash1.j.layershift.co.uk/ActiveEmail?user="+email+"&active="+token);
			Transport.send(mess);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println("huan");
			
		}
	}
	public void sendEmailPass(HttpServletRequest request, HttpServletResponse response,String email,String newPass) {
		final String username = "flashteam1998@gmail.com";
		final String pass = "Loc666666";
		Properties pop = new Properties(); 
		pop.put("mail.smtp.host", "smtp.gmail.com");
		pop.put("mail.smtp.port", "587");
		pop.put("mail.smtp.auth", "true");
		pop.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getInstance(pop, new Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username, pass);
			}
		});
		//
		
		try {
			Message mess = new MimeMessage(session);
			mess.setFrom(new InternetAddress(username));
			mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			mess.setSubject("MẬT KHẨU MỚI");
			mess.setText("Chào mừng bạn đến với Flash.\n"
					+ "		Mật khẩu mới của bạn hiện tại là:"+newPass+"\n"
					+ "		Hãy thay đổi mật khẩu trong phần cập nhật thông tin để tránh làm lộ thông tin tài khoản.");
			Transport.send(mess);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println("huan");
			
		}
	}
}
