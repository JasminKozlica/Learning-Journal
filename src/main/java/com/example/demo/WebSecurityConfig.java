package com.example.demo;

import com.example.demo.indexSite.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

     @Autowired
    private UserRepository userRepository;

     @Autowired
     private CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        http.cors().and().csrf().disable(); //wird gebraucht für postman: https://www.postman.com/

        // die Reihenfolge der folgenden Zeilen innerhalb von authorizeHttpRequests ist sehr wichtig. Was zuerst kommt, wird nicht mehr überschrieben. D.h. wenn man in der ersten Zeile den Zugang zu bestimmten Seiten ermöglicht oder verbietet, dann wird das keine der kommenden Zeilen mehr ändern können.
        http.authorizeHttpRequests((requests) -> requests
                .anyRequest().authenticated() // der Pfad "/welcome" ist für alle erlaubt, auch für nicht-eingeloggte User
//                .requestMatchers("/users/**").hasRole("ADMIN") // alle Pfade, die mit "/manage" anfangen, sind nur für User mit Rolle "ADMIN" erreichbar
//                .requestMatchers("/manage/**").hasAnyRole("ADMIN", "TEACHER") // alle Pfade, die mit "/manage" anfangen, sind nur für User mit Rolle "ADMIN" oder "TEACHER" erreichbar
        );

        // erstellt eine Standard-Login-Seite (im Bootstrap-Design) unter dem Pfad "/login" und leitet nicht-eingeloggte User, die sich einloggen müssen, automatisch dorthin. Außerdem hat diese Seite eine rote Meldung bei fehlgeschlagenen Logins. Zusätzlich gibt es durch diese Zeile unter dem Pfad "/logout" eine Seite mit einem Knopf zum ausloggen. Vorsicht!: dieser Logout-Knopf leitet zwar wieder zu "/login", aber der User ist noch nicht wirklich ausgeloggt. Für diese Funktionalität braucht man noch die Zeile http.logout(configurer -> configurer.invalidateHttpSession(true));
        http.formLogin(Customizer.withDefaults());

        // // verwende stattdessen diese Zeile, zu der der User redirected wird, um eine eigene Login-Seite anzuzeigen, mit weiter einstellbarem Verhalten (zwei Vorschläge exemplarisch eingefügt). Die Seite sollte über den hier gewählten Pfad erreichbar sein. Dort sollte es eine Möglichkeit für den User geben, per POST "/login" den Usernamen und das Passwort abzuschicken, wie zB in der Standard-Login-Seite. Im RequestBody sollte dann sein: { username: "...", password: "..." }
        // http.formLogin((form) -> form
        //     .loginPage("/mein/login/pfad").permitAll()
        //     .defaultSuccessUrl("/pfad/nach/erfolgreichem/login") // hier wird der User nach erfolgreichem Login hingeschickt, wenn er nicht bereits versuchte, eine gesicherte Seite aufzurufen, zu der man ihn sinnvollerweise weiterleiten würde
        //     .failureUrl("/pfad/nach/fehlgeschlagenem/login") // default "/login?error"
        // );

        // hiermit wird der nicht-eingeloggte User über ein im Browser eingebautes Fenster zum Login (Username & Passwort) aufgefordert, falls die Zeile direkt hierüber fehlt (oder nicht funktioniert?) und auch sonst keine Login-Seite eingestellt wurde. Nach erfolgreichem Login landet man auf der gewünschten Seite, ansonsten wird die besuchte Seite komplett leer angezeigt.
        http.httpBasic(Customizer.withDefaults());

        // erstellt einen Endpunkt POST "/logout", durch dessen Aufruf der eingeloggte User ausgeloggt wird. Der Button auf der Standard-Logout-Seite (erzeugt zB durch http.formLogin(Customizer.withDefaults());) schickt genau diesen Request ab.
        http.logout(configurer -> configurer.invalidateHttpSession(true));

        return http.build();
    }

    // das brauchen wir auch noch, damit die Passwörter ordentlich gehasht werden beim Erstellen und beim Login
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
