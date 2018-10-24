package test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = myClassTest.Config.class) // но тогда нужен new PropertySourcesPlaceholderConfigurer()
@ContextConfiguration(classes = {myClassTest.class}) //А так долго грузится.
@TestPropertySource("classpath:test.properties")
@SpringBootTest // !!! Make new PropertySourcesPlaceholderConfigurer() not required in the code
public class myClassTest {

    @Value("${my.filename}")
    String filename;

    @Test
    public void testValueSetup() {
        System.err.println(filename);
    }

//    @Configuration
//    static class Config {
//        @Bean
//        public static PropertySourcesPlaceholderConfigurer propertiesResolver() {
//            return new PropertySourcesPlaceholderConfigurer();
//        }
//    }
}
