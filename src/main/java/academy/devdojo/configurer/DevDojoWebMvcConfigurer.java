package academy.devdojo.configurer;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

public class DevDojoWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        PageableHandlerMethodArgumentResolver pageableHandler = new PageableHandlerMethodArgumentResolver();
        pageableHandler.setFallbackPageable(PageRequest.of(1, 5));
        resolvers.add(pageableHandler);
        WebMvcConfigurer.super.addArgumentResolvers(resolvers);
    }
}
