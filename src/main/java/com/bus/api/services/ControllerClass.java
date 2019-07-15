/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bus.api.services;

import java.io.IOException;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/v1")
public class ControllerClass {
     @Autowired 
     private EmailService emailSender;
     
     @ResponseBody
     @PostMapping("/send")
   public ResponseEntity sendEmail(@RequestBody Email emailRequest)throws MessagingException, IOException {
      emailSender.sendMail(emailRequest.getMailMessage(), emailRequest.getMailFrom(), emailRequest.getMailTo(), false);
      return ResponseEntity.ok().body("success muther fucker");
   }
   private class Email{
        private String MailTo;
        private String MailFrom;
        private String MailSubject;
        private String MailMessage;

        /**
         * @return the MailTo
         */
        public String getMailTo() {
            return MailTo;
        }

        /**
         * @param MailTo the MailTo to set
         */
        public void setMailTo(String MailTo) {
            this.MailTo = MailTo;
        }

        /**
         * @return the MailFrom
         */
        public String getMailFrom() {
            return MailFrom;
        }

        /**
         * @param MailFrom the MailFrom to set
         */
        public void setMailFrom(String MailFrom) {
            this.MailFrom = MailFrom;
        }

        /**
         * @return the MailSubject
         */
        public String getMailSubject() {
            return MailSubject;
        }

        /**
         * @param MailSubject the MailSubject to set
         */
        public void setMailSubject(String MailSubject) {
            this.MailSubject = MailSubject;
        }

        /**
         * @return the MailMessage
         */
        public String getMailMessage() {
            return MailMessage;
        }

        /**
         * @param MailMessage the MailMessage to set
         */
        public void setMailMessage(String MailMessage) {
            this.MailMessage = MailMessage;
        }
       
       
   }
}
    