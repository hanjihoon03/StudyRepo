package com.example.socket.webSocket;

import lombok.Getter;

@Getter
public class Greeting {
    private String content;

    public Greeting(){

    }

    public Greeting(String content){this.content = content;}

    public String getContent(){return content;}
}
