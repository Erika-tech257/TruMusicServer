package com.example.MusicApp.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public ApplicationSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    /**
     * antMatchers with HttpMethods reference @PreAuthorize in Admin and Customer Controllers
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .sessionManagement()
//                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .addFilter(new JwtUsernameAndPasswordFilter(authenticationManager(), jwtConfig, secretKey))
//                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtUsernameAndPasswordFilter.class)
//                .authorizeRequests()
//                .antMatchers("/", "index").permitAll()
//                .antMatchers("/LoveMusic/**").hasRole(CUSTOMER.name())
////                .antMatchers(HttpMethod.DELETE,"/admin/LoveMusic/**").hasAuthority(ApplicationUserPermission.MUSIC_WRITE.getPermission())
////                .antMatchers(HttpMethod.POST,"/admin/LoveMusic/**").hasAuthority(ApplicationUserPermission.MUSIC_WRITE.getPermission())
////                .antMatchers(HttpMethod.PUT,"/admin/LoveMusic/**").hasAuthority(ApplicationUserPermission.MUSIC_WRITE.getPermission())
//                .antMatchers(HttpMethod.GET,"/admin/LoveMusic/**").hasAnyRole(ADMIN.name())
//                .anyRequest()
//                .authenticated();
//

    }


}
