package shop.mtcoding.filmtalk.core.config;

import com.siot.IamportRestClient.IamportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    String apiKey = "7335441440356078";
    String secretKey = "anQNUTQWUONgWTDOo08kNa0JssJncXZ0ua7jqKw7YPZG5pvknRDfKoe5SE67yjPmWLO4KzOZj3Ruv2mv";

    @Bean
    public IamportClient iamportClient() {
        return new IamportClient(apiKey, secretKey);
    }
}
