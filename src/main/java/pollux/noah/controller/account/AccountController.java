package pollux.noah.controller.account;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pollux.noah.domain.account.UserEntity;
import pollux.noah.domain.account.UserRepository;

@Controller
public class AccountController {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @GetMapping("/login")
    public String loginPage(){
        return "account/login";
    }


    @GetMapping("/")
    public String indexPage(){
        return "index";
    }
    
    @GetMapping("/main")
    public String mainPage(){
        return "main";
    }

    @GetMapping("/signup")
    public String signUp(){
        UserEntity user = UserEntity.builder()
            .username("test")
            .email("test@test.com")
            .pw(passwordEncoder.encode("test"))
            .role("visitor")
            .regTs(new Timestamp(System.currentTimeMillis()))
            .regIp("127.0.0.1")
            .build();
        userRepository.save(user);

        return "index";
    }
}
