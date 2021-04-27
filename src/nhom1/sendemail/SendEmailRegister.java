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
			mess.setSubject("Xác Thực Tài Khoản Flash");
			mess.setText("Chào mừng bạn đến với Flash, hãy nhấn vào link bên dưới để xác minh tài khoản\n"
					+ "Link: http://localhost:8080/Flash/ActiveEmail?user="+email+"&active="+token);
			Transport.send(mess);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println("huan");
			
		}
	}
	public void sendEmailPass(HttpServletRequest request, HttpServletResponse response,String email,String token) {
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
			mess.setSubject("Link Thay Đổi Mật Khẩu");
			mess.setText("Chào mừng bạn đến với Flash.\n"
					+ "Nhấn vào link để cập nhật lại mật khẩu :\n"
					+ "Link: http://localhost:8080/Flash/UpdatePass?email="+email+"&token="+token+"\n"
					+ "Hãy ghi nhớ lại mật khẩu của bạn để tiếp tục sử dụng dịch vụ.");
			Transport.send(mess);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println("huan");
			
		}
	}
}
