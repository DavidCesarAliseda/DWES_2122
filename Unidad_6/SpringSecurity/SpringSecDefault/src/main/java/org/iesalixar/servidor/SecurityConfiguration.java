package org.iesalixar.servidor;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 * CLASE DONDE ESTABLECEREMOS LA CONFIGURACION DE
 * AUTENTIFICACION - CÓMO ACCEDO
 * AUTORIZACION - A QUÉ PUEDO ACCEDER
 * MÉTODO DE ENCRIPTACIÓN DE LAS CONTRASEÑAS
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	
	
	/*
	 * MÉTODO PARA ESTABLECER AUTORIZACION - A QUÉ PUEDO ACCEDER
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/* URL con información sobre ANT MATCHERS
		 * https://www.baeldung.com/spring-security-expressions */
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/products","/about","/services").authenticated()
		.and()
		.formLogin();
		
	}

	
}
