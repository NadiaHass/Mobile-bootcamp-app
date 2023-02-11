package com.example.mobilebootcamp.models;

import java.io.Serializable;

public class Lesson implements Serializable {

    String name;
    String javaCode;
    String xmlCode;
    String resultFragmentName;

    public Lesson(String name, String javaCode, String xmlCode, String resultFragmentName) {
        this.name = name;
        this.javaCode = javaCode;
        this.xmlCode = xmlCode;
        this.resultFragmentName = resultFragmentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJavaCode() {
        return javaCode;
    }

    public void setJavaCode(String javaCode) {
        this.javaCode = javaCode;
    }

    public String getXmlCode() {
        return xmlCode;
    }

    public void setXmlCode(String xmlCode) {
        this.xmlCode = xmlCode;
    }

    public String getResultFragmentName() {
        return resultFragmentName;
    }

    public void setResultFragmentName(String resultFragmentName) {
        this.resultFragmentName = resultFragmentName;
    }
}
