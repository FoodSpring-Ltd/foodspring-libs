package com.foodspring.utils;
/*
IntelliJ IDEA 2022.2.2 (Community Edition)
Build #IC-222.4167.29, built on September 13, 2022
Runtime version: 17.0.4+7-b469.53 amd64
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 9/3/2023 7:16 AM
@Last Modified 9/3/2023 7:16 AM
Version 1.0
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.util.Map;

public class PDFGeneratorUtil {
    private Logger LOG = LoggerFactory.getLogger(PDFGeneratorUtil.class);
    private final TemplateEngine templateEngine;

    public PDFGeneratorUtil() {
        this.templateEngine = new TemplateEngine();
    }

    private final StringBuilder sBuild = new StringBuilder();

    public byte[] htmlToPdf(String contentHTML, Map<String, Object> map) throws Exception {

        Context ctx = new Context();
        for (Map.Entry<String, Object> pair : map.entrySet()) {
            ctx.setVariable(pair.getKey(), pair.getValue());
        }

        String processedHtml = templateEngine.process(contentHTML, ctx);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(processedHtml);
            renderer.layout();
            renderer.createPDF(outputStream, false);
            renderer.finishPDF();
            renderer.getOutputDevice().getWriter().flush();
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }
        return outputStream.toByteArray();
    }
}


