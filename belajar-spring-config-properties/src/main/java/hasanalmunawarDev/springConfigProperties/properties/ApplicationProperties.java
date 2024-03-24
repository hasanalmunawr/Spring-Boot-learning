package hasanalmunawarDev.springConfigProperties.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties("application")
public class ApplicationProperties {

    private Date expireDate;

    private Duration defaultTimeOut;

    private String name;

    private Integer version;

    private boolean productionMode;

    private DatabaseProperties database;

    private Role role;

    private List<Role> defaultRoles;

    private Map<String, Role> roles;

    @Getter
    @Setter
    public static class DatabaseProperties {

        private String username;

        private String password;

        private String database;

        private String url;

        private List<String> whitelistTables;

        private Map<String, Integer> maxTablesSize;

    }

    @Data
    public static class Role{

        private String id;

        private String name;
    }

}