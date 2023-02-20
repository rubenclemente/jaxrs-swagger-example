package org.example;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.ResourceBundle;

@ApplicationPath("/")
public class RestConfiguration extends Application {

    private static String host;
    private static String port;

    public RestConfiguration() {
        ResourceBundle rb = ResourceBundle.getBundle("config");
        host = rb.getString("api.host");
        port = rb.getString("api.port");
        configureSwagger();
    }

    private static void configureSwagger() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setSchemes(new String[] {"http"});
        beanConfig.setHost(String.format("%s:%s", host, port));
        beanConfig.setVersion("1.0.0");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("org.example.rest");
        beanConfig.setDescription("Rest API Example Description");
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true);
    }

}
