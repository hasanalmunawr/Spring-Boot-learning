package hasanalmunawarDev.springConfigProperties.configProperties;

import hasanalmunawarDev.springConfigProperties.converter.StringToDateConverter;
import hasanalmunawarDev.springConfigProperties.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@SpringBootTest(classes = ConfigPropertiesTest.TestApplicationConfig.class)
public class ConfigPropertiesTest {
    
    @Autowired
    private ApplicationProperties properties;

    @Autowired
    private ConversionService conversionService;

    @Test
    void convertable() {
        Assertions.assertTrue(conversionService.canConvert(String.class, Duration.class));
        Assertions.assertEquals(Duration.ofSeconds(10), conversionService.convert("10s", Duration.class));
    }

//    @Test
//    void testConfigurableProperties() {
//        Assertions.assertEquals("Belajar Spring boot config", properties.getName());
//        Assertions.assertSame(1, properties.getVersion());
//        Assertions.assertFalse(properties.isProductionMode());
//
//    }

    @Test
    void testDatabaseProperties() {
        Assertions.assertEquals("hasan", properties.getDatabase().getUsername());
        Assertions.assertEquals("rahasia", properties.getDatabase().getPassword());
        Assertions.assertEquals("belajar", properties.getDatabase().getDatabase());
        Assertions.assertEquals("jdbc:contoh", properties.getDatabase().getUrl());
    }

    @Test
    void testCollection() {
        Assertions.assertEquals(Arrays.asList("customers", "products", "categories"), properties.getDatabase().getWhitelistTables());
        Assertions.assertEquals(100, properties.getDatabase().getMaxTablesSize().get("customers"));
        Assertions.assertEquals(100, properties.getDatabase().getMaxTablesSize().get("products"));
        Assertions.assertEquals(100, properties.getDatabase().getMaxTablesSize().get("categories"));
    }

    @Test
    void testEmebededCollectionList() {
        Assertions.assertEquals("default", properties.getDefaultRoles().get(0).getId());
        Assertions.assertEquals("Default Role", properties.getDefaultRoles().get(0).getName());
        Assertions.assertEquals("manager", properties.getDefaultRoles().get(1).getId());
        Assertions.assertEquals("Manager Role", properties.getDefaultRoles().get(1).getName());
    }

    @Test
    void testEmbededCollectionMap() {
        Assertions.assertEquals("admin", properties.getRoles().get("admin").getId());
        Assertions.assertEquals("Admin Role", properties.getRoles().get("admin").getName());
        Assertions.assertEquals("custom", properties.getRoles().get("custom").getId());
        Assertions.assertEquals("Custom Role", properties.getRoles().get("custom").getName());

    }

    @Test
    void testDuration() {
        Assertions.assertEquals(Duration.ofSeconds(10), properties.getDefaultTimeOut());
    }

    @Test
    void testCustomConverter() {
        Date format = properties.getExpireDate();

        var formater = new SimpleDateFormat("yyyy-MM-dd");
        Assertions.assertEquals("2024-02-20", formater.format(format));
    }

//    @Test
//    void testCustomConverter2() {
//        Date expireDate = properties.getExpireDate();
//
//        var dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Assertions.assertEquals("2020-10-10", dateFormat.format(expireDate));
//    }

    @SpringBootApplication
    @EnableConfigurationProperties({
            ApplicationProperties.class
    })
    @Import(StringToDateConverter.class)
    public static class TestApplicationConfig{

        @Bean
        public ConversionService conversionService(StringToDateConverter stringToDateConverter) {
            ApplicationConversionService conversionService = new ApplicationConversionService();
            conversionService.addConverter(stringToDateConverter);
            return conversionService;
        }
    }
}
