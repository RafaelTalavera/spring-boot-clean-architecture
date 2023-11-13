package com.axioma.springbootcleanarchitecture.application.port.in;

public interface SendMoneyPort {
    public boolean send(SendMoneyCommand command);
}
