package com.axioma.springbootcleanarchitecture.adapter.in_web;

import com.axioma.springbootcleanarchitecture.application.port.in.SendMoneyCommand;
import com.axioma.springbootcleanarchitecture.application.port.in.SendMoneyPort;
import com.axioma.springbootcleanarchitecture.common.WebAdapter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@WebAdapter
@RestController
public class MoneyTransferController {

    private final SendMoneyPort sendMoneyPort;

    public MoneyTransferController(SendMoneyPort sendMoneyPort) {
        this.sendMoneyPort = sendMoneyPort;
    }

    @PostMapping(path = "/accounts/transfer/{sourceAccountId}/{targetAccountId}/{amount}")
    void transfer(
            @PathVariable("sourceAccountId") Long sourceAccountId,
            @PathVariable("targetAccountId") Long targetAccountId,
            @PathVariable("amount") BigDecimal amount) {

        SendMoneyCommand command = new SendMoneyCommand(
                sourceAccountId,
                targetAccountId,
                amount);

        sendMoneyPort.send(command);
    }


}
