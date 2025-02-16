package by.lovify;

import by.lovify.constructor.properties.CharacterPreviewProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({
    CharacterPreviewProperties.class
})
@SpringBootApplication
public class LovifyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LovifyServerApplication.class, args);
    }

}
