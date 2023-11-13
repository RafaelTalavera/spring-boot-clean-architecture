package com.axioma.springbootcleanarchitecture.adapter.out_persistence;

import com.axioma.springbootcleanarchitecture.application.port.out.LoadAccountPort;
import com.axioma.springbootcleanarchitecture.application.port.out.UpdateAccountPort;
import com.axioma.springbootcleanarchitecture.common.PersistenceAdapter;
import com.axioma.springbootcleanarchitecture.domain.Account;

@PersistenceAdapter
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountPort {

    private final SpringAccountRepository accountRepository;

    public AccountPersistenceAdapter(SpringAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account load(Long id) {
        return accountRepository
                .findById(id)
                .map(AccountMapper::entityToDomain)
                .orElseThrow(RuntimeException::new); // mejorar exception
    }

    @Override
    public void update(Account account) {
        accountRepository.save(AccountMapper.domainToEntity(account));
    }
}