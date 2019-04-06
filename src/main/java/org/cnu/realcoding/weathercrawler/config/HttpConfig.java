package org.cnu.realcoding.weathercrawler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpConfig {
/**
 * @Bean 어노테이션을 추가함으로써 일어나는 일들
 * 1. Spring boot application 이 시작될 때 함께 시작되는 Spring container 가 @Bean 어노테이션이 붙은 메소드를 평생 "한 번"만 실행한다.
 * 2. 실행 후 반환받은 RestTemplate 객체를 container 에 보관한다. (IoC)
 * 3. 우리 프로젝트 안에서 아래와 같이 @Autowired 어노테이션과 함께 RestTemplate 필드를 선언했을 경우,
 *    Container 안에서 보관중인 RestTemplate 객체를 주입(DI)해 준다.
 * @Autowired RestTemplate restTemplate;
 */
    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}
