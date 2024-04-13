package com.example.emailGeneratorAPI.templates;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import javax.annotation.PostConstruct;
import java.io.IOException;

public class MailTemplate {
    private static final String EMAIL_TEMPLATES_DIRECTORY = "/templates";

    private Configuration templateConfig;

    @PostConstruct
    public void init() {
        templateConfig = new Configuration(Configuration.VERSION_2_3_32);

        templateConfig.setClassForTemplateLoading(this.getClass(), EMAIL_TEMPLATES_DIRECTORY);

        templateConfig.setObjectWrapper(new DefaultObjectWrapper());

        templateConfig.setDefaultEncoding("UTF-8");

        templateConfig.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    public Template getTemplate(String name) throws IOException {
        return templateConfig.getTemplate(name);
    }
}
