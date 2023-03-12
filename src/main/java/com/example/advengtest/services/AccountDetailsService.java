package com.example.advengtest.services;

import com.example.advengtest.models.User;
import com.example.advengtest.repositories.AccountRepository;
import com.example.advengtest.security.AccountDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;

    public AccountDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> account = accountRepository.findByName(username);
        if(account.isEmpty()) throw new UsernameNotFoundException("NOT FOUND");

        return new AccountDetails(account.get());
    }
}
