package com.taihui.springboot.activemq.data;

public class SendData<T> {

    private String destination;//消息发送目的地
    private T data; //消息发送的数据，使用T 泛型接收
    private String sendType;//消息发送的类型

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    private enum Action{
        Add,Delete,Update
    }

    public SendData(String destination,Action type){
        this.destination = destination;
        this.sendType = type.values().toString();
    }



}