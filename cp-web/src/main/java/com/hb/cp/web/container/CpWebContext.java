package com.hb.cp.web.container;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

/**
 * ========== cp项目上下文 ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.web.container.CpWebContext.java, v1.0
 * @date 2019年09月20日 16时43分
 */
@Component
public class CpWebContext {

    /**
     * the constant log
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CpWebContext.class);

    /**
     * spring环境的Property配置，用于配置文件中使用占位符替换
     *
     * @return the property placeholder configurer
     */
    @Bean
    public static PropertyPlaceholderConfigurer propertyConfigurer() {
        PropertyPlaceholderConfigurer propertyConfigurer = new PropertyPlaceholderConfigurer();
        propertyConfigurer.setProperties(loadProperties());
        return propertyConfigurer;
    }

    /**
     * ########## 加载一定格式的yml文件 ##########
     */
    private static Properties loadProperties() {
        YamlPropertiesFactoryBean applicationProperties = new YamlPropertiesFactoryBean();
        Resource[] resources = null;
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            resources = resolver.getResources("classpath*:config/service-*-config.yml");
            if (resources.length > 0) {
                for (Resource resource : resources) {
                    LOGGER.info("load {}", resource.getURL().toString());
                }
            }
            applicationProperties.setResources(resources);
            return applicationProperties.getObject();
        } catch (IOException e) {
            LOGGER.error("load yml config error!");
        }
        return null;
    }

}
