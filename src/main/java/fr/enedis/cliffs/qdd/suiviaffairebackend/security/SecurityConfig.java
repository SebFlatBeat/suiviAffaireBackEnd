package fr.enedis.cliffs.qdd.suiviaffairebackend.security;

import fr.enedis.cliffs.qdd.suiviaffairebackend.service.UserAppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);

    private static final String INDEX = "/index";

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new UserAppService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);
        LOG.trace("User authentification");
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOG.debug("Configuration HttpSecurity");
        http.csrf().disable();
        http.httpBasic()
                .and()
                .authorizeRequests().antMatchers("/", INDEX, "/register", "/user", "/analyse", "/filter", "/synthese", "/blocage", "/getFiles").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage(INDEX)
                .loginProcessingUrl("/login")
                .failureUrl("/login?error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl(INDEX)
                .invalidateHttpSession(true).deleteCookies("JSESSIONID");
        LOG.trace("HttpSecurity configuration OK");
    }
}
