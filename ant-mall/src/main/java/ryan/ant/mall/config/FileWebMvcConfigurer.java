package ryan.ant.mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileWebMvcConfigurer implements WebMvcConfigurer {
    /*
     Todo 将所有以 /upload/ 开头的静态资源在请求时都会映射到 D:\Java\UploadFile\\
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:\\Java\\UploadFile\\");
    }
}
