package com.manage.classInfo.config;
 
import java.util.Properties;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import com.github.pagehelper.PageHelper;
 
/**
 * @ClassName:PageHelperConfig
 * @Description:mybatis分页插件配置
 * @date:2020年3月6日 上午10:30:16
 */
@Configuration
public class PageHelperConfig {
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}