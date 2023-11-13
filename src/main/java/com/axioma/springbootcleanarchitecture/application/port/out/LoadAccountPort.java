package com.axioma.springbootcleanarchitecture.application.port.out;

import com.axioma.springbootcleanarchitecture.domain.Account;

public interface LoadAccountPort {
    Account load(Long id);
}
