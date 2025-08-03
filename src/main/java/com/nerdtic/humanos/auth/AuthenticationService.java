package com.nerdtic.humanos.auth;


import com.nerdtic.humanos.contrat.ContratRepository;
import com.nerdtic.humanos.email.EmailService;
import com.nerdtic.humanos.email.EmailTemplateName;
import com.nerdtic.humanos.departement.DepartementRepository;
import com.nerdtic.humanos.formation.Formation;
import com.nerdtic.humanos.formation.FormationRepository;
import com.nerdtic.humanos.security.role.RoleUtilisateurRepository;
import com.nerdtic.humanos.security.user.Token;
import com.nerdtic.humanos.security.user.TokenRepository;
import com.nerdtic.humanos.security.user.User;
import com.nerdtic.humanos.security.user.UserRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final RoleUtilisateurRepository roleUtilisateurRepository;
    private final DepartementRepository departementRepository;
    private final FormationRepository formationRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final EmailService emailService;
    @Value("${application.mailing.frontend.activation-url}")
    private String activationUrl;



    public void register(RegistrationRequest request) throws MessagingException {
        var userRole = roleUtilisateurRepository.findById(
                request.getRoleId()
        ).orElseThrow(() -> new RuntimeException("ROLE USER was not initialized"));

        List<Formation> userFormations = new ArrayList<>();

        var departement = departementRepository.findById(
                request.getDepartementId()
        ).orElseThrow(() -> new RuntimeException("USER Departement was not initialized"));




        if (request.getFormationId() != null){
            var formation = formationRepository.findById(
                    request.getFormationId()
            ).orElseThrow(() -> new RuntimeException("Formation was not initialized"));
            userFormations.add(formation);
        }
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountLocked(false)
                .enabled(false)
                .formations(userFormations)
                .departement(departement)
                .userRoles(List.of(userRole))
                .build();
        userRepository.save(user);
        sendValidationEmail(user);
    }

    private void sendValidationEmail(User user) throws MessagingException {
        var newToken = generateAndSendActivationToken(user);
        emailService.sendEmail(
                user.getEmail(),
                user.fullName(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                activationUrl,
                newToken,
                "Account Activation"
        );
    }

    private String generateAndSendActivationToken(User user) {
        //generate Token
        String generatedToken = generateActivationCode(4);
        var token = Token.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiredAt(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();
        tokenRepository.save(token);
        return generatedToken;
    }

    private String generateActivationCode(int length) {
        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < length; i++){
            int randomIndex = secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randomIndex));
        }
        return codeBuilder.toString();
    }


}
