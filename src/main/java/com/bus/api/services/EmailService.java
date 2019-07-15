/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
package com.bus.api.services;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    static void sendMail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       @Autowired
    private JavaMailSender emailSender;

    private MimeMessage message;


    public void sendMail(String emailMessage, String fromMail, String toMail, boolean isHtml) throws MessagingException, IOException {
        message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

       

        //html = html.replace("${link}", (String) mail.getModel().get("verify"));
        helper.setTo(toMail);
        helper.setText(emailMessage, isHtml);
        helper.setSubject("Hackathorn mail enquiry");
        helper.setFrom(fromMail);
        
         emailSender.send(message);

    }

    
}
