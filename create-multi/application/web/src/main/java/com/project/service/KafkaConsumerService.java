package com.project.service;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class KafkaConsumerService implements MailService{
    // MailConfig에서 등록해둔 Bean을 autowired하여 사용하기
    private final JavaMailSender emailSender;
    @Value("${spring.mail.username}")
    private String username;

    @KafkaListener(topics = "application-delivery", groupId = "consumer_group_myProject")
    public void listen(@Payload String message) {
        log.info("소비하는 메시지:{}", message);
        try {
            // 실제 사용자 이메일을 여기에 전달해야 한다. 지금 예제는 본인 이메일로 고정
            sendSimpleMessage(username, message);
        } catch (Exception e) {
            log.error("메일 발송에 실패 했습니다.", e);
        }
    }
    // 메일 발송
    // sendSimpleMessage 의 매개변수 to는 이메일 주소가 되고,
    // MimeMessage 객체 안에 내가 전송할 메일의 내용을 담는다
    // bean으로 등록해둔 javaMail 객체를 사용하여 이메일을 발송한다
    @Override
    public void sendSimpleMessage(String to, String messageText) throws Exception {
        MimeMessage message = createMessage(to, messageText);
        try {
            //메일로 보내주는 메소드
            emailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }


    private MimeMessage createMessage(String to, String messageText) throws MessagingException {
        log.info("메일받을 사용자 : " + to);
        MimeMessage message = emailSender.createMimeMessage();
        message.addRecipients(Message.RecipientType.TO, to);
        // 이메일 제목
        message.setSubject("배송 정보입니다.");
        message.setText(messageText,"utf-8","html");
        message.setFrom(username);

        log.info("생성된 message:{}", messageText);

        return message;
    }

}
