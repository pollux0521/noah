package pollux.noah.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pollux.noah.domain.account.UserEntity;
import pollux.noah.domain.account.UserRepository;

// 2022.04.11 : UserError 해결하기

@Service
public class noahLoginService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(Email).orElseThrow(()->new IllegalArgumentException("존재하지 않는 유저입니다."));

        return user;
    }
    
}
