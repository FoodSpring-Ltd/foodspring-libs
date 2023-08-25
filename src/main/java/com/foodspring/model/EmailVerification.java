package com.foodspring.model;
/*
IntelliJ IDEA 2022.2.2 (Community Edition)
Build #IC-222.4167.29, built on September 13, 2022
Runtime version: 17.0.4+7-b469.53 amd64
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 8/25/2023 5:52 AM
@Last Modified 8/25/2023 5:52 AM
Version 1.0
*/

import com.foodspring.constant.EmailType;

import java.io.Serializable;

public class EmailVerification implements Serializable {
    private String email;
    private String subject;
    private String description;
    private String verification;
    private Enum<EmailType> emailType;

    private String fullName;


    public EmailVerification(String email) {
        this.email = email;
    }

    public EmailVerification(String email, String subject) {
        this.email = email;
        this.subject = subject;
    }

    public EmailVerification(String email, String subject, String description) {
        this.email = email;
        this.subject = subject;
        this.description = description;
    }

    public EmailVerification(String email, String subject, String description, String verification) {
        this.email = email;
        this.subject = subject;
        this.description = description;
        this.verification = verification;
    }
    public EmailVerification(String email, String subject, String description, String verification, String fullName) {
        this.email = email;
        this.subject = subject;
        this.description = description;
        this.verification = verification;
        this.fullName = fullName;
    }
    public EmailVerification(String email, String subject, String description, String verification, String fullName, Enum<EmailType> emailType) {
        this.email = email;
        this.subject = subject;
        this.description = description;
        this.verification = verification;
        this.fullName = fullName;
        this.emailType = emailType;
    }

    private EmailVerification(Builder builder) {
        this.email = builder.email;
        this.subject = builder.subject;
        this.description = builder.description;
        this.verification = builder.verification;
        this.fullName = builder.fullName;
        this.emailType = builder.emailType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Enum<EmailType> getEmailType() {
        return this.emailType;
    }

    public void setEmailType(Enum<EmailType> emailType) {
        this.emailType = emailType;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public String getVerification() {
        return verification;
    }

    @Override
    public String toString() {
        return String.format("EmailVerification(email=%s, subject=%s, description=%s, verification=%s)",
                getEmail(), getSubject(), getDescription(), getVerification());
    }
    public static class Builder{
        private String email;
        private String subject;
        private String description;
        private String verification;
        private String fullName;
        private Enum<EmailType> emailType;

        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        public Builder verification(String verification) {
            this.verification = verification;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder emailType(Enum<EmailType> emailType) {
            this.emailType = emailType;
            return this;
        }

        public EmailVerification build() {
            return new EmailVerification(this);
        }
    }
}
