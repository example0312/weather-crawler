package org.cnu.realcoding.weathercrawler.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 아래와 같이 Controller 클래스에 @RequestMapping 을 붙이면
 * 아래 Controller 클래스에서 제공되는 Endpoints(API) 들의 기본 URI 가 다음과 같이 매핑된다.
 * http://localhost:8080/weather-crawler
 */
@RestController
@RequestMapping("/weather-crawler")
public class WeatherController {
}
