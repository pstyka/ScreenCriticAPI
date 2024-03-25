package pawel.stringframework.screencriticapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pawel.stringframework.screencriticapi.auth.AuthenticationResponse;
import pawel.stringframework.screencriticapi.config.JwtService;
import pawel.stringframework.screencriticapi.entities.Role;
import pawel.stringframework.screencriticapi.entities.User;
import pawel.stringframework.screencriticapi.repositories.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

   private final UserRepository repository;
   private final PasswordEncoder passwordEncoder;
   private final JwtService jwtService;
   private final AuthenticationManager authenticationManager;

   public AuthenticationResponse register(User request){
       User user = User.builder()
               .firstName(request.getFirstName())
               .lastName(request.getLastName())
               .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole()) // mozliwy edit >>??<<

               .build();
    user = repository.save(user);

    String token = jwtService.generateToken(user);
    return new AuthenticationResponse(token);
   }

   public AuthenticationResponse authenticate(User request){
       authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                       request.getUsername(),
                       request.getPassword()
               )
       );
         User user = repository.findByUsername(request.getUsername()).orElseThrow();
         String token = jwtService.generateToken(user);
         return new AuthenticationResponse(token);
   }

}
