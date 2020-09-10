package com.mall.java.thread;

public class Test2 {

    public static void main(String[] args) {

        TicketImpl ticket = new TicketImpl();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
    }
}
