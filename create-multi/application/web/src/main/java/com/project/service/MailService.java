package com.project.service;

public interface MailService {
    //메일 발송
    void sendSimpleMessage(String to,String messageText)throws Exception;
}
