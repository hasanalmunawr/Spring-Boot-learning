package hasanalmunawrDev.UserDetailManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class UserConfiguration {

//    private Map<String, String> manager = Map.of(
//            "hasan", passwordEncoder().encode("hasan123"),
//            "deva", passwordEncoder().encode("deva123")
//    );
//    private Map<String, String> admin = Map.of(
//            "almu", passwordEncoder().encode("almu123"),
//            "kayla", passwordEncoder().encode("kayla123")
//    );



    //    @Bean
//    public InMemoryUserDetailsManager user() {
//        return new InMemoryUserDetailsManager(
//                User.withUsername("hasan")
//                        .password(passwordEncoder().encode("rahasia"))
//                        .authorities("ROLE_MANAGER")
//                        .build()
//        );
//    }

    @Bean
    EmbeddedDatabase embeddedDatabase() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("hasanalmu")
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
                .build();
    }

    @Bean
    JdbcUserDetailsManager detailsManager(DataSource dataSource) {

         // method for set up acces of manager or admin
        UserDetails manager = User.builder()
                .username("hasan")
                .password(passwordEncoder().encode("hasan123"))
                .roles("MANAGER")
                .build();
        UserDetails admin = User.builder()
                .username("deva")
                .password(passwordEncoder().encode("deva123"))
                .roles("ADMIN")
                .build();

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.createUser(admin);
        userDetailsManager.createUser(manager);
        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
