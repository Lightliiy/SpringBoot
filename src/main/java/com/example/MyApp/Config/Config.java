package com.example.MyApp.Config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface Config {
    void configure(HttpSecurity http) throws Exception;
}
