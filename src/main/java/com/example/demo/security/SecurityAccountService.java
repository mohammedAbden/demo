package com.example.demo.security;

import com.example.demo.security.enums.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Set;

@Service
@AllArgsConstructor
public class SecurityAccountService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with username %s not found";

    private final SecurityAccountRepository securityAccountRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostConstruct
    public void addingUsers(){
        AppUser user1 = AppUser.builder()
                .userName("mostafa")
                .role(UserRole.SUPER_ADMIN)
                .password(bCryptPasswordEncoder.encode("mostafa"))
                .build();

        AppUser user2 = AppUser.builder()
                .userName("magdy")
                .role(UserRole.ADMIN)
                .password(bCryptPasswordEncoder.encode("magdy"))
                .build();

        securityAccountRepository.saveAll(Set.of(user1,user2));
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        return securityAccountRepository.findByUserName(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));
    }

}
