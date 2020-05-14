package com.nguyencongsy.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class SendMailService {
	@Autowired
    public JavaMailSender javaMailSender;
	private static String readLineByLineJava8(String filePath) 
	{
	    StringBuilder contentBuilder = new StringBuilder();
	    try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) 
	    {
	        stream.forEach(s -> contentBuilder.append(s));
	    }
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	    return contentBuilder.toString();
	}
	public String Get_TemPlate_SendMail(Boolean create , Boolean forgot, String username, String password)
	{
		String text_send = "";
		if(create == true)
		{
			String path = "C:/Users/NCSYVN/Documents/workspace-spring-tool-suite-4-4.5.1.RELEASE/Land/";
			String text1 = "";
			String text2 = "";
			String text3 = "";
			text1 =readLineByLineJava8(path+"TemplateMail/SetPassWord/Set1.txt"); 
			text2 = readLineByLineJava8(path+"TemplateMail/SetPassWord/Set2.txt");
			text3 = readLineByLineJava8(path+"TemplateMail/SetPassWord/Set3.txt");
			text_send= text1+ username + text2 + password + text3;
		}
		if(forgot == true)
		{
			String path = "C:/Users/NCSYVN/Documents/workspace-spring-tool-suite-4-4.5.1.RELEASE/Land/";
			String text1 = "";
			String text2 = "";
			String text3 = "";
			text1 =readLineByLineJava8(path+"TemplateMail/SetPassWord/Reset1.txt"); 
			text2 = readLineByLineJava8(path+"TemplateMail/SetPassWord/Reset2.txt");
			text3 = readLineByLineJava8(path+"TemplateMail/SetPassWord/Reset3.txt");
		    text_send = text1+ "ducdv" + text2 + "duc123" + text3;
		}
		return text_send;
	}
	public void sendEmail(String body, String to_MailAddress, String title) throws MessagingException, IOException {
		// sets SMTP server properties
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setTo(to_MailAddress);

        helper.setSubject(title);
        String path = "C:/Users/NCSYVN/Documents/workspace-spring-tool-suite-4-4.5.1.RELEASE/Land/";
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(body, "text/html;charset=UTF-8");
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        Map<String, String> mapInlineImages = new HashMap<String, String>();
        mapInlineImages.put("idBG", path+"Uploads/default/header-bg-1.png");
        mapInlineImages.put("idFB", path+"Uploads/default/fb-6.png");
        mapInlineImages.put("idTW", path+"Uploads/default/tw-6.png");
        mapInlineImages.put("idGG", path+"Uploads/default/gg-6.png");
        mapInlineImages.put("idBH", path+"Uploads/default/bh-6.png");
        mapInlineImages.put("idIN", path+"Uploads/default/in-6.png");
        mapInlineImages.put("idDB", path+"Uploads/default/db-6.png");
        // adds inline image attachments
        if (mapInlineImages != null && mapInlineImages.size() > 0) {
            Set<String> setImageID = mapInlineImages.keySet();
             
            for (String contentId : setImageID) {
                MimeBodyPart imagePart = new MimeBodyPart();
                imagePart.setHeader("Content-ID", "<" + contentId + ">");
                imagePart.setDisposition(MimeBodyPart.INLINE);
                 
                String imageFilePath = mapInlineImages.get(contentId);
                try {
                    imagePart.attachFile(imageFilePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
 
                multipart.addBodyPart(imagePart);
            }
        }
        msg.setContent(multipart);
        javaMailSender.send(msg);
    }
}
