package test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
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
@ContextConfiguration(classes = FooTest.Config.class)
@TestPropertySource(properties = {
        "some.bar.value=testValue",
})
public class FooTest {

    @Value("${some.bar.value}")
    String bar;

    @Test
    public void testValueSetup() {
        assertEquals("testValue", bar);
    }

    private void assertEquals(String testValue, String bar) {
    }


    @Configuration
    static class Config {
        @Bean
        public static PropertySourcesPlaceholderConfigurer propertiesResolver() {
            return new PropertySourcesPlaceholderConfigurer();
        }
    }
}