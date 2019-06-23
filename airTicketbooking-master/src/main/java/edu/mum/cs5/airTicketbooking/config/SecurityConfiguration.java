package edu.mum.cs5.airTicketbooking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;

	private final String USERS_QUERY = "select email, password, active from user where email=?";
	private final String ROLES_QUERY = "select u.email, r.role from user u inner join user_role ur on (u.id = ur.user_id) inner join role r on (ur.role_id=r.role_id) where u.email=?";

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery(USERS_QUERY).authoritiesByUsernameQuery(ROLES_QUERY)
				.dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests() .antMatchers("/").permitAll()
	 * //.antMatchers("/img/**").permitAll()
	 * 
	 * .antMatchers( "/resources/**").permitAll()
	 * 
	 * .antMatchers( "/customer/**").permitAll() .antMatchers(
	 * "/fragments/**").permitAll() .antMatchers( "/home/**").permitAll()
	 * .antMatchers( "/public/**").permitAll() .antMatchers(
	 * "/admin/**").permitAll() .antMatchers( "/user/**").permitAll()
	 * .antMatchers("/c").permitAll() .anyRequest().authenticated(); }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()

				.antMatchers("/admin/schueduleList", "/", "/list","/elibrary-web","/airport/list","edit/**",
						"delete/**","editCrew/**","deleteCrew/**","editairport/**", "deleteairport/**",
						"/newSchuedule","/editschuedule/**","/deleteschuedule/**").authenticated()
				.antMatchers("/login").permitAll().antMatchers("/signup").permitAll().antMatchers("/**").permitAll()
				// .antMatchers("/login").hasAuthority("ADMIN")
				.and().csrf().disable().formLogin().loginPage("/login").failureUrl("/login?error=true")
				.defaultSuccessUrl("/home/home").usernameParameter("email").passwordParameter("password").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
	}

		// .antMatchers("/admin/**").authenticated()
		/*
		 * .antMatchers( "/customer/**").permitAll() .antMatchers(
		 * "/fragments/**").permitAll() .antMatchers( "/home/**").permitAll()
		 * .antMatchers( "/public/**").permitAll() .antMatchers( "/user/**").permitAll()
		 */
		/*
		 * .antMatchers( "/resources/**").permitAll() .antMatchers("/").permitAll()
		 * .antMatchers("/login").permitAll() .antMatchers("/signup").permitAll()
		 * //.antMatchers("/admin/**").hasAuthority("ADMIN")
		 * .antMatchers("/login").hasAuthority("ADMIN")
		 * .anyRequest().authenticated().and().csrf().disable()
		 * 
		 * .formLogin().loginPage("/login") .failureUrl("/login?error=true")
		 * .defaultSuccessUrl("/home/home") .usernameParameter("email")
		 * .passwordParameter("password") .and().logout() .logoutRequestMatcher(new
		 * AntPathRequestMatcher("/logout")) .logoutSuccessUrl("/") .and().rememberMe()
		 * .tokenRepository(persistentTokenRepository()) .tokenValiditySeconds(60*60)
		 * .and().exceptionHandling().accessDeniedPage("/access_denied");
		 */
	

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);

		return db;
	}
}