package com.example.Middleware01.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class LegacyInterceptor implements HandlerInterceptor {

    // Prima della chiamata API
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURL().toString().contains("/legacy")) {
            response.setStatus(HttpStatus.GONE.value());
            throw new Exception ("API legacy non più supportata.");
        }
        return true; // Restituisce true per consentire la chiamata API, false per bloccarla
    }

}