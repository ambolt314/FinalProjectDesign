package com.example.emailGeneratorAPI.templates;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class TemplateUtils {

    public static String buildStringFromTemplate(Template template, Map<String, Object> dataModel) throws TemplateException, IOException {
        StringWriter stringOut = new StringWriter();
        template.process(dataModel, stringOut);
        return stringOut.toString();
    }
}
