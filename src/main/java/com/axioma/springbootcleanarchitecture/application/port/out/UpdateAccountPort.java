package com.axioma.springbootcleanarchitecture.application.port.out;

import com.axioma.springbootcleanarchitecture.domain.Account;

public interface UpdateAccountPort {

    void update(Account account);
}
