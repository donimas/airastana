package kz.dkazi.airastana.controller;

import kz.dkazi.airastana.dto.CredentialsDTO;
import kz.dkazi.airastana.utils.JWTUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@AllArgsConstructor
@Slf4j
public class AuthController {

    private final JWTUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

//    @PostMapping("/authenticate")
    @RequestMapping(value = "/authenticate",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String generateToken(CredentialsDTO credentialsDTO) throws AuthenticationException {
        log.info("REST request to login user: {}", credentialsDTO.getUsername());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(credentialsDTO.getUsername(), credentialsDTO.getPassword())
            );
        } catch (Exception ex) {
            throw new AuthenticationException("inavalid username/password");
        }
        return jwtUtil.generateToken(credentialsDTO.getUsername());
    }

}
